package com.vuongltw.SneakerStore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuongltw.SneakerStore.dto.CartDto;
import com.vuongltw.SneakerStore.dto.responsedto.CartResponseDto;
import com.vuongltw.SneakerStore.entity.Cart;
import com.vuongltw.SneakerStore.mapper.ObjectMapperUtils;
import com.vuongltw.SneakerStore.repository.ICartRepository;
import com.vuongltw.SneakerStore.service.ICartService;
@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	ICartRepository cartrepo;
	
	@Override
	public Iterable<CartResponseDto> findAll() {
		Iterable<CartResponseDto> list = ObjectMapperUtils.toDto(cartrepo.findAll(), CartResponseDto.class);
		return list;	}

	@Override
	public Optional<CartResponseDto> findById(Long id) {
		Optional<CartResponseDto> cartOptinal = Optional
				.of(ObjectMapperUtils.toDto(cartrepo.findByCartid(id), CartResponseDto.class));
		return cartOptinal;
	}

	@Override
	public CartResponseDto save(CartDto t) {
		Cart c = cartrepo.save(ObjectMapperUtils.toEntity(t, Cart.class));
		return ObjectMapperUtils.toDto(c, CartResponseDto.class);
	}

	@Override
	public boolean remove(Long id) {
		if (cartrepo.findByCartid(id) != null) {
			cartrepo.deleteById(id);
			return true;
		}

		return false;
		
	}

}
