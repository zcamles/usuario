package com.bci.usuario.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioDTO {

	private String name;
	private String email;
	private String password;
	private List<PhoneDTO> phones;

	@JsonCreator(mode = Mode.PROPERTIES)
	public UsuarioDTO(
			@JsonProperty("name") String name,
			@JsonProperty("email") String email, 
			@JsonProperty("password") String password, 
			@JsonProperty("phones") List<PhoneDTO> phones) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<PhoneDTO> getPhones() {
		return phones;
	}

	@Override
	public String toString() {
		return "Usuario: " + this.name + ", mail: " + this.email + ", " + this.phones;
	}

}
