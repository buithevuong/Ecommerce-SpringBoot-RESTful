package com.vuongltw.SneakerStore.dto;

import com.vuongltw.SneakerStore.dto.responsedto.OrderResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OrderDto extends OrderResponseDto {
	private Long orderid;
	
	private Integer status;
}
