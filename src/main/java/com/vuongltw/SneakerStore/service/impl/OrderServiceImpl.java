package com.vuongltw.SneakerStore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vuongltw.SneakerStore.dto.DeleteDto;
import com.vuongltw.SneakerStore.dto.OrderDto;
import com.vuongltw.SneakerStore.dto.PageDto;
import com.vuongltw.SneakerStore.entity.Cart;
import com.vuongltw.SneakerStore.entity.Order;
import com.vuongltw.SneakerStore.entity.Payment;
import com.vuongltw.SneakerStore.entity.Shipment;
import com.vuongltw.SneakerStore.mapper.ObjectMapperUtils;
import com.vuongltw.SneakerStore.repository.ICartRepository;
import com.vuongltw.SneakerStore.repository.IOrderRepository;
import com.vuongltw.SneakerStore.repository.IPaymentRepository;
import com.vuongltw.SneakerStore.repository.IShipmentRepository;
import com.vuongltw.SneakerStore.service.IOrderService;
@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	IOrderRepository orderrepo;
	
	@Autowired
	ICartRepository cartrepo;
	
	@Autowired
	IShipmentRepository shiprepo;
	
	@Autowired
	IPaymentRepository payrepo;

	@Override
	public Iterable<OrderDto> findAll() {
		Iterable<OrderDto> list = ObjectMapperUtils.toDto(orderrepo.findAll(), OrderDto.class);
		return list;
	}

	@Override
	public List<OrderDto> listAllWithPage(PageDto pagedto) {
		Pageable pageable = PageRequest.of(pagedto.getOffset(), pagedto.getLimit());
		Page<Order> OrderPage = orderrepo.getOrderByPage(pageable);
		List<OrderDto> list = customizePage(OrderPage);
		return list;
	}
	
	@Override
	public Optional<OrderDto> findById(Long id) {
		Optional<OrderDto> OrderOptinal = Optional
				.of(ObjectMapperUtils.toDto(orderrepo.findByOrderid(id), OrderDto.class));
		return OrderOptinal;
	}
	
	@Override
	public OrderDto save(OrderDto t) {
		Cart cart = cartrepo.findByCartid(t.getCart_id());
		Shipment ship = shiprepo.findByShipmentid(t.getShipment_id());
		Payment pay = payrepo.findByPaymentid(t.getPayment_id());
		Order o = ObjectMapperUtils.toEntity(t, Order.class);
		o.setCart(cart);
		o.setPayment(pay);
		o.setShipment(ship);
		o.setSubtotal(cart.getSubtotal());
		o.setTotalprice(cart.getSubtotal()+ship.getPrice()+pay.getPrice());
		orderrepo.save(o);
		return t;
	}

	@Override
	public boolean remove(DeleteDto deletedto) {
		if (orderrepo.findByOrderid(deletedto.getId()) != null) {
			orderrepo.deleteById(deletedto.getId());
			return true;
		}

		return false;

	}

	private List<OrderDto> customizePage(Page<Order> page) {
		List<Order> listOrder = page.getContent();
		List<OrderDto> orderDto = ObjectMapperUtils.toDto(listOrder, OrderDto.class);
		return orderDto;
	}

}
