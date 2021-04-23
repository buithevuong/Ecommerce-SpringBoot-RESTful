package com.vuongltw.SneakerStore.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vuongltw.SneakerStore.dto.DeleteDto;
import com.vuongltw.SneakerStore.dto.OrderDto;
import com.vuongltw.SneakerStore.dto.PageDto;
import com.vuongltw.SneakerStore.service.IOrderService;


@RestController
@CrossOrigin("*")
@RequestMapping(value = "api/order")
public class OrderController {
	@Autowired
	IOrderService orderservice;

	

	@GetMapping("/allorder")
	public ResponseEntity<Iterable<OrderDto>> getAllOrder() {
		return new ResponseEntity<>(orderservice.findAll(), HttpStatus.OK);
	}

	@GetMapping("/allorderbypage")
	public ResponseEntity<List<OrderDto>> getOrders(@RequestBody PageDto pagedto){
		return new ResponseEntity<>(orderservice.listAllWithPage(pagedto),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderDto> getOrder(@PathVariable("id") Long id) {
		return new ResponseEntity<>(orderservice.findById(id).get(), HttpStatus.OK);

	}

	@PostMapping("")
	public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto Orderresdto) {
		return new ResponseEntity<>(orderservice.save(Orderresdto), HttpStatus.OK);
	}

	@PutMapping("")
	public ResponseEntity<OrderDto> editOrder(@RequestBody OrderDto Orderresdto) {
		return new ResponseEntity<>(orderservice.save(Orderresdto), HttpStatus.OK);
	}

	@DeleteMapping("")
	public ResponseEntity<OrderDto> removeOrder(@RequestBody DeleteDto deletedto) {
		Optional<OrderDto> order = orderservice.findById(deletedto.getId());
		
		if (orderservice.remove(deletedto) == true) {
			return new ResponseEntity<>(order.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
