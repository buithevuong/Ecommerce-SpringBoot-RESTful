package com.vuongltw.SneakerStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vuongltw.SneakerStore.entity.Cart;

public interface ICartRepository extends JpaRepository<Cart, Long> {
	Cart findByCartid(Long id);
}
