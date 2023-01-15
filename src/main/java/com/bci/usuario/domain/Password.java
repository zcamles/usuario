package com.bci.usuario.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

	private String value;
	
	public Password(Pattern pattern, String password) {
		if(pattern == null) {
			throw new IllegalArgumentException("Debe ser una instancia de Pattern valida!");
		}

		Matcher matcher = pattern.matcher(password);

		if(!matcher.matches()) {
			throw new InvalidPassword(password, pattern.toString());
		}
		
		this.value = password;
	}
	
	public String getValue() {
		return this.value;
	}
	
}
