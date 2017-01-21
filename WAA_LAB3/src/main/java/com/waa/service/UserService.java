package com.waa.service;

import org.springframework.stereotype.Service;

import com.waa.domain.User;

@Service
public interface UserService {
	
		public boolean authenticate(User user);
}
