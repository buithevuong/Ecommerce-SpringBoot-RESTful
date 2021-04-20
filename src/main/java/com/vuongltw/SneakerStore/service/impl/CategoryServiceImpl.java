package com.vuongltw.SneakerStore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuongltw.SneakerStore.dto.CategoryDto;
import com.vuongltw.SneakerStore.dto.responsedto.CategoryResponseDto;
import com.vuongltw.SneakerStore.entity.Category;
import com.vuongltw.SneakerStore.mapper.ObjectMapperUtils;
import com.vuongltw.SneakerStore.repository.ICategoryRepository;
import com.vuongltw.SneakerStore.service.ICategoryService;
@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	ICategoryRepository caterepo;

	

	@Override
	public Iterable<CategoryResponseDto> findAll() {
		Iterable<CategoryResponseDto> list = ObjectMapperUtils.toDto(caterepo.findAll(), CategoryResponseDto.class);
		return list;
	}

	@Override
	public Optional<CategoryResponseDto> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryResponseDto save(CategoryDto t) {
		Category c = caterepo.save(ObjectMapperUtils.toEntity(t, Category.class));
		return ObjectMapperUtils.toDto(c, CategoryResponseDto.class);
	}

	@Override
	public boolean remove(Long id) {
		return false;
		// TODO Auto-generated method stub
		
	}
	
	

}
