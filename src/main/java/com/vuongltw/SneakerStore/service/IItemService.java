package com.vuongltw.SneakerStore.service;

import com.vuongltw.SneakerStore.dto.CartDto;
import com.vuongltw.SneakerStore.dto.ItemDto;

public interface IItemService extends IGeneralService<ItemDto>{

	Iterable<ItemDto> findAllByCart(CartDto cartdto);
}
