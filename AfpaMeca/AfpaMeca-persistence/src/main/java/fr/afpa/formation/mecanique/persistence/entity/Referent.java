package fr.afpa.formation.mecanique.persistence.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue(value="Ref")
public class Referent extends Utilisateur {

	public Referent() {
		// TODO Auto-generated constructor stub
	}

	public Referent(String mail, String nom, String prenom, String telephone, String identifiant, String motDePasse,
			Date dateInscription, Date dateRadiation) {
		super(mail, nom, prenom, telephone, identifiant, motDePasse, dateInscription, dateRadiation);
		// TODO Auto-generated constructor stub
	}

	public Referent(Long id, String mail, String nom, String prenom, String telephone, String identifiant,
			String motDePasse, Date dateInscription, Date dateRadiation) {
		super(id, mail, nom, prenom, telephone, identifiant, motDePasse, dateInscription, dateRadiation);
		// TODO Auto-generated constructor stub
	}

}
