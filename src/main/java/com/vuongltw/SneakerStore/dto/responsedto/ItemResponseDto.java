package com.vuongltw.SneakerStore.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseDto {
	
	private String productName;
	
	private String image;
	
	private int quantity;
	
	private float price;
	
	
	
}
