package com.project.grocery_booking_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.grocery_booking_api.entity.GroceryItem;
import com.project.grocery_booking_api.entity.Order;
import com.project.grocery_booking_api.entity.User;
import com.project.grocery_booking_api.repository.GroceryRepository;
import com.project.grocery_booking_api.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private GroceryRepository groceryItemRepository;

    public Order createOrder(User user, List<Integer> itemIds) {
        List<GroceryItem> items = groceryItemRepository.findAllById(itemIds);
        double totalPrice = items.stream().mapToDouble(GroceryItem::getPrice).sum();

        Order order = new Order();
        order.setUser(user);
        order.setItems(items);
        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }

}

