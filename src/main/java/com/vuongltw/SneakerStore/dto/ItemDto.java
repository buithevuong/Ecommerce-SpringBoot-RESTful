package com.vuongltw.SneakerStore.dto;

import com.vuongltw.SneakerStore.dto.responsedto.ItemResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ItemDto extends ItemResponseDto {
	private Long itemid;
	
	private Long cart_id;
}
