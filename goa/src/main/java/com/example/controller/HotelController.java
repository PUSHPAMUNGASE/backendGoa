package com.example.controller;

import com.example.entity.Hotel;
import com.example.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//localhost:8081/hotels/create
@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // Endpoint to get all hotels
    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    // Endpoint to get a hotel by ID
    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    // Endpoint to create a new hotel
//    @PostMapping("/create")
//    public Hotel createHotel(@RequestParam String name, 
//                             @RequestParam String location, 
//                             @RequestParam String contact) {
//        return hotelService.addHotel(name, location, contact);
//    }

    @PostMapping("/create")
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel.getName(), hotel.getLocation(), hotel.getContact());
    }

//    
//    @PostMapping("/create")
//    public Hotel createHotel(@RequestBody Hotel hotel) {
//        return hotelService.addHotel(hotel);
//    }

    // Endpoint to update an existing hotel
    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        return hotelService.updateHotel(id, hotel);
    }

    // Endpoint to delete a hotel
    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
    }

    // Endpoint to get hotels sorted by location
//    @GetMapping("/sorted")
//    public List<Hotel> getHotelsSortedByLocation() {
//        return hotelService.getHotelsSortedByLocation();
//    }
}
