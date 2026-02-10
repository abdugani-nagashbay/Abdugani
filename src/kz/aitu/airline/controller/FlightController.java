package kz.aitu.airline.controller;

import kz.aitu.airline.dao.FlightDAO;
import kz.aitu.airline.model.Flight;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @GetMapping
    public List<Flight> getAll() {
        return FlightDAO.findAll();
    }

    @PostMapping
    public String add(@RequestBody Flight flight) {
        FlightDAO.save(flight);
        return "Flight added";
    }
}

