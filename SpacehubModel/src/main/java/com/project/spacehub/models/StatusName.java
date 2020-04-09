/**
 * 
 */
package com.project.spacehub.models;

/**
 * @author gbemisola
 *
 */
public enum StatusName {
	
	BOOKED("The space has been book"),
	
	VACANT("Booking Successful");
	
	
	private String description;
	
	StatusName(String description){
		
		this.description = description;
	}
	

	public String getDescription() {
		
		return description;
	}
}
