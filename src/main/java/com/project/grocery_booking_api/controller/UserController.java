package com.project.grocery_booking_api.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.grocery_booking_api.entity.GroceryItem;
import com.project.grocery_booking_api.entity.Order;
import com.project.grocery_booking_api.entity.User;
import com.project.grocery_booking_api.repository.UserRepository;
import com.project.grocery_booking_api.service.GroceryService;
import com.project.grocery_booking_api.service.OrderService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private GroceryService groceryService;
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/items")
    public List<GroceryItem> getAvailableItems() {
        return groceryService.getAllItems();
    }

    @PostMapping("/order")
    public ResponseEntity<Order> bookOrder(
        @RequestBody List<Integer> itemIds, 
        Principal principal) {
        User user = userRepository.findByUserName(principal.getName());
        return ResponseEntity.ok(orderService.createOrder(user, itemIds));
    }
}
