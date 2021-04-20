package com.vuongltw.SneakerStore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuongltw.SneakerStore.dto.PaymentDto;
import com.vuongltw.SneakerStore.dto.responsedto.PaymentResponseDto;
import com.vuongltw.SneakerStore.entity.Payment;
import com.vuongltw.SneakerStore.mapper.ObjectMapperUtils;
import com.vuongltw.SneakerStore.repository.IPaymentRepository;
import com.vuongltw.SneakerStore.service.IPaymentService;
@Service
public class PaymentServiceImpl implements IPaymentService{

	@Autowired
	IPaymentRepository payrepo;
	
	@Override
	public Iterable<PaymentResponseDto> findAll() {
		Iterable<PaymentResponseDto> list = ObjectMapperUtils.toDto(payrepo.findAll(), PaymentResponseDto.class);
		return list;
	}

	@Override
	public Optional<PaymentResponseDto> findById(Long id) {
		if(id == null) {
			return null;
		}else {
			Optional<PaymentResponseDto> PaymentOptinal = Optional
					.of(ObjectMapperUtils.toDto(payrepo.findByPaymentid(id), PaymentResponseDto.class));
			return PaymentOptinal;
		}
	}

	@Override
	public PaymentResponseDto save(PaymentDto t) {
		if( t == null) {
			return null;
		} else {
			Payment p = payrepo.save(ObjectMapperUtils.toEntity(t, Payment.class));
			return ObjectMapperUtils.toDto(p, PaymentResponseDto.class);
		}
	}

	@Override
	public boolean remove(Long id) {
		if (payrepo.findByPaymentid(id) != null) {
			payrepo.deleteById(id);
			return true;
		}

		return false;
	}

}
