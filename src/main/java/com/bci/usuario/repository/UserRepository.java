package com.bci.usuario.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bci.usuario.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID>{

	boolean existsByEmail(String email);
	
}
