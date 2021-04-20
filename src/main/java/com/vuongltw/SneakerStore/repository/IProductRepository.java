package com.vuongltw.SneakerStore.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vuongltw.SneakerStore.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByProductName(String keyword);

	Product findByProductid(Long id);

	@Query("SELECT e FROM Product e")
	Page<Product> getAllProduct(Pageable pageable);
}
