package com.vuongltw.SneakerStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vuongltw.SneakerStore.entity.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Long>{
	Payment findByPaymentid(Long id);
}
