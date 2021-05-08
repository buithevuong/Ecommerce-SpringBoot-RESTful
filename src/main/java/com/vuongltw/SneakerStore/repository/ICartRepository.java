package com.vuongltw.SneakerStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vuongltw.SneakerStore.entity.Cart;

public interface ICartRepository extends JpaRepository<Cart, Long> {
	Cart findByCartid(Long id);
	
	@Query(value = "SELECT e.* FROM cart e WHERE e.user_id=?", nativeQuery = true)
	Cart findByUserid(Long id);
}
