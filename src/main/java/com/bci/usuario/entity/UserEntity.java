package com.bci.usuario.entity;

import java.time.LocalDate;
import java.util.UUID;

import com.bci.usuario.domain.Email;
import com.bci.usuario.domain.Password;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@Column(name = "id")
	private UUID id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
	@Column(name = "created")
	private LocalDate created;

	@Column(name = "modified")
	private LocalDate modified;

	@Column(name = "last_login")
	private LocalDate lastLogin;

	@Column(name = "is_active")
	private boolean isActive;
	
	private UserEntity() {
		
	}
	
	public UserEntity(String name, Email email, Password password) {
		super();
		this.id = UUID.randomUUID();
		this.name = name;
		this.email = email.getValue();
		this.password = password.getValue();
		this.created = LocalDate.now();
		this.modified = LocalDate.now();
		this.lastLogin = LocalDate.now();
		this.isActive = true;
	}

	public UUID getId() {
		return id;
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

	public LocalDate getCreated() {
		return created;
	}

	public LocalDate getModified() {
		return modified;
	}

	public LocalDate getLastLogin() {
		return lastLogin;
	}

	public boolean isActive() {
		return isActive;
	}
	
}
