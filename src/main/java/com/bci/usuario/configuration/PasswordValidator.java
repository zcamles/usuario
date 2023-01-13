package com.bci.usuario.configuration;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "sign.patterns")
public class PasswordValidator {

    private Logger logger = LoggerFactory.getLogger(PasswordValidator.class);
	
	private Pattern pattern;
	
	@ConstructorBinding
	public PasswordValidator(String password) {
		
		if(password == null || password.isBlank()) {
			logger.error("el regex obtenido de los properties es: {}", password);
			throw new IllegalArgumentException("el regex a utilizar para validar la contrasena es incorrecto, debe ser un regex valido!.");
		}
		
		try {
			this.pattern = Pattern.compile(password);
		}catch (PatternSyntaxException ex) {
			logger.error("el regex: {}, no es valido!.", password);
			logger.error("error", ex);
			throw ex;
		}
		
	}
	
	public boolean validate(String password) {
		boolean isPasswordCorrect = this.pattern.matcher(password).matches();
		this.pattern.matcher(password).reset();
		return isPasswordCorrect;
	}
	
}
