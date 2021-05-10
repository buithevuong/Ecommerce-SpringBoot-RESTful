package com.vuongltw.SneakerStore.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vuongltw.SneakerStore.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
	@Query("SELECT e FROM Product e WHERE e.productName LIKE %?1%")
	List<Product> findByProductName(String keyword);

	Product findByProductid(Long id);

	List<Product> findByType(String type);
	
	@Query("SELECT e FROM Product e")
	Page<Product> getAllProduct(Pageable pageable);
}
