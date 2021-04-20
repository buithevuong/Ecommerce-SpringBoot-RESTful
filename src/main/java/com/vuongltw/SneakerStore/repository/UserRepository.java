package com.vuongltw.SneakerStore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vuongltw.SneakerStore.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String username);
	
	//Boolean exitsByUserName(String username);
	
	//Boolean exitsByEmail(String email);
}
