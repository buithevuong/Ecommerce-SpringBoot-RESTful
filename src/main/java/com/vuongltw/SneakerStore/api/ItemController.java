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
import com.vuongltw.SneakerStore.dto.ItemDto;
import com.vuongltw.SneakerStore.dto.responsedto.ItemResponseDto;
import com.vuongltw.SneakerStore.service.IItemService;

@RestController
@RequestMapping(value = "api/item")
@CrossOrigin("*")
public class ItemController {
	@Autowired
	IItemService itemservice;

	@GetMapping("/allitem")
	public ResponseEntity<Iterable<ItemResponseDto>> getAllItem() {
		return new ResponseEntity<>(itemservice.findAll(), HttpStatus.OK);
	}

	
	@GetMapping("/allitembycart")
	public ResponseEntity<Iterable<ItemResponseDto>> getAllItemByCartid(@RequestBody CartDto cartdto) {
		return new ResponseEntity<>(itemservice.findAllByCart(cartdto), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemResponseDto> getItem(@PathVariable("id") Long id) {
		return new ResponseEntity<>(itemservice.findById(id).get(), HttpStatus.OK);

	}

	@PostMapping(value = "",consumes = {"application/json"},
			produces = {"application/json"})
	public ResponseEntity<ItemResponseDto> createItem(@RequestBody ItemDto Itemresdto) {
		return new ResponseEntity<>(itemservice.save(Itemresdto), HttpStatus.OK);
	}

	@PutMapping("")
	public ResponseEntity<ItemResponseDto> editItem(@RequestBody ItemDto Itemresdto) {
		return new ResponseEntity<>(itemservice.save(Itemresdto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ItemResponseDto> removeItem(@PathVariable("id") Long id) {
		Optional<ItemResponseDto> Item = itemservice.findById(id);

		if (itemservice.remove(id) == true) {
			return new ResponseEntity<>(Item.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
