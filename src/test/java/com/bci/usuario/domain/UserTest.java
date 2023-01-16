package com.bci.usuario.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

	@Test
	@DisplayName("contrasena incorrecta")
	void password_dont_match_with_pattern() {
		String badPassword = "hola12345hola..";
		Assertions.assertThrows(InvalidPassword.class, () -> {
			new Password(Pattern.compile("^(?=.*[A-Z])(?=.*\\d).{6}$"), badPassword);
		});
	}
	
	@Test
	@DisplayName("contrasena correcta")
	void password_match_with_pattern() {
		String goodPassword = "Hunte4";
		Password password = new Password(Pattern.compile("^(?=.*[A-Z])(?=.*\\d).{6}$"), goodPassword);
		assertThat(password.getValue()).containsIgnoringCase(goodPassword);
	}
	
}
