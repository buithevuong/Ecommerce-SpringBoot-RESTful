package com.vuongltw.SneakerStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vuongltw.SneakerStore.entity.Item;

public interface IItemRepository extends JpaRepository<Item, Long> {
	
	Item findByItemid(Long id);
	
	@Query(value = "SELECT * FROM sneaker_store.item where cart_id= ?1",nativeQuery = true)
	List<Item> findAllByCartid(Long id);
}
