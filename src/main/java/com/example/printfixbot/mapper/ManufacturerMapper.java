package com.example.printfixbot.mapper;

import com.example.printfixbot.dto.request.manufacturer.CreateManufacturerDTO;
import com.example.printfixbot.dto.response.manufacturer.ManufacturerResponseDTO;
import com.example.printfixbot.entity.Manufacturer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ManufacturerMapper {
    public Manufacturer toEntity(CreateManufacturerDTO createManufacturerDTO) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(createManufacturerDTO.name());
        return manufacturer;
    }

    public ManufacturerResponseDTO toResponseDTO(Manufacturer manufacturer) {
        String name = manufacturer.getName();
        return new ManufacturerResponseDTO(name);
    }

    public List<ManufacturerResponseDTO> toResponseDTOList(List<Manufacturer> manufacturers) {
        return manufacturers.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
