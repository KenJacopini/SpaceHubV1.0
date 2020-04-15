/**
 * 
 */
package com.project.spacehub.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

/**
 * @author lordsugar
 *
 */

@Entity
@Table(name="roles")
public class SpaceHubRole {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private Long roleId;
	
	@Enumerated(EnumType.STRING)
	@NaturalId
	@Column(name = "role_name")
	private RoleName name;
	
	
	public Long getRoleId() {
		return roleId;
		
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}

	

	
	

}
