package com.project.grocery_booking_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.grocery_booking_api.entity.GroceryItem;
import com.project.grocery_booking_api.service.GroceryService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private GroceryService groceryService;

    @PostMapping("/items")
    public ResponseEntity<GroceryItem> addGroceryItem(@RequestBody GroceryItem item) {
        return ResponseEntity.ok(groceryService.addGroceryItem(item));
    }

    @GetMapping("/items")
    public List<GroceryItem> viewAllItems() {
        return groceryService.getAllItems();
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<?> deleteGroceryItem(@PathVariable int id) {
        groceryService.deleteGroceryItem(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<GroceryItem> updateGroceryItem(
        @PathVariable int id,
        @RequestBody GroceryItem updatedItem) throws Exception {
        return ResponseEntity.ok(groceryService.updateGroceryItem(id, updatedItem));
    }
    
    @PutMapping("/items/{id}/inventory")
    public ResponseEntity<GroceryItem> updateInventory(
        @PathVariable int id,
        @RequestParam int inventoryLevel) throws Exception {
        GroceryItem updatedItem = groceryService.updateInventory(id, inventoryLevel);
        return ResponseEntity.ok(updatedItem);
    }
}

