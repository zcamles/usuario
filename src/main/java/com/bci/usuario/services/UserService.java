package com.bci.usuario.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bci.usuario.configuration.PasswordPattern;
import com.bci.usuario.domain.Email;
import com.bci.usuario.domain.EmailAlreadyExists;
import com.bci.usuario.domain.Password;
import com.bci.usuario.dto.CreatedUserDTO;
import com.bci.usuario.dto.UserDTO;
import com.bci.usuario.entity.UserEntity;
import com.bci.usuario.repository.UserRepository;

@Service
public class UserService {

	private Logger logger = LoggerFactory.getLogger(UserService.class);

	private PasswordPattern passwordValidator;

	private UserRepository userRepository;

	@Autowired
	public UserService(PasswordPattern passwordValidator, UserRepository userRepository) {
		this.passwordValidator = passwordValidator;
		this.userRepository = userRepository;
	}

	public CreatedUserDTO signUp(UserDTO user) {
		Email email = new Email(user.getEmail());
		
		//Esto no cubre problema de carreras en sistemas de registro altamente concurridos
		if (this.userRepository.existsByEmail(email.getValue())) {
			throw new EmailAlreadyExists(email.getValue());
		}

		Password password = new Password(passwordValidator.getPattern(), user.getPassword());
		UserEntity entity = userRepository.save(new UserEntity(user.getName(), email, password));
		CreatedUserDTO createdUser = new CreatedUserDTO(entity.getId(), entity.getCreated(), entity.getModified(),
				entity.getLastLogin(), "XXX", entity.isActive());
		return createdUser;
	}

}
