package fr.afpa.formation;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afpa.formation.entity.Category;
import fr.afpa.formation.entity.Item;
import fr.afpa.formation.entity.ItemOrder;
import fr.afpa.formation.entity.Order;
import fr.afpa.formation.reposiroty.CategoryRepository;
import fr.afpa.formation.reposiroty.ItemOrderRepository;
import fr.afpa.formation.reposiroty.ItemRepository;
import fr.afpa.formation.reposiroty.OrderRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=SmallAppTest.class)
@DataJpaTest
public class ApplicationTests {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ItemOrderRepository itemOrderRepository;

	private int nbCategory = 0;
	private int nbItem = 0;
	private int nbOrder = 0;
	private int nbItemOrder = 0;

	@Before
	public void setUp() {
		Category firstCategory = new Category("firstCategory");
		Category secondCategory = new Category("secondCategory");	
		firstCategory = testEntityManager.persist(firstCategory);
		secondCategory = testEntityManager.persist(secondCategory);
		nbCategory = 2;

		Item firstItem = new Item("KSKDJ84JSS", "firstItem", 10.00, firstCategory);
		Item secondItem = new Item("K454D4JSS", "secondItem", 5.35, firstCategory);
		firstItem = testEntityManager.persist(firstItem);
		secondItem = testEntityManager.persist(secondItem);
		nbItem = 2;

		Date firstDate = new Date(2014);
		Date secondDate = new Date(2017);
		Order firstOrder = new Order(firstDate);
		Order secondOrder = new Order(secondDate);
		firstOrder = testEntityManager.persist(firstOrder);
		secondOrder = testEntityManager.persist(secondOrder);
		nbOrder = 2;

		ItemOrder firstItemOrder = new ItemOrder(firstItem, firstOrder, 10);
		ItemOrder secondItemOrder = new ItemOrder(secondItem, firstOrder, 5);
		ItemOrder thirdItemOrder = new ItemOrder(secondItem, secondOrder, 7);
		firstItemOrder = testEntityManager.persist(firstItemOrder);
		secondItemOrder = testEntityManager.persist(secondItemOrder);
		thirdItemOrder = testEntityManager.persist(thirdItemOrder);
		nbItemOrder = 3;

	}

	@Test
	public void testCategory() {
		List<Category> listCategory = (List<Category>) categoryRepository.findAll();
		assertEquals(listCategory.size(), nbCategory);
	}

	@Test
	public void testItem() {
		List<Item> listItem = (List<Item>) itemRepository.findAll();
		assertEquals(listItem.size(), nbItem);
	}

	@Test
	public void testOrder() {
		List<Order> listOrder = (List<Order>) orderRepository.findAll();
		assertEquals(listOrder.size(), nbOrder);
	}

	@Test
	public void testItemOrder() {
		List<ItemOrder> listItemOrder = (List<ItemOrder>) itemOrderRepository.findAll();
		assertEquals(listItemOrder.size(), nbItemOrder);
	}

	@After
	public void tearDown() {
		testEntityManager.getEntityManager().createNativeQuery("ALTER TABLE Category ALTER COLUMN id_Category RESTART WITH 1").executeUpdate();
		testEntityManager.getEntityManager().createNativeQuery("ALTER TABLE Item ALTER COLUMN id_Item RESTART WITH 1").executeUpdate(); 
		testEntityManager.getEntityManager().createNativeQuery("ALTER TABLE Orders ALTER COLUMN id_Order RESTART WITH 1").executeUpdate();
	}

}

