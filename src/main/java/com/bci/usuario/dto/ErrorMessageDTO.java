package com.bci.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorMessageDTO {

	@JsonProperty("session")
	private String session;

	@JsonProperty("message")
	private String message;

	public ErrorMessageDTO(String session, String message) {
		this.message = message;
		this.session = session;
	}

	public String getSession() {
		return session;
	}

	public String getMessage() {
		return message;
	}

}
