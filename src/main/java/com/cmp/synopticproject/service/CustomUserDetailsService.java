package com.cmp.synopticproject.service;

import java.util.ArrayList;

import com.cmp.synopticproject.model.*;
import com.cmp.synopticproject.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Class to create custom user details.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private FarmerRepository farmerRepository;
	
	@Autowired
	private ResidentRepository residentRepository;

	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {

		// Get resident entity
		Resident resident = residentRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

		ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

		// Check resident id exists in farmer entity and add roles accordingly
		if ((farmerRepository.existsByResId(resident.getResId()))) {
			authorities.add(new SimpleGrantedAuthority("ROLE_Farmer"));
		} else {
			authorities.add(new SimpleGrantedAuthority("ROLE_Resident"));
		}

		return new User(resident.getUsername(), resident.getPassword(), authorities);
	}
}

