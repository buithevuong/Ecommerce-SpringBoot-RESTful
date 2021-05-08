package com.vuongltw.SneakerStore.dto;

import com.vuongltw.SneakerStore.dto.responsedto.CartResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CartDto extends CartResponseDto {
	private Long cartid;
	
	private Long user_id;

	public CartDto( Long user_id) {
		
		this.user_id = user_id;
	}
	
}
