package com.vuongltw.SneakerStore.dto;

import com.vuongltw.SneakerStore.dto.responsedto.ShipmentResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ShipmentDto extends ShipmentResponseDto{
	private Long shipmentid;
}
