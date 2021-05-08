package com.vuongltw.SneakerStore.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vuongltw.SneakerStore.dto.UserDto;
import com.vuongltw.SneakerStore.entity.UserEntity;
import com.vuongltw.SneakerStore.mapper.ObjectMapperUtils;
import com.vuongltw.SneakerStore.repository.IUserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	IUserRepository userrepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> user = userrepo.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found : " + username));

		return user.map(MyUserDetails::new).get();
	}

	public UserDto save(UserDto userDto) {
		if (userDto != null) {
			UserEntity user = ObjectMapperUtils.toEntity(userDto, UserEntity.class);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setRole("ROLE_ADMIN");
			user.setActive(1);
			
			return ObjectMapperUtils.toDto(userrepo.save(user), UserDto.class);
		} else {
			return null;
		}

	}

	public Optional<AuthenticationResponse> reponseUser(String jwt , String username) {
		if(username == null) {
			return null;
		}else {
			
			Optional<UserDto> userOptional = Optional.of(ObjectMapperUtils.toDto(userrepo.findByUsername(username)
					.get(), UserDto.class));
			
			AuthenticationResponse res = new AuthenticationResponse(jwt ,
					userOptional.get().getUsername(),
					userOptional.get().getEmail(), 
					userOptional.get().getRole());
			
			Optional<AuthenticationResponse> response = Optional.of(res);
			return response;
		}
		
	}

}
