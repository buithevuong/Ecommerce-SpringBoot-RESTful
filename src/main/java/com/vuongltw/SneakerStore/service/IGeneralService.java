package com.vuongltw.SneakerStore.service;

import java.util.Optional;

public interface IGeneralService<T , I> {
	Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(I t);

    boolean remove(Long id);
}
