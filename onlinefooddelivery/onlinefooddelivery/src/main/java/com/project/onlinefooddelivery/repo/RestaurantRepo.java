package com.project.onlinefooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.onlinefooddelivery.entity.Restaurant;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant,Integer> {

}
