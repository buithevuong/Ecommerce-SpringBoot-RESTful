package com.vuongltw.SneakerStore.service;

import java.util.List;

import com.vuongltw.SneakerStore.dto.PageDto;
import com.vuongltw.SneakerStore.dto.ProductDto;

public interface IProductService extends IGeneralService<ProductDto>{
	
	Iterable<ProductDto> findByProductName(String keyword);
	
	List<ProductDto> listAll(PageDto pagedto);
	
	
	public Iterable<ProductDto> findByType(String type);
}
