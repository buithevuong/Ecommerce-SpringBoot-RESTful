package com.vuongltw.SneakerStore.service;

import java.util.Optional;

import com.vuongltw.SneakerStore.dto.CartDto;

public interface ICartService extends IGeneralService<CartDto>{

	public Optional<CartDto> findByUsername(String username);

}
