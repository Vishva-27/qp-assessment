package com.project.grocery_booking_api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.grocery_booking_api.entity.User;
import com.project.grocery_booking_api.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        
        if (user == null) {
        	throw new UsernameNotFoundException("User not found");
        }

        return org.springframework.security.core.userdetails.User
            .withUsername(user.getUserName())
            .password(user.getPassword())
            .roles(user.getRole().name())
            .build();
    }

}
