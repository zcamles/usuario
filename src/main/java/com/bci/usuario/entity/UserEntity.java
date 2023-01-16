package com.bci.usuario.entity;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.UUID;

import com.bci.usuario.domain.Email;
import com.bci.usuario.domain.Password;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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
	private LocalDateTime created;

	@Column(name = "modified")
	private LocalDateTime modified;

	@Column(name = "last_login")
	private LocalDateTime lastLogin;

	@Column(name = "token")
	private String token;

	@Column(name = "is_active")
	private boolean isActive;

	private UserEntity() {

	}

	public UserEntity(String name, Email email, Password password) {
		super();
		KeyPairGenerator keyGenerator;
		try {
			keyGenerator = KeyPairGenerator.getInstance("RSA");
			keyGenerator.initialize(2048);
			
			KeyPair kp = keyGenerator.genKeyPair();
			PublicKey publicKey = (PublicKey) kp.getPublic();
			PrivateKey privateKey = (PrivateKey) kp.getPrivate();
			
			this.id = UUID.randomUUID();
			this.name = name;
			this.email = email.getValue();
			this.password = password.getValue();
			this.created = LocalDateTime.now();
			this.modified = LocalDateTime.now();
			this.lastLogin = LocalDateTime.now();
			this.token = Jwts.builder().claim("name", this.name).claim("email", this.email).setSubject("bci")
					.setId(UUID.randomUUID().toString()).setIssuedAt(Date.from(this.modified.toInstant(ZoneOffset.UTC)))
					.setExpiration(Date.from(this.modified.toInstant(ZoneOffset.UTC)))
					.signWith(privateKey).compact();
			this.isActive = true;
		} catch (NoSuchAlgorithmException e) {
			
		}
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
