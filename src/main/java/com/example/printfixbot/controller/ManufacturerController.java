package com.example.printfixbot.controller;

import com.example.printfixbot.dto.request.manufacturer.CreateManufacturerDTO;
import com.example.printfixbot.dto.response.manufacturer.ManufacturerResponseDTO;
import com.example.printfixbot.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manufacturers")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @PostMapping
    public ResponseEntity<ManufacturerResponseDTO> createManufacturer(@RequestBody CreateManufacturerDTO createManufacturerDTO) {
        ManufacturerResponseDTO response = manufacturerService.createManufacturer(createManufacturerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManufacturerResponseDTO> getManufacturerById(@PathVariable Long id) {
        ManufacturerResponseDTO response = manufacturerService.getManufacturerById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ManufacturerResponseDTO>> getAllManufacturers() {
        List<ManufacturerResponseDTO> manufacturers = manufacturerService.getAllManufacturers();
        return ResponseEntity.ok(manufacturers);
    }
}

/*
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
 */