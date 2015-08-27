package ba.bitcamp.homework28.tasks.task2;

import java.math.BigDecimal;
/**
 * Class representing a product.
 * @author Semir
 *
 */
public class Product {

	private String id;
	private String name;
	private BigDecimal price;
	
	/**
	 * @param id
	 * @param name
	 * @param price
	 */
	public Product(String id, String name, BigDecimal price) {
		super();
		if (id.length() < 10) {
			for (int i = id.length(); i < 10; i++) {
				id = "0" + id; 
			}
		}
		this.id = id;
		this.name = name;
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return id + ": " + name + " - " + price;
	}
	
}
