package com.vuongltw.SneakerStore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vuongltw.SneakerStore.common.ERole;
import com.vuongltw.SneakerStore.entity.Role;

public interface RoleRepository  extends JpaRepository<Role, Long>{

	Optional<Role> findByName (ERole name);
	}
