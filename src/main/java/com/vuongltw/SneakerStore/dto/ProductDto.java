package com.vuongltw.SneakerStore.dto;

import com.vuongltw.SneakerStore.dto.responsedto.ProductResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProductDto extends ProductResponseDto {
	private Long productid;
	
	private Integer status;
}
