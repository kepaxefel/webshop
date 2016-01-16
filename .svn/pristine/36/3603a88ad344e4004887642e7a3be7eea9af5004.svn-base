package com.shop.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.shop.managers.UsersManagerInterface;

public class MyUserDetailsService implements UserDetailsService {
	private UsersManagerInterface usersManager;
	
    public MyUserDetailsService(UsersManagerInterface usersManager) {
        super();
        this.usersManager = usersManager;
    }

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {	
		com.shop.domains.User user = usersManager.findByUserName(username);
	    if (user == null) {
            throw new UsernameNotFoundException("username not found:" + username);    	
        }        
		return user;
	}
}