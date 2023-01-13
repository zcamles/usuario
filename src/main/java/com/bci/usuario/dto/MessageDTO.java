package com.bci.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDTO <O> {

	@JsonProperty("mensaje")
	private O message;
	
	public MessageDTO(O value) {
		this.message = value;
	}
	
	public O getMessage() {
		return this.message;
	}
	
}
