/**
 * 
 */
package com.project.spacehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.spacehub.models.SpaceHubUser;

/**
 * @author gbemisola
 *
 */
public interface SpacehubUserRepository extends JpaRepository<SpaceHubUser, Long> {

}
