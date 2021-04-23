package com.vuongltw.SneakerStore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuongltw.SneakerStore.dto.CartDto;
import com.vuongltw.SneakerStore.dto.DeleteDto;
import com.vuongltw.SneakerStore.dto.ItemDto;
import com.vuongltw.SneakerStore.entity.Cart;
import com.vuongltw.SneakerStore.entity.Item;
import com.vuongltw.SneakerStore.mapper.ObjectMapperUtils;
import com.vuongltw.SneakerStore.repository.ICartRepository;
import com.vuongltw.SneakerStore.repository.IItemRepository;
import com.vuongltw.SneakerStore.service.IItemService;
@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	IItemRepository itemrepo;
	
	@Autowired
	ICartRepository cartrepo;
	
	@Override
	public Iterable<ItemDto> findAll() {
		Iterable<ItemDto> list = ObjectMapperUtils.toDto(itemrepo.findAll(), ItemDto.class);
		return list;
	}
	
	@Override
	public Iterable<ItemDto> findAllByCart(CartDto cartdto) {
		
		Iterable<ItemDto> list = ObjectMapperUtils.toDto(itemrepo.findAllByCartid(cartdto.getCartid()), ItemDto.class);
		return list;
	}

	@Override
	public Optional<ItemDto> findById(Long id) {
		Optional<ItemDto> itemOptinal = Optional
				.of(ObjectMapperUtils.toDto(itemrepo.findByItemid(id), ItemDto.class));
		return itemOptinal;
	}

	@Override
	public ItemDto save(ItemDto t) {
		Cart cart = cartrepo.findByCartid(t.getCart_id());
		Item i = ObjectMapperUtils.toEntity(t, Item.class);
		i.setCart(cart);
		itemrepo.save(i);
		boolean check = true;
		cartrepo.save(updateCart(cart, i , check));
		return ObjectMapperUtils.toDto(i, ItemDto.class);
	}

	@Override
	public boolean remove(DeleteDto deletedto) {
		Item i = itemrepo.findByItemid(deletedto.getId());
		if (i != null) {
			boolean check = false;
			Cart cart = cartrepo.findByCartid(i.getCart().getCartid());
			
			itemrepo.deleteById(deletedto.getId());
			cartrepo.save(updateCart(cart, i, check));
			return true;
		}

		return false;
		
	}

	
	public Cart updateCart(Cart cart , Item i , boolean check) {
		if(check == true) {
			float newSubtotal = cart.getSubtotal()+i.getPrice();
			cart.setSubtotal(newSubtotal);
			return cart;
		}
		else {
			float newSubtotal = cart.getSubtotal()-i.getPrice();
			cart.setSubtotal(newSubtotal);
			return cart;
		}
	}
	
	
}
