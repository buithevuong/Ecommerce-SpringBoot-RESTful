package com.vuongltw.SneakerStore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuongltw.SneakerStore.dto.ShipmentDto;
import com.vuongltw.SneakerStore.dto.responsedto.ShipmentResponseDto;
import com.vuongltw.SneakerStore.entity.Shipment;
import com.vuongltw.SneakerStore.mapper.ObjectMapperUtils;
import com.vuongltw.SneakerStore.repository.IShipmentRepository;
import com.vuongltw.SneakerStore.service.IShipmentService;
@Service
public class ShipmentServiceImpl implements IShipmentService{

	@Autowired
	IShipmentRepository shiprepo;
	
	@Override
	public Iterable<ShipmentResponseDto> findAll() {
		Iterable<ShipmentResponseDto> list = ObjectMapperUtils.toDto(shiprepo.findAll(), ShipmentResponseDto.class);
		return list;
	}

	@Override
	public Optional<ShipmentResponseDto> findById(Long id) {
		if(id == null) {
			return null;
		}else {
			Optional<ShipmentResponseDto> ShipmentOptinal = Optional
					.of(ObjectMapperUtils.toDto(shiprepo.findByShipmentid(id), ShipmentResponseDto.class));
			return ShipmentOptinal;
		}
	}

	@Override
	public ShipmentResponseDto save(ShipmentDto t) {
		if( t == null) {
			return null;
		} else {
			Shipment p = shiprepo.save(ObjectMapperUtils.toEntity(t, Shipment.class));
			return ObjectMapperUtils.toDto(p, ShipmentResponseDto.class);
		}
	}

	@Override
	public boolean remove(Long id) {
		if (shiprepo.findByShipmentid(id) != null) {
			shiprepo.deleteById(id);
			return true;
		}

		return false;
	}

}
