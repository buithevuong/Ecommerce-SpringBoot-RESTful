package com.vuongltw.SneakerStore.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	
	private Long userid;
	
	private String username;
	
	private String email;
	@JsonIgnore
	private String password;
}
