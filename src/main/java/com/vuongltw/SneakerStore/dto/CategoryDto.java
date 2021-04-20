package com.vuongltw.SneakerStore.dto;

import com.vuongltw.SneakerStore.dto.responsedto.CategoryResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CategoryDto extends CategoryResponseDto {
	private Long categoryid;
	
}
