package com.vuongltw.SneakerStore.api;

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

import com.vuongltw.SneakerStore.dto.CartDto;
import com.vuongltw.SneakerStore.dto.responsedto.CartResponseDto;
import com.vuongltw.SneakerStore.service.ICartService;

@RestController
@RequestMapping(value = "api/cart")
@CrossOrigin("*")
public class CartController {

	@Autowired
	ICartService cartservice;

	@GetMapping("/allcart")
	public ResponseEntity<Iterable<CartResponseDto>> getAllCart() {
		return new ResponseEntity<>(cartservice.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CartResponseDto> getCart(@PathVariable("id") Long id) {
		return new ResponseEntity<>(cartservice.findById(id).get(), HttpStatus.OK);

	}

	@PostMapping("")
	public ResponseEntity<CartResponseDto> createCart(@RequestBody CartDto Cartresdto) {
		return new ResponseEntity<>(cartservice.save(Cartresdto), HttpStatus.OK);
	}

	@PutMapping("")
	public ResponseEntity<CartResponseDto> editCart(@RequestBody CartDto Cartresdto) {
		return new ResponseEntity<>(cartservice.save(Cartresdto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CartResponseDto> removeCart(@PathVariable("id") Long id) {
		Optional<CartResponseDto> cart = cartservice.findById(id);

		if (cartservice.remove(id) == true) {
			return new ResponseEntity<>(cart.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
