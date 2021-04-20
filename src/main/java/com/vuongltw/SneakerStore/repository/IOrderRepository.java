package com.vuongltw.SneakerStore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vuongltw.SneakerStore.entity.Order;

public interface IOrderRepository extends JpaRepository<Order, Long> {
	Order findByOrderid(Long id);
	
	@Query("Select o FROM Order o")
	Page<Order> getOrderByPage(Pageable pageable);
}
