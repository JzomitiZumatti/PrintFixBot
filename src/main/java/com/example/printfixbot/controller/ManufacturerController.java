package com.example.printfixbot.controller;

import com.example.printfixbot.entity.Manufacturer;
import com.example.printfixbot.service.ManufacturerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturer")
@AllArgsConstructor
public class ManufacturerController {
    private ManufacturerService manufacturerService;

    @PostMapping
    public ResponseEntity<Manufacturer> createManufacturer(@RequestBody Manufacturer manufacturer) {
        return manufacturerService.createManufacturer(manufacturer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> getManufacturerById(@PathVariable int id) {
        return manufacturerService.getManufacturerById(id);
    }

    @GetMapping
    public ResponseEntity<List<Manufacturer>> getAllManufacturers() {
        return manufacturerService.getAllManufacturers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manufacturer> updateManufacturer(@PathVariable int id, @RequestBody Manufacturer manufacturer) {
        return manufacturerService.updateManufacturerById(id, manufacturer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Manufacturer> deleteManufacturerById(@PathVariable int id) {
        return manufacturerService.deleteManufacturerById(id);
    }
}