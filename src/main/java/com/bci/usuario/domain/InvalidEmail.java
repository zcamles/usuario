package com.bci.usuario.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidEmail extends RuntimeException {
	
    private static Logger logger = LoggerFactory.getLogger(InvalidEmail.class);

	private static final long serialVersionUID = 8513368135625665551L;
	
	public InvalidEmail(String email, String pattern) {
		super("El correo no cumple con el siguiente patron: " + pattern);
		logger.error("El correo: {} no cumple con el patron: {}.", email, pattern);
	}
	
}
