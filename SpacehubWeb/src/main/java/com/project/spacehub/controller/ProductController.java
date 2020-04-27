package com.project.spacehub.controller;


import com.project.spacehub.exceptions.UserNotFoundException;
import com.project.spacehub.models.Product;
import com.project.spacehub.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController() {
    }

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/list")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


    @GetMapping("/list/{id}")
    public EntityModel<Product> getProducts(@PathVariable int id){

        Optional<Product> product = productRepository.findById(id);

        if(!product.isPresent())
            throw new UserNotFoundException("id-" + id + " not found");

        EntityModel<Product> entityModel = new EntityModel<Product>(product.get());

        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass())
                .getAllProducts());

        entityModel.add(linkTo.withRel("all-products"));

        return entityModel;

    }

    @DeleteMapping("/list/{id}")
    public void deleteProduct(@PathVariable int id){

        productRepository.deleteById(id);

    }


    @PostMapping("/list")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

        Product savedProduct = productRepository.save(product);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedProduct.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/list/{id}")
    public Product updateProduct(@RequestBody Product newProduct, @PathVariable int id){

        return productRepository.findById(id).map(product ->{

            product.setProductImg(newProduct.getProductImg());
            product.setProductName(newProduct.getProductName());
            product.setProductPlan(newProduct.getProductPlan());
            product.setProductPrice(newProduct.getProductPrice());
            product.setProductStatus(newProduct.getProductStatus());
            return productRepository.save(product);
        }).orElseGet(() -> {
            newProduct.setId(id);
            return productRepository.save(newProduct);
        });
    }
    

}
