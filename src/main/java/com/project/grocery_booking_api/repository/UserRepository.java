package com.project.grocery_booking_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.grocery_booking_api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String userName);

}
