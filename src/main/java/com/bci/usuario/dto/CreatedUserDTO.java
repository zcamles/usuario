package com.bci.usuario.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatedUserDTO {

	@JsonProperty("id")
	private UUID id;

	@JsonProperty("created")
	private LocalDate created;

	@JsonProperty("modified")
	private LocalDate modified;

	@JsonProperty("lastLogin")
	private LocalDate lastLogin;

	@JsonProperty("uuid")
	private String uuid;

	@JsonProperty("isActive")
	private boolean isActive;

	public CreatedUserDTO(UUID id, LocalDate created, LocalDate modified, LocalDate lastLogin, String uuid,
			boolean isActive) {
		this.id = id;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
		this.uuid = uuid;
		this.isActive = isActive;
	}

	public UUID getId() {
		return id;
	}

	public LocalDate getCreated() {
		return created;
	}

	public LocalDate getModified() {
		return modified;
	}

	public LocalDate getLastLogin() {
		return lastLogin;
	}

	public String getUuid() {
		return uuid;
	}

	public boolean isActive() {
		return isActive;
	}

	@Override
	public String toString() {
		return "CreatedUserDTO [id=" + id + ", created=" + created + ", modified=" + modified + ", lastLogin="
				+ lastLogin + ", uuid=" + uuid + ", isActive=" + isActive + "]";
	}

}
