package com.vuongltw.SneakerStore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuongltw.SneakerStore.dto.CartDto;
import com.vuongltw.SneakerStore.dto.DeleteDto;
import com.vuongltw.SneakerStore.entity.Cart;
import com.vuongltw.SneakerStore.mapper.ObjectMapperUtils;
import com.vuongltw.SneakerStore.repository.ICartRepository;
import com.vuongltw.SneakerStore.repository.IItemRepository;
import com.vuongltw.SneakerStore.service.ICartService;
@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	ICartRepository cartrepo;
	
	@Autowired
	IItemRepository itemrepo;
	
	@Override
	public Iterable<CartDto> findAll() {
		Iterable<CartDto> list = ObjectMapperUtils.toDto(cartrepo.findAll(), CartDto.class);
		return list;	}

	@Override
	public Optional<CartDto> findById(Long id) {
		Optional<CartDto> cartOptinal = Optional
				.of(ObjectMapperUtils.toDto(cartrepo.findByCartid(id), CartDto.class));
		return cartOptinal;
	}

	@Override
	public CartDto save(CartDto t) {
		
		
		Cart c = cartrepo.save(ObjectMapperUtils.toEntity(t, Cart.class));
		return ObjectMapperUtils.toDto(c, CartDto.class);
	}

	@Override
	public boolean remove(DeleteDto deletedto) {
		if (cartrepo.findByCartid(deletedto.getId()) != null) {
			cartrepo.deleteById(deletedto.getId());
			return true;
		}

		return false;
		
	}

}
