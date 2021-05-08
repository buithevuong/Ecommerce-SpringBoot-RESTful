package com.vuongltw.SneakerStore.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vuongltw.SneakerStore.dto.CartDto;
import com.vuongltw.SneakerStore.dto.LogoutDto;
import com.vuongltw.SneakerStore.dto.UserDto;
import com.vuongltw.SneakerStore.security.AuthenticationRequest;
import com.vuongltw.SneakerStore.security.AuthenticationResponse;
import com.vuongltw.SneakerStore.security.JwtUtil;
import com.vuongltw.SneakerStore.security.MyUserDetailsService;
import com.vuongltw.SneakerStore.service.ICartService;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private ICartService cartservice;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		Authentication authentication = null;
		try {
			  authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		//SecurityContextHolder.getContext().setAuthentication(authentication);

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		Optional<AuthenticationResponse> res = userDetailsService.reponseUser(jwt,authenticationRequest.getUsername());
		
		return ResponseEntity.ok(res);
	}

	@PostMapping("/registration")
	public ResponseEntity<UserDto> createAccount(@RequestBody UserDto userDto){
		UserDto user = userDetailsService.save(userDto);
		System.out.println(user.getUserid());
		CartDto cart = new CartDto(user.getUserid());
		cartservice.save(cart);
		return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
	
	@PostMapping("/logoutToken")
	public ResponseEntity<LogoutDto> logOut(@RequestBody LogoutDto logout) {
		System.out.println(logout.getToken());
		jwtTokenUtil.extractExpiration(logout.getToken());
		logout = null;
		System.out.println(logout);
		return new ResponseEntity<>(logout,HttpStatus.OK);
	}
}
