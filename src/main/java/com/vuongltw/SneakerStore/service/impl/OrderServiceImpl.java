package com.vuongltw.SneakerStore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vuongltw.SneakerStore.dto.OrderDto;
import com.vuongltw.SneakerStore.dto.PageDto;
import com.vuongltw.SneakerStore.dto.responsedto.OrderResponseDto;
import com.vuongltw.SneakerStore.entity.Order;
import com.vuongltw.SneakerStore.mapper.ObjectMapperUtils;
import com.vuongltw.SneakerStore.repository.IOrderRepository;
import com.vuongltw.SneakerStore.service.IOrderService;
@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	IOrderRepository orderrepo;

	@Override
	public Iterable<OrderResponseDto> findAll() {
		Iterable<OrderResponseDto> list = ObjectMapperUtils.toDto(orderrepo.findAll(), OrderResponseDto.class);
		return list;
	}

	@Override
	public List<OrderResponseDto> listAllWithPage(PageDto pagedto) {
		Pageable pageable = PageRequest.of(pagedto.getOffset(), pagedto.getLimit());
		Page<Order> OrderPage = orderrepo.getOrderByPage(pageable);
		List<OrderResponseDto> list = customizePage(OrderPage);
		return list;
	}
	
	@Override
	public Optional<OrderResponseDto> findById(Long id) {
		Optional<OrderResponseDto> OrderOptinal = Optional
				.of(ObjectMapperUtils.toDto(orderrepo.findByOrderid(id), OrderResponseDto.class));
		return OrderOptinal;
	}

	@Override
	public OrderResponseDto save(OrderDto t) {
		Order o = orderrepo.save(ObjectMapperUtils.toEntity(t, Order.class));
		return ObjectMapperUtils.toDto(o, OrderResponseDto.class);
	}

	@Override
	public boolean remove(Long id) {
		if (orderrepo.findByOrderid(id) != null) {
			orderrepo.deleteById(id);
			return true;
		}

		return false;

	}

	private List<OrderResponseDto> customizePage(Page<Order> page) {
		List<Order> listOrder = page.getContent();
		List<OrderResponseDto> orderResponseDto = ObjectMapperUtils.toDto(listOrder, OrderResponseDto.class);
		return orderResponseDto;
	}

}
