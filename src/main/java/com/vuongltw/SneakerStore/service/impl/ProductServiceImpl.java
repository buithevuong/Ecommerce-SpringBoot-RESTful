package com.vuongltw.SneakerStore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vuongltw.SneakerStore.dto.PageDto;
import com.vuongltw.SneakerStore.dto.ProductDto;
import com.vuongltw.SneakerStore.dto.responsedto.ProductResponseDto;
import com.vuongltw.SneakerStore.entity.Product;
import com.vuongltw.SneakerStore.mapper.ObjectMapperUtils;
import com.vuongltw.SneakerStore.repository.IProductRepository;
import com.vuongltw.SneakerStore.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	IProductRepository prorepo;

	@Override
	public Iterable<ProductResponseDto> findAll() {
		Iterable<ProductResponseDto> list = ObjectMapperUtils.toDto(prorepo.findAll(), ProductResponseDto.class);
		return list;
	}

	@Override
	public List<ProductResponseDto> listAll(PageDto pagedto) {
		Pageable pageable = PageRequest.of(pagedto.getOffset(), pagedto.getLimit(), Sort.by("productName") );
		
		Page<Product> productPage = prorepo.getAllProduct(pageable);
		System.out.println(productPage);
		List<ProductResponseDto> list = customizePage(productPage);
		System.out.println(list);
		return list;
	}
	
	@Override
	public Optional<ProductResponseDto> findById(Long id) {
		if(id == null) {
			return null;
		}else {
			Optional<ProductResponseDto> productOptinal = Optional
					.of(ObjectMapperUtils.toDto(prorepo.findByProductid(id), ProductResponseDto.class));
			return productOptinal;
		}
		
	}

	public Iterable<ProductResponseDto> findByProductName(String keyword) {
		List<Product> product =  prorepo.findByProductName(keyword);
		if(keyword == null) {
			return null;
		} else if(product == null) {
			return null;
		}else {
			Iterable<ProductResponseDto> list = ObjectMapperUtils.toDto(product, ProductResponseDto.class);
			return list;
		}
	
	}

	
	@Override
	public ProductResponseDto save(ProductDto t) {
		if( t == null) {
			return null;
		} else {
			Product p = prorepo.save(ObjectMapperUtils.toEntity(t, Product.class));
			return ObjectMapperUtils.toDto(p, ProductResponseDto.class);
		}
		
	}

	@Override
	public boolean remove(Long id) {
		if (prorepo.findByProductid(id) != null) {
			prorepo.deleteById(id);
			return true;
		}

		return false;

	}

	private List<ProductResponseDto> customizePage(Page<Product> page) {
		List<Product> listproduct = page.getContent();
		List<ProductResponseDto> productResponseDto = ObjectMapperUtils.toDto(listproduct, ProductResponseDto.class);
		return productResponseDto;
	}

}
