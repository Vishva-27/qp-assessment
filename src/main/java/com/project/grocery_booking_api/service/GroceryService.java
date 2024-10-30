package com.project.grocery_booking_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.grocery_booking_api.entity.GroceryItem;
import com.project.grocery_booking_api.repository.GroceryRepository;

@Service
public class GroceryService {

    @Autowired
    private GroceryRepository groceryItemRepository;

    public GroceryItem addGroceryItem(GroceryItem item) {
        return groceryItemRepository.save(item);
    }

    public List<GroceryItem> getAllItems() {
        return groceryItemRepository.findAll();
    }

    public void deleteGroceryItem(int id) {
        groceryItemRepository.deleteById(id);
    }

    public GroceryItem updateGroceryItem(int id, GroceryItem newItem) throws Exception {
        GroceryItem item = groceryItemRepository.findById(id)
            .orElseThrow(() -> new Exception("Resource not found"));
        item.setName(newItem.getName());
        item.setPrice(newItem.getPrice());
        item.setInventoryLevel(newItem.getInventoryLevel());
        return groceryItemRepository.save(item);
    }
    
    public GroceryItem updateInventory(int id, int newInventoryLevel) throws Exception {
        GroceryItem item = groceryItemRepository.findById(id)
            .orElseThrow(() -> new Exception("Item not found"));
        item.setInventoryLevel(newInventoryLevel);
        return groceryItemRepository.save(item);
    }
}