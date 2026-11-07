package com.example.printfixbot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartridge")
@AllArgsConstructor
public class CartridgeController {

}

/*
@RestController
@RequestMapping("/cartridge")
@AllArgsConstructor
public class CartridgeController {
    private CartridgeService cartridgeService;
    private ManufacturerService manufacturerService;


    @PostMapping("/{manufacturer_id}")
    public ResponseEntity<Cartridge> addCartridgeToManufacturer(@PathVariable Integer manufacturer_id, @RequestBody Cartridge cartridge) {
        return ResponseEntity.ok(cartridgeService.addCartridgeToManufacturer(manufacturer_id, cartridge));
    }

    @GetMapping("/by-manufacturer/{manufacturer_id}")
    public ResponseEntity<List<Cartridge>> getAllCartridgesByManufacturerId(@PathVariable Integer manufacturer_id) {
        List<Cartridge> cartridges = cartridgeService.getAllCartridgesByManufacturerId(manufacturer_id);
        return ResponseEntity.ok(cartridges);
    }
}
 */
