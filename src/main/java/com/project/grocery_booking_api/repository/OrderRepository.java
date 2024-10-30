package com.project.grocery_booking_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.grocery_booking_api.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
