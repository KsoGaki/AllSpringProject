package fr.formation.afpa.main;

import java.util.concurrent.atomic.AtomicInteger;

public class Product {

	private static final AtomicInteger atomicInteger = new AtomicInteger(0);
	
	private int id;
	private String string;
	private int value;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	public Product( String string, int value) {
		super();
		this.id = atomicInteger.getAndIncrement();
		this.string = string;
		this.value = value;
	}

	public Product() {
		this.id = atomicInteger.getAndIncrement();
	}
	
	@Override
	public String toString() {
		return string + " " + value;
	}
	
}
