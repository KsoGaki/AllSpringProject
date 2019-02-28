package fr.afpa.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.afpa.formation.business.exception.SpecieAlreadyExistsException;
import fr.afpa.formation.business.exception.SpecieNotValidException;
import fr.afpa.formation.business.service.SpecieService;
import fr.afpa.formation.persistence.entity.Specie;

@Controller
public class SpecieController {

	@Autowired
	SpecieService specieService;

	@GetMapping("/specie")
	public String listSpecie(Model model) {
		List<Specie> listSpecie = specieService.findAll();
		model.addAttribute("listSpecie", listSpecie);
		return "specie";
	}

	@GetMapping("/specie/create")
	public String preCreateSpecie() {
		return "specieCreate";
	}

	@RequestMapping("/specie/do/create")
	public String createSpecie(
			@RequestParam(name="commonName", required=true) String commonName,
			@RequestParam(name="latinName", required=true) String latinName	) {
		try {
			specieService.create(new Specie(commonName, latinName));
		} catch (SpecieNotValidException e) {
			e.printStackTrace();
			return "redirect:/specie?error=1";
		} catch (SpecieAlreadyExistsException e) {
			e.printStackTrace();
			return "redirect:/specie?error=2";
		}
		return "redirect:/specie";
	}

	@GetMapping("/specie/{id}/delete")
	public String deleteSpecie(@PathVariable("id") Long id) {
		specieService.deleteById(id);
		return "redirect:/specie";
	}

	@GetMapping("/specie/{id}/update")
	public String preUpdateSpecie(@PathVariable("id") Long id, Model model) {
		Specie specie = specieService.findById(id);
		model.addAttribute("specieUpdate", specie);
		return "specieUpdate";
	}

	@RequestMapping("/specie/do/update")
	public String updateSpecie(
			@RequestParam(name="idSpecie", required=true) String idSpecie,
			@RequestParam(name="commonName", required=true) String commonName,
			@RequestParam(name="latinName", required=true) String latinName	) {
		try {
			specieService.update(new Specie(Long.parseLong(idSpecie), commonName, latinName));
		} catch (SpecieNotValidException e) {
			e.printStackTrace();
			return "redirect:/specie?error=1";
		}
		return "redirect:/specie";
	}

}
