package com.bci.usuario.entrypoints.rest;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bci.usuario.configuration.PasswordValidator;
import com.bci.usuario.dto.CreatedUserDTO;
import com.bci.usuario.dto.MessageDTO;
import com.bci.usuario.dto.UserDTO;

@RestController
@RequestMapping("usuarios")
public class UsuarioREST {

    private Logger logger = LoggerFactory.getLogger(UsuarioREST.class);
    
    private PasswordValidator passwordValidator;
    
    @Autowired
	public UsuarioREST(PasswordValidator passwordValidator) {
		this.passwordValidator = passwordValidator;
	}

	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageDTO<CreatedUserDTO>> signup(@RequestBody UserDTO usuario) {
		
		if(logger.isDebugEnabled()) {
			logger.debug("user: {} wants to sign up.", usuario);
		}
		
		CreatedUserDTO createdUser = new CreatedUserDTO("ajdfasdf", LocalDate.now(), LocalDate.now(), LocalDate.now(), "token", false);
		
		if(!createdUser.isActive()) {
			throw new NullPointerException("asdfasd");
		}
		
		return ResponseEntity.ok(new MessageDTO<CreatedUserDTO>(createdUser));
	}
	
}
