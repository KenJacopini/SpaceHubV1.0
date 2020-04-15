/**
 * 
 */
package com.project.spacehub.security.service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import java.util.Collection;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.spacehub.models.SpaceHubUser;

/**
 * @author gbemisola
 *
 */
public class UserPrinciple implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	
	private Long id;
	

	private String email;
	
	 private String username;
	
	  @JsonIgnore
	private String password;
	
	
	private String firstName;
	
	
	
	private String lastName;
	
	
	private String phoneNumber;
	
	private String company_name;
	
	 private Collection<? extends GrantedAuthority> authorities;
	 
	 
	 

	public UserPrinciple(Long id, String email, String password, String firstName, String lastName, String phoneNumber,
			String company_name, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.company_name = company_name;
		this.authorities = authorities;
	}
	
	
	public static UserPrinciple build(SpaceHubUser user ) {
		List <GrantedAuthority> authorities = user.getRoles()
				.stream().map(role -> new SimpleGrantedAuthority(
						role.getName().name())).collect(Collectors.toList());
		
		
		
		
		return new UserPrinciple(
				user.getId(),
				user.getEmail(),
				user.getPassword(),
				user.getFirstName(),
				user.getLastName(),
				user.getPhoneNumber(),
				user.getCompany_name(),
				authorities
				
						
				);
		
				
	}
	
	
		

	public Long getId() {
		return id;
	}


	public String getEmail() {
		return email;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public String getCompany_name() {
		return company_name;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }

}
