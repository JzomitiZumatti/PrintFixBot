package com.example.printfixbot.service.impl;

import com.example.printfixbot.dto.request.manufacturer.CreateManufacturerDTO;
import com.example.printfixbot.dto.response.manufacturer.ManufacturerResponseDTO;
import com.example.printfixbot.entity.Manufacturer;
import com.example.printfixbot.mapper.ManufacturerMapper;
import com.example.printfixbot.repository.ManufacturerRepository;
import com.example.printfixbot.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerMapper manufacturerMapper;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository, ManufacturerMapper manufacturerMapper) {
        this.manufacturerRepository = manufacturerRepository;
        this.manufacturerMapper = manufacturerMapper;
    }

    @Override
    public ManufacturerResponseDTO createManufacturer(CreateManufacturerDTO createManufacturerDTO) {
        Manufacturer manufacturer = manufacturerMapper.toEntity(createManufacturerDTO);
        manufacturer = manufacturerRepository.save(manufacturer);
        return manufacturerMapper.toResponseDTO(manufacturer);
    }

    @Override
    public ManufacturerResponseDTO getManufacturerById(Long id) {
        Manufacturer manufacturer = manufacturerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manufacturer not found"));
        return manufacturerMapper.toResponseDTO(manufacturer);
    }

    @Override
    public List<ManufacturerResponseDTO> getAllManufacturers() {
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        return manufacturerMapper.toResponseDTOList(manufacturers);
    }
}

/*
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
 */
