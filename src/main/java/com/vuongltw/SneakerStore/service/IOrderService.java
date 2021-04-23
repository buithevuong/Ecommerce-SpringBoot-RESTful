package com.vuongltw.SneakerStore.service;

import java.util.List;

import com.vuongltw.SneakerStore.dto.OrderDto;
import com.vuongltw.SneakerStore.dto.PageDto;

public interface IOrderService extends IGeneralService<OrderDto>{

	List<OrderDto> listAllWithPage(PageDto pagedto);
}
