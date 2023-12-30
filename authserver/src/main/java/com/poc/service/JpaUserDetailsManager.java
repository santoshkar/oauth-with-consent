package com.poc.service;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JpaUserDetailsManager implements UserDetailsManager {

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SecurityUser user = userRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Invalid Username or password");
		}

		if (!user.getUsername().equals(username)) {
			throw new UsernameNotFoundException("Access Denied");
		}

		Collection<GrantedAuthority> authorities = new HashSet<>();
		user.getAuthorities().forEach(auth -> authorities.add(new SimpleGrantedAuthority(auth.getRole())));

		return new User(user.getUsername(), user.getPassword(), user.getEnabled(), user.getAccountNonExpired(), user.getCredentialsNonExpired(), user.getAccountNonLocked(), authorities);
	}

	@Override
	public void createUser(UserDetails user) {
		throw new UnsupportedOperationException("notImplemented() JpaUserDetailsManager.createUser");
	}

	@Override
	public void updateUser(UserDetails user) {
		throw new UnsupportedOperationException("notImplemented() JpaUserDetailsManager.updateUser");
	}

	@Override
	public void deleteUser(String username) {
		throw new UnsupportedOperationException("notImplemented() JpaUserDetailsManager.deleteUser");
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		throw new UnsupportedOperationException("notImplemented() JpaUserDetailsManager.changePassword");
	}

	@Override
	public boolean userExists(String username) {
		SecurityUser user = userRepository.findByUsername(username);
		return (user.getUsername().equals(username));
	}

}
