/**
 * 
 */
package com.project.spacehub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.spacehub.models.RoleName;
import com.project.spacehub.models.SpaceHubRole;

/**
 * @author gbemisola
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<SpaceHubRole, Long> {
	
	Optional <SpaceHubRole> findByName(RoleName roleName);

}
