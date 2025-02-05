package com.example.service;

import com.example.entity.Hotel;
import com.example.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Comparator;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    // Get all hotels
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // Get hotel by ID
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    // Add a new hotel
    public Hotel addHotel(String name, String location, String contact) {
       // Create a new Hotel instance
        Hotel hotel = new Hotel(name, location, contact);
        
        // Save the hotel to the database
        return hotelRepository.save(hotel);
    }
    
//    public Hotel addHotel(Hotel hotel) {
//        return hotelRepository.save(hotel);
//    }


    // Update an existing hotel by ID
    public Hotel updateHotel(Long id, Hotel hotel) {
        Optional<Hotel> existingHotel = hotelRepository.findById(id);
        if (existingHotel.isPresent()) {
            Hotel updatedHotel = existingHotel.get();
            updatedHotel.setName(hotel.getName());
            updatedHotel.setLocation(hotel.getLocation());
            updatedHotel.setContact(hotel.getContact());
            return hotelRepository.save(updatedHotel);
        }
        return null; // Or throw an exception
    }

    // Delete hotel by ID
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }

 

    // Get hotels sorted by location
    public List<Hotel> getHotelsSortedByLocation() {
        List<Hotel> hotels = hotelRepository.findAll();
        hotels.sort(Comparator.comparing(Hotel::getLocation));
        return hotels;
    }
}
