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

import com.vuongltw.SneakerStore.dto.PaymentDto;
import com.vuongltw.SneakerStore.dto.responsedto.PaymentResponseDto;
import com.vuongltw.SneakerStore.service.IPaymentService;

@RestController
@RequestMapping(value = "api/payment")
@CrossOrigin("*")
public class PaymentController {
	@Autowired
	IPaymentService payservice;
	
	@GetMapping("/allPayment")
	public ResponseEntity<Iterable<PaymentResponseDto>> getAllPayment(){
		return new ResponseEntity<>(payservice.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PaymentResponseDto> getPayment(@PathVariable("id") Long id){
		return new ResponseEntity<>(payservice.findById(id).get(),HttpStatus.OK);
		
	}
	
	@PostMapping("")
	public ResponseEntity<PaymentResponseDto> createPayment(@RequestBody PaymentDto paymentresdto){
		return new ResponseEntity<>(payservice.save(paymentresdto),HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<PaymentResponseDto> editPayment(@RequestBody PaymentDto paymentresdto){
		return new ResponseEntity<>(payservice.save(paymentresdto),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PaymentResponseDto> removePayment(@PathVariable("id") Long id) {
		Optional<PaymentResponseDto> payment = payservice.findById(id);
		
		if(payservice.remove(id) == true) {
			return new ResponseEntity<>(payment.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
