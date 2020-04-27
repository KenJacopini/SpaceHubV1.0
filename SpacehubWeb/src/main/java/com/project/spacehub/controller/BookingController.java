package com.project.spacehub.controller;

import com.project.spacehub.models.Booking;
import com.project.spacehub.models.Product;
import com.project.spacehub.repository.BookingRepository;
import com.project.spacehub.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/booking")
public class BookingController {

    private BookingRepository bookingRepository;

    private ProductRepository productRepository;


    public BookingController() {
    }

    @Autowired
    public BookingController(BookingRepository bookingRepository, ProductRepository productRepository) {

        this.bookingRepository = bookingRepository;
        this.productRepository = productRepository;

    }

    @GetMapping("booked/{id}")
    public List<Booking> getAllVacantProducts(){
        List<Product> products = productRepository.findAll(Booking.class.)

    }
}
