package com.example.printfixbot.service;

import com.example.printfixbot.entity.Manufacturer;
import com.example.printfixbot.repository.ManufacturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ManufacturerService {
    private ManufacturerRepository manufacturerRepository;

    public ResponseEntity<Manufacturer> createManufacturer(Manufacturer manufacturer) {
        Manufacturer savedManufacturer = manufacturerRepository.save(manufacturer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedManufacturer);
    }

    public ResponseEntity<Manufacturer> getManufacturerById(int id) {
        Optional<Manufacturer> manufacturerOptional =  manufacturerRepository.findById(id);
        return manufacturerOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Manufacturer>> getAllManufacturers() {
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        return manufacturers.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(manufacturers);
    }

    public ResponseEntity<Manufacturer> updateManufacturerById(int id, Manufacturer updatedManufacturer) {
        Optional<Manufacturer> manufacturerOptional = manufacturerRepository.findById(id);
        if (manufacturerOptional.isPresent()) {
            Manufacturer manufacturer = manufacturerOptional.get();
            manufacturer.setName(updatedManufacturer.getName());
            manufacturerRepository.save(manufacturer);
            return ResponseEntity.ok(manufacturer);
        } else return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Manufacturer> deleteManufacturerById(int id) {
        Optional<Manufacturer> manufacturerOptional = manufacturerRepository.findById(id);
        if (manufacturerOptional.isPresent()) {
            manufacturerRepository.deleteById(id);
            return ResponseEntity.ok(manufacturerOptional.get());
        } else return ResponseEntity.notFound().build();
    }
}
