package com.HospitalManagementSystem.spring_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.HospitalManagementSystem.daos.IUserDao;
import com.HospitalManagementSystem.entities.User;
import com.HospitalManagementSystem.services.UserServices;
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	IUserDao userDao;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			User user = userDao.findByEmail(email);
			if(user!=null) {
				return user;
			}
		
		return null;
	}

}
