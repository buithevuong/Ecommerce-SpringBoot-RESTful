package com.vuongltw.SneakerStore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vuongltw.SneakerStore.dto.DeleteDto;
import com.vuongltw.SneakerStore.dto.PageDto;
import com.vuongltw.SneakerStore.dto.ProductDto;
import com.vuongltw.SneakerStore.entity.Product;
import com.vuongltw.SneakerStore.mapper.ObjectMapperUtils;
import com.vuongltw.SneakerStore.repository.IProductRepository;
import com.vuongltw.SneakerStore.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	IProductRepository prorepo;

	@Override
	public Iterable<ProductDto> findAll() {
		Iterable<ProductDto> list = ObjectMapperUtils.toDto(prorepo.findAll(), ProductDto.class);
		return list;
	}

	@Override
	public List<ProductDto> listAll(PageDto pagedto) {
		Pageable pageable = PageRequest.of(pagedto.getOffset(), pagedto.getLimit(), Sort.by("productName") );
		
		Page<Product> productPage = prorepo.getAllProduct(pageable);
		System.out.println(productPage);
		List<ProductDto> list = customizePage(productPage);
		System.out.println(list);
		return list;
	}
	
	@Override
	public Optional<ProductDto> findById(Long id) {
		if(id == null) {
			return null;
		}else {
			Optional<ProductDto> productOptinal = Optional
					.of(ObjectMapperUtils.toDto(prorepo.findByProductid(id), ProductDto.class));
			return productOptinal;
		}
		
	}

	public Iterable<ProductDto> findByProductName(String keyword) {
		List<Product> product =  prorepo.findByProductName(keyword);
		System.out.println(keyword +"000000000 " +product);
		if(keyword == null) {
			return null;
		} else if(product == null) {
			return null;
		}else {
			Iterable<ProductDto> list = ObjectMapperUtils.toDto(product, ProductDto.class);
			System.out.println(list);
			return list;
		}
	
	}

	
	@Override
	public ProductDto save(ProductDto t) {
		if( t == null) {
			return null;
		} else {
			Product p = prorepo.save(ObjectMapperUtils.toEntity(t, Product.class));
			return ObjectMapperUtils.toDto(p, ProductDto.class);
		}
		
	}

	@Override
	public boolean remove(DeleteDto deletedto) {
		if (prorepo.findByProductid(deletedto.getId()) != null) {
			prorepo.deleteById(deletedto.getId());
			return true;
		}

		return false;

	}

	private List<ProductDto> customizePage(Page<Product> page) {
		List<Product> listproduct = page.getContent();
		List<ProductDto> productDto = ObjectMapperUtils.toDto(listproduct, ProductDto.class);
		return productDto;
	}

	@Override
	public Iterable<ProductDto> findByType(String type) {
		
		List<Product> product =  prorepo.findByType(type);
		System.out.println(type + "-------------------"+product);
		if(type == null) {
			return null;
		} else if(product == null) {
			
			return null;
		}else {
			Iterable<ProductDto> list = ObjectMapperUtils.toDto(product, ProductDto.class);
			System.out.println(list);
			return list;
		}
	}

}
