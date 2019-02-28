package fr.afpa;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.afpa.entity.Category;
import fr.afpa.entity.Image;
import fr.afpa.entity.Item;
import fr.afpa.entity.Warranty;
import fr.afpa.repository.CategoryRepository;
import fr.afpa.repository.ImageRepository;
import fr.afpa.repository.ItemRepository;
import fr.afpa.repository.WarrantyRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	private Log log = LogFactory.getLog(Application.class);

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ImageRepository imageRepository;

	@Autowired
	WarrantyRepository warrantyRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category category = new Category("name", "code", "description");
		Item item = new Item("test", "test", "test", 23.03);
		Image image = new Image("altText", "path", item);
		item.getListImage().add(image);
		item.getListCategory().add(category);
		itemRepository.save(item);
		imageRepository.save(image);
		Warranty warranty = new Warranty("summazeary", "fullTazeext", item);
		warrantyRepository.save(warranty);
	}

}

