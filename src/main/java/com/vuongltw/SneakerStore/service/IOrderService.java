package com.vuongltw.SneakerStore.service;

import java.util.List;

import com.vuongltw.SneakerStore.dto.OrderDto;
import com.vuongltw.SneakerStore.dto.PageDto;
import com.vuongltw.SneakerStore.dto.responsedto.OrderResponseDto;

public interface IOrderService extends IGeneralService<OrderResponseDto , OrderDto>{

	List<OrderResponseDto> listAllWithPage(PageDto pagedto);
}
