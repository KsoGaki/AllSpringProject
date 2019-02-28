package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThirdClass {
	
	@Autowired
	private SecondClass secondClass;
	
	private String string = "Je suis la ThirdClass ";
	
	public String getString() {
		return string + secondClass.getString();
	}
	

}
