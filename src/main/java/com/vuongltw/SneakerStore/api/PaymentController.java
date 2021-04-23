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
import com.vuongltw.SneakerStore.dto.PaymentDto;
import com.vuongltw.SneakerStore.service.IPaymentService;

@RestController
@RequestMapping(value = "api/payment")
@CrossOrigin("*")
public class PaymentController {
	@Autowired
	IPaymentService payservice;
	
	@GetMapping("/allpayment")
	public ResponseEntity<Iterable<PaymentDto>> getAllPayment(){
		return new ResponseEntity<>(payservice.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PaymentDto> getPayment(@PathVariable("id") Long id){
		return new ResponseEntity<>(payservice.findById(id).get(),HttpStatus.OK);
		
	}
	
	@PostMapping("")
	public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto paymentresdto){
		return new ResponseEntity<>(payservice.save(paymentresdto),HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<PaymentDto> editPayment(@RequestBody PaymentDto paymentresdto){
		return new ResponseEntity<>(payservice.save(paymentresdto),HttpStatus.OK);
	}
	
	@DeleteMapping("")
	public ResponseEntity<PaymentDto> removePayment(@RequestBody DeleteDto deletedto) {
		Optional<PaymentDto> payment = payservice.findById(deletedto.getId());
		
		if(payservice.remove(deletedto) == true) {
			return new ResponseEntity<>(payment.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
