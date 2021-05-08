package com.vuongltw.SneakerStore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vuongltw.SneakerStore.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long>{
	Optional<UserEntity> findByUsername(String keyword);

	Optional<UserEntity> findByUserid(Long id);
}
