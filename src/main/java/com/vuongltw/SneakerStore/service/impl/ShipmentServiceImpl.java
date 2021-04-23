package com.vuongltw.SneakerStore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuongltw.SneakerStore.dto.DeleteDto;
import com.vuongltw.SneakerStore.dto.ShipmentDto;
import com.vuongltw.SneakerStore.entity.Shipment;
import com.vuongltw.SneakerStore.mapper.ObjectMapperUtils;
import com.vuongltw.SneakerStore.repository.IShipmentRepository;
import com.vuongltw.SneakerStore.service.IShipmentService;
@Service
public class ShipmentServiceImpl implements IShipmentService{

	@Autowired
	IShipmentRepository shiprepo;
	
	@Override
	public Iterable<ShipmentDto> findAll() {
		Iterable<ShipmentDto> list = ObjectMapperUtils.toDto(shiprepo.findAll(), ShipmentDto.class);
		return list;
	}

	@Override
	public Optional<ShipmentDto> findById(Long id) {
		if(id == null) {
			return null;
		}else {
			Optional<ShipmentDto> ShipmentOptinal = Optional
					.of(ObjectMapperUtils.toDto(shiprepo.findByShipmentid(id), ShipmentDto.class));
			return ShipmentOptinal;
		}
	}

	@Override
	public ShipmentDto save(ShipmentDto t) {
		if( t == null) {
			return null;
		} else {
			Shipment p = shiprepo.save(ObjectMapperUtils.toEntity(t, Shipment.class));
			return ObjectMapperUtils.toDto(p, ShipmentDto.class);
		}
	}

	@Override
	public boolean remove(DeleteDto deletedto) {
		if (shiprepo.findByShipmentid(deletedto.getId()) != null) {
			shiprepo.deleteById(deletedto.getId());
			return true;
		}

		return false;
	}

}
