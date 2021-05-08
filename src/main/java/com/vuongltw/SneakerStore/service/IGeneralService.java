package com.vuongltw.SneakerStore.service;

import java.util.Optional;

import com.vuongltw.SneakerStore.dto.DeleteDto;

public interface IGeneralService<T> {
	Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    boolean remove(DeleteDto deletedto);

	
}
