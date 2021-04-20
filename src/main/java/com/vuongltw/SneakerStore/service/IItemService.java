package com.vuongltw.SneakerStore.service;

import com.vuongltw.SneakerStore.dto.CartDto;
import com.vuongltw.SneakerStore.dto.ItemDto;
import com.vuongltw.SneakerStore.dto.responsedto.ItemResponseDto;

public interface IItemService extends IGeneralService<ItemResponseDto , ItemDto>{

	Iterable<ItemResponseDto> findAllByCart(CartDto cartdto);
}
