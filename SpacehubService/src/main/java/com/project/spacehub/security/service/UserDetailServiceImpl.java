/**
 * 
 */
package com.project.spacehub.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.spacehub.models.SpaceHubUser;
import com.project.spacehub.repository.SpacehubUserRepository;

/**
 * @author gbemisola
 *
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	SpacehubUserRepository userRepository;
	

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		SpaceHubUser user = userRepository.findByEmail(email).orElseThrow(() -> 
		new UsernameNotFoundException("User Not Found with -> Email:" + email));
		
		return UserPrinciple.build(user);
	}

}
