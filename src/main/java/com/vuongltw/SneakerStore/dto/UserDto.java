package com.vuongltw.SneakerStore.dto;

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
	
	private String password;
	
	private Integer active;
	
	private String role;
}
