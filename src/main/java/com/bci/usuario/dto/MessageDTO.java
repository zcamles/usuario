package com.bci.usuario.dto;

public class MessageDTO <O> {

	private O message;
	
	public MessageDTO(O value) {
		this.message = value;
	}
	
	public O getMessage() {
		return this.message;
	}
	
}
