package com.vuongltw.SneakerStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vuongltw.SneakerStore.entity.Category;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
	Category findByCategoryid(Long id);

}
