/**
 * 
 */
package com.project.spacehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.spacehub.models.Product;

import java.util.Optional;

/**
 * @author gbemisola
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{


}
