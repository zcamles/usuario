package com.bci.usuario.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailAlreadyExists extends RuntimeException {
	
    private static Logger logger = LoggerFactory.getLogger(EmailAlreadyExists.class);

	private static final long serialVersionUID = 8513368135625665551L;
	
	public EmailAlreadyExists(String email) {
		super("El correo '" + email + "' ya existe!.");
		logger.error("El correo {} ya existe!.", email);
	}
	
}
