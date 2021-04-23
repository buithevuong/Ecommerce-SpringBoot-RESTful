package com.vuongltw.SneakerStore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuongltw.SneakerStore.dto.CategoryDto;
import com.vuongltw.SneakerStore.dto.DeleteDto;
import com.vuongltw.SneakerStore.entity.Category;
import com.vuongltw.SneakerStore.mapper.ObjectMapperUtils;
import com.vuongltw.SneakerStore.repository.ICategoryRepository;
import com.vuongltw.SneakerStore.service.ICategoryService;
@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	ICategoryRepository caterepo;

	

	@Override
	public Iterable<CategoryDto> findAll() {
		Iterable<CategoryDto> list = ObjectMapperUtils.toDto(caterepo.findAll(), CategoryDto.class);
		return list;
	}

	@Override
	public Optional<CategoryDto> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDto save(CategoryDto t) {
		Category c = caterepo.save(ObjectMapperUtils.toEntity(t, Category.class));
		return ObjectMapperUtils.toDto(c, CategoryDto.class);
	}

	@Override
	public boolean remove(DeleteDto deletedto) {
		return false;
		// TODO Auto-generated method stub
		
	}
	
	

}
