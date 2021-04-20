package com.vuongltw.SneakerStore.api;

import java.util.List;
import java.util.Optional;

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

import com.vuongltw.SneakerStore.dto.PageDto;
import com.vuongltw.SneakerStore.dto.ProductDto;
import com.vuongltw.SneakerStore.dto.responsedto.ProductResponseDto;
import com.vuongltw.SneakerStore.service.IProductService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "api/product")
public class ProductController {

	private final IProductService proservice;
	public ProductController(IProductService proservice) {
	this.proservice=proservice;
	}
	
	@GetMapping("/allproduct")
	public ResponseEntity<Iterable<ProductResponseDto>> getAllProduct(){
		return new ResponseEntity<>(proservice.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/allproductbypage")
	public ResponseEntity<List<ProductResponseDto>> getProducts(@RequestBody PageDto pagedto){
		System.out.println("offset:"+pagedto.getOffset()+" limit:"+pagedto.getLimit());
		return new ResponseEntity<>(proservice.listAll(pagedto),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponseDto> getProduct(@PathVariable("id") Long id){
		return new ResponseEntity<>(proservice.findById(id).get(),HttpStatus.OK);
		
	}
	
	@GetMapping("/name/{keyword}")
	public ResponseEntity<Iterable<ProductResponseDto>> searchProduct(@PathVariable("keyword") String keyword){
		return new ResponseEntity<>(proservice.findByProductName(keyword),HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productresdto){
		return new ResponseEntity<>(proservice.save(productresdto),HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<ProductResponseDto> editProduct(@RequestBody ProductDto productresdto){
		return new ResponseEntity<>(proservice.save(productresdto),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductResponseDto> removeProduct(@PathVariable("id") Long id) {
		Optional<ProductResponseDto> product = proservice.findById(id);
		
		if(proservice.remove(id) == true) {
			return new ResponseEntity<>(product.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
