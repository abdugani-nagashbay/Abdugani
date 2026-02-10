package kz.aitu.airline.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @PostMapping
    public String book(@RequestParam int passengerId,
                       @RequestParam int flightId) {
        return "Booking successful";
    }
}

