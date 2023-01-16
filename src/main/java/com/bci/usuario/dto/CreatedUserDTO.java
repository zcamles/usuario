package com.bci.usuario.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatedUserDTO {

	@JsonProperty("id")
	private UUID id;

	@JsonProperty("created")
	private LocalDateTime created;

	@JsonProperty("modified")
	private LocalDateTime modified;

	@JsonProperty("lastLogin")
	private LocalDateTime lastLogin;

	@JsonProperty("token")
	private String token;

	@JsonProperty("isActive")
	private boolean isActive;

	public CreatedUserDTO(UUID id, LocalDateTime created, LocalDateTime modified, LocalDateTime lastLogin, String token,
			boolean isActive) {
		this.id = id;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
		this.token = token;
		this.isActive = isActive;
	}

	public UUID getId() {
		return id;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public String getToken() {
		return token;
	}

	public boolean isActive() {
		return isActive;
	}

}
