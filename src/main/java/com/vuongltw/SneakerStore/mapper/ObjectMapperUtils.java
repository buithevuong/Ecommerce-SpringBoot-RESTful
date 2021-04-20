package com.vuongltw.SneakerStore.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ObjectMapperUtils {
	private static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    private ObjectMapperUtils() {
    }

    public static <D, T> D toDto(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }

    public static <T, D> T toEntity(final D dto, Class<T> outClass) {
        return modelMapper.map(dto, outClass);
    }


    public static <D, T> List<D> toDto(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> toDto(entity, outCLass))
                .collect(Collectors.toList());
    }

    public static <T, D> List<T> toEntity(final Collection<D> dtoList, Class<T> outCLass) {
        return dtoList.stream()
                .map(dto -> toEntity(dto, outCLass))
                .collect(Collectors.toList());
    }

    public static <S, D> D map(final S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }
}
