package com.vuongltw.SneakerStore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuongltw.SneakerStore.dto.CartDto;
import com.vuongltw.SneakerStore.dto.ItemDto;
import com.vuongltw.SneakerStore.dto.responsedto.ItemResponseDto;
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
	public Iterable<ItemResponseDto> findAll() {
		Iterable<ItemResponseDto> list = ObjectMapperUtils.toDto(itemrepo.findAll(), ItemResponseDto.class);
		return list;
	}
	
	@Override
	public Iterable<ItemResponseDto> findAllByCart(CartDto cartdto) {
		
		Iterable<ItemResponseDto> list = ObjectMapperUtils.toDto(itemrepo.findAllByCartid(cartdto.getCartid()), ItemResponseDto.class);
		return list;
	}

	@Override
	public Optional<ItemResponseDto> findById(Long id) {
		Optional<ItemResponseDto> itemOptinal = Optional
				.of(ObjectMapperUtils.toDto(itemrepo.findByItemid(id), ItemResponseDto.class));
		return itemOptinal;
	}

	@Override
	public ItemResponseDto save(ItemDto t) {
		Cart cart = cartrepo.findByCartid(t.getCart_id());
		Item i = ObjectMapperUtils.toEntity(t, Item.class);
		i.setCart(cart);
		itemrepo.save(i);
		return ObjectMapperUtils.toDto(i, ItemResponseDto.class);
	}

	@Override
	public boolean remove(Long id) {
		if (itemrepo.findByItemid(id) != null) {
			itemrepo.deleteById(id);
			return true;
		}

		return false;
		
	}

	

}
