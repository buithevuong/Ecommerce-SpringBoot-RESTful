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
	
	private String type;
	
	private String color;
	
	private float price;
	
	private int size;
	
}
