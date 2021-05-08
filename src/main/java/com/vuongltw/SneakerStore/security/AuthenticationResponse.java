package com.vuongltw.SneakerStore.security;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2044592828653569905L;

	private final String jwt;

	private String uname;
	
	private String email;
	
	private String role;

	
	
	
	
}
