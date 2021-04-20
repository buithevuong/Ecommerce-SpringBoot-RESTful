package com.vuongltw.SneakerStore.service;

import java.util.List;

import com.vuongltw.SneakerStore.dto.PageDto;
import com.vuongltw.SneakerStore.dto.ProductDto;
import com.vuongltw.SneakerStore.dto.responsedto.ProductResponseDto;

public interface IProductService extends IGeneralService<ProductResponseDto , ProductDto>{
	
	Iterable<ProductResponseDto> findByProductName(String keyword);
	
	List<ProductResponseDto> listAll(PageDto pagedto);
}
