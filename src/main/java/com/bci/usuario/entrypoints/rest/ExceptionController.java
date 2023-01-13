package com.bci.usuario.entrypoints.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.bci.usuario.dto.MessageDTO;

@RestControllerAdvice
public class ExceptionController {

    private Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	protected MessageDTO<String> handleConflict(Exception ex, WebRequest request) {
		logger.error("exception no controlada en el sistema en la sesion: " + request.getSessionId(), ex);
		return new MessageDTO<String>("Comuniquese con los desarrolladores y informe este codigo: " + request.getSessionId());
	}

}
