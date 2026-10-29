package com.example.printfixbot.service;

import com.example.printfixbot.entity.Cartridge;
import com.example.printfixbot.repository.CartridgeRepository;
import com.example.printfixbot.repository.ManufacturerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CartridgeService {
    private CartridgeRepository cartridgeRepository;
    private ManufacturerRepository manufacturerRepository;

    ResponseEntity<Cartridge> createCartridge(Cartridge newCartridge) {
        Cartridge savedCartridge = cartridgeRepository.save(newCartridge);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCartridge);
    }

    @Transactional
    public ResponseEntity<Cartridge> addCartridgeToManufacturer(Integer manufacturerId, Cartridge cartridge) {
        return manufacturerRepository.findById(manufacturerId)
                .map(species -> {
                    species.addCartridge(cartridge);
                    manufacturerRepository.save(species);
                    return ResponseEntity.ok(cartridge);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
/*

 */