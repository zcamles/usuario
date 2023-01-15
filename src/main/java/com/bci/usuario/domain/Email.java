package com.bci.usuario.domain;

public class Email {

	private static String REGEX = "^[a-zA-Z]*@dominio.cl";

	private String value;
	
	
	public Email(String email) {
		
		if(!email.matches(REGEX)) {
			throw new InvalidEmail(email, REGEX);
		}
		
		this.value = email;
	
	}
	
	public String getValue() {
		return this.value;
	}
	
	
}
