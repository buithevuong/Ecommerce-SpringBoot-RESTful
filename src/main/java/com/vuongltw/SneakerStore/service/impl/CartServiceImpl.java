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
import com.vuongltw.SneakerStore.repository.IUserRepository;
import com.vuongltw.SneakerStore.service.ICartService;
@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	ICartRepository cartrepo;
	
	@Autowired
	IItemRepository itemrepo;
	@Autowired
	IUserRepository userrepo;
	@Override
	public Iterable<CartDto> findAll() {
		Iterable<CartDto> list = ObjectMapperUtils.toDto(cartrepo.findAll(), CartDto.class);
		return list;	}

	@Override
	public Optional<CartDto> findByUsername(String username) {
		
		Cart cart = cartrepo.findByUserid(userrepo.findByUsername(username).get().getUserid());
		System.out.println(cart);
		CartDto cart2 = ObjectMapperUtils.toDto(cart, CartDto.class);
		System.out.println(cart2);
		Optional<CartDto> cartOptinal = Optional
				.of(ObjectMapperUtils.toDto(cart, CartDto.class));
		System.out.println(cartOptinal.get().getCartid());
		
		return cartOptinal;
	}

	@Override
	public CartDto save(CartDto t) {
		
		System.out.println(t);
		Cart c = new Cart();
		c.setUser(userrepo.findByUserid(t.getUser_id()).get());
		c.setSubtotal(0);
		c.setTotalPrice(0);
		System.out.println(c);
		cartrepo.save(c);
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


	@Override
	public Optional<CartDto> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
