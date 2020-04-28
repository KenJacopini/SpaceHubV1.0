/**
 * 
 */
package com.project.spacehub.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;



/**
 * @author lordsugar
 *
 */

@Entity
@Table(name="spacehub_user")
public class SpaceHubUser {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	
	@Column(name="password")
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	private String company_name;
	
	@Transient
	private String passwordConfirm;
	
//	@OneToMany(mappedBy= "userId",  cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//	private List <Booking> bookingId;
	
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "roles_has_spacehub_user",
	    joinColumns = @JoinColumn(name = "spacehub_user_id"), inverseJoinColumns = @JoinColumn(name = "roles_role_id"))
	    private Set<SpaceHubRole> roles = new HashSet<>();
	    
	
//	@OneToMany(mappedBy="users", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//	private List<SpaceHubRole> roles;
//	
//	public List<SpaceHubRole> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<SpaceHubRole> roles) {
//		this.roles = roles;
//	}

	
	public SpaceHubUser() {
		
	}
	
	public SpaceHubUser(String email, String password, String firstName, String lastName,
			String phoneNumber) {
		super();
		
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	
	

//	public List<Booking> getBookingId() {
//		return bookingId;
//	}
//
//	public void setBookingId(List<Booking> bookingId) {
//		this.bookingId = bookingId;
//	}
	
	
	

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public Set<SpaceHubRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<SpaceHubRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "SpaceHubUser [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", passwordConfirm=" + passwordConfirm
				+ "]";
	}

	
	
	
	

}
