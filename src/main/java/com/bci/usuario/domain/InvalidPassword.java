package com.bci.usuario.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidPassword extends RuntimeException {
	
    private static Logger logger = LoggerFactory.getLogger(InvalidPassword.class);

	private static final long serialVersionUID = 8513368135625665551L;
	
	public InvalidPassword(String password, String pattern) {
		super("La contrasena no cumple con el siguiente patron: " + pattern);
		logger.error("La contrasena: {} no cumple con el patron: {}.", password, pattern);
	}
	
}
