package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecondClass {
	
	@Autowired
	private FirstClass firstClass;
	
	private String string =  "Je suis dans SecondClass ";
	
	public String getString() {
		return string  + firstClass.getString();
	}
	
	public FirstClass getFirstClass() {
		return firstClass;
	}
	
	
}
