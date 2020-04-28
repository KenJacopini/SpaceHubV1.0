/**
 * 
 */
package com.project.spacehub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.spacehub.models.SpaceHubUser;

/**
 * @author gbemisola
 *
 */
public interface SpacehubUserRepository extends JpaRepository<SpaceHubUser, Long> {

	
	Optional <SpaceHubUser> findByEmail(String email);
	
	Boolean existsByEmail(String email);
}
