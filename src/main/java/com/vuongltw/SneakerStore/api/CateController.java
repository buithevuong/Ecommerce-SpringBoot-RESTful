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

import com.vuongltw.SneakerStore.dto.CategoryDto;
import com.vuongltw.SneakerStore.dto.DeleteDto;
import com.vuongltw.SneakerStore.service.ICategoryService;

@RestController
@RequestMapping(value = "api/category")
@CrossOrigin("*")
public class CateController {

	@Autowired
	ICategoryService cateservice;
	
	@GetMapping("/allcategory")
	public ResponseEntity<Iterable<CategoryDto>> getAllCategory(){
		return new ResponseEntity<>(cateservice.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable("id") Long id){
		return new ResponseEntity<>(cateservice.findById(id).get(),HttpStatus.OK);
		
	}
	
	@PostMapping("")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto Categoryresdto){
		return new ResponseEntity<>(cateservice.save(Categoryresdto),HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<CategoryDto> editCategory(@RequestBody CategoryDto Categoryresdto){
		return new ResponseEntity<>(cateservice.save(Categoryresdto),HttpStatus.OK);
	}
	
	@DeleteMapping("")
	public ResponseEntity<CategoryDto> removeCategory(@RequestBody DeleteDto deletedto) {
		Optional<CategoryDto> Category = cateservice.findById(deletedto.getId());
		
		if(cateservice.remove(deletedto) == true) {
			return new ResponseEntity<>(Category.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
