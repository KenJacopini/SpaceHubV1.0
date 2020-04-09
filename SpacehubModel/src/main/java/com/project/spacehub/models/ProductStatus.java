/**
 * 
 */
package com.project.spacehub.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

/**
 * @author gbemisola
 *
 */
@Entity
@Table(name = "status")
public class ProductStatus {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id")
	private int id;
	
	@Id
	@Enumerated(EnumType.STRING)
	@NaturalId
	@Column(name = "status_name")
	private StatusName name;

	public ProductStatus() {
	
	}

	public ProductStatus(StatusName name) {
	
		this.name = name;
	}

	
	public ProductStatus(int id, StatusName name) {
	
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StatusName getName() {
		return name;
	}

	public void setName(StatusName name) {
		this.name = name;
	}
	
	
	

}


