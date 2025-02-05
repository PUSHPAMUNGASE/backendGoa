package com.example.repository;

import com.example.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    // Search hotels by name and location
    List<Hotel> findByNameContainingIgnoreCaseAndLocationContainingIgnoreCase(String name, String location);

    // Search hotels by name, location, and price range (add price range if necessary)
  
}
