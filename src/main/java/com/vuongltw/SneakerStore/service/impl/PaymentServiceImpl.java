package com.vuongltw.SneakerStore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuongltw.SneakerStore.dto.DeleteDto;
import com.vuongltw.SneakerStore.dto.PaymentDto;
import com.vuongltw.SneakerStore.entity.Payment;
import com.vuongltw.SneakerStore.mapper.ObjectMapperUtils;
import com.vuongltw.SneakerStore.repository.IPaymentRepository;
import com.vuongltw.SneakerStore.service.IPaymentService;
@Service
public class PaymentServiceImpl implements IPaymentService{

	@Autowired
	IPaymentRepository payrepo;
	
	@Override
	public Iterable<PaymentDto> findAll() {
		Iterable<PaymentDto> list = ObjectMapperUtils.toDto(payrepo.findAll(), PaymentDto.class);
		return list;
	}

	@Override
	public Optional<PaymentDto> findById(Long id) {
		if(id == null) {
			return null;
		}else {
			Optional<PaymentDto> PaymentOptinal = Optional
					.of(ObjectMapperUtils.toDto(payrepo.findByPaymentid(id), PaymentDto.class));
			return PaymentOptinal;
		}
	}

	@Override
	public PaymentDto save(PaymentDto t) {
		if( t == null) {
			return null;
		} else {
			Payment p = payrepo.save(ObjectMapperUtils.toEntity(t, Payment.class));
			return ObjectMapperUtils.toDto(p, PaymentDto.class);
		}
	}

	@Override
	public boolean remove(DeleteDto deletedto) {
		if (payrepo.findByPaymentid(deletedto.getId()) != null) {
			payrepo.deleteById(deletedto.getId());
			return true;
		}

		return false;
	}

}
