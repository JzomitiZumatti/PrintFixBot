package com.example.printfixbot.service;

import com.example.printfixbot.dto.request.manufacturer.CreateManufacturerDTO;
import com.example.printfixbot.dto.response.manufacturer.ManufacturerResponseDTO;

import java.util.List;

public interface ManufacturerService {
    ManufacturerResponseDTO createManufacturer(CreateManufacturerDTO createManufacturerDTO);
    ManufacturerResponseDTO getManufacturerById(Long id);
    List<ManufacturerResponseDTO> getAllManufacturers();
}
