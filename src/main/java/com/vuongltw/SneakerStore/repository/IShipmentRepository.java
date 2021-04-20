package com.vuongltw.SneakerStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vuongltw.SneakerStore.entity.Shipment;

public interface IShipmentRepository extends JpaRepository<Shipment, Long>{
	Shipment findByShipmentid(Long id);
}
