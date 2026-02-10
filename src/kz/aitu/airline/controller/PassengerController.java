package kz.aitu.airline.controller;

import kz.aitu.airline.model.Passenger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @PostMapping
    public Passenger add(@RequestBody Passenger p) {
        return p;
    }
}
