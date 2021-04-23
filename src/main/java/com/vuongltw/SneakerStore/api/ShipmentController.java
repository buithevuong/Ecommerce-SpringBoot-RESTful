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

import com.vuongltw.SneakerStore.dto.DeleteDto;
import com.vuongltw.SneakerStore.dto.ShipmentDto;
import com.vuongltw.SneakerStore.service.IShipmentService;

@RestController
@RequestMapping(value = "api/shipment")
@CrossOrigin("*")
public class ShipmentController {
	@Autowired
	IShipmentService shipservice;
	
	@GetMapping("/allshipment")
	public ResponseEntity<Iterable<ShipmentDto>> getAllShipment(){
		return new ResponseEntity<>(shipservice.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ShipmentDto> getShipment(@PathVariable("id") Long id){
		return new ResponseEntity<>(shipservice.findById(id).get(),HttpStatus.OK);
		
	}
	
	@PostMapping("")
	public ResponseEntity<ShipmentDto> createShipment(@RequestBody ShipmentDto shipmentresdto){
		return new ResponseEntity<>(shipservice.save(shipmentresdto),HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<ShipmentDto> editShipment(@RequestBody ShipmentDto shipmentresdto){
		return new ResponseEntity<>(shipservice.save(shipmentresdto),HttpStatus.OK);
	}
	
	@DeleteMapping("")
	public ResponseEntity<ShipmentDto> removeShipment(@RequestBody DeleteDto deletedto) {
		Optional<ShipmentDto> shipment = shipservice.findById(deletedto.getId());
		
		if(shipservice.remove(deletedto) == true) {
			return new ResponseEntity<>(shipment.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
