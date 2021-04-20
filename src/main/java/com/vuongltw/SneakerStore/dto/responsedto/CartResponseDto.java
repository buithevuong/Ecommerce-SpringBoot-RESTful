package com.vuongltw.SneakerStore.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDto {
	
	private float subtotal;
	
	private float totalPrice;
	
}
