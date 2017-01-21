package com.waa.service;
	
import org.springframework.stereotype.Service;

import com.waa.domain.User;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public boolean authenticate(User user) {
		if("ramesh".equals(user.getUserName())&&"test123".equals(user.getPassword())){
			return true;
		}else{			
		
		return false;
		}
		
	}

}
