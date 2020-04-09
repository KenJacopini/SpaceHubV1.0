/**
 * 
 */
package com.project.spacehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.spacehub.models.Booking;

/**
 * @author gbemisola
 *
 */

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
