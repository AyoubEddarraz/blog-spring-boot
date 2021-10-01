package com.app.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blog.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	UserEntity findByEmail(String email);
	
}
