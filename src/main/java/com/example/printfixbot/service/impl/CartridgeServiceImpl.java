package com.example.printfixbot.service.impl;

public class CartridgeServiceImpl {
}

/*
@Service
@RequiredArgsConstructor
public class CartridgeService {
    private final CartridgeRepository cartridgeRepository;
    private final ManufacturerRepository manufacturerRepository;

    @Transactional
    public Cartridge addCartridgeToManufacturer(Integer manufacturerId, Cartridge cartridge) {
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new EntityNotFoundException("Manufacturer not found with id: " + manufacturerId));
        manufacturer.addCartridge(cartridge);
        manufacturerRepository.save(manufacturer);
        return cartridge;
    }

    @Transactional
    public void removeCartridgeFromManufacturer(Integer manufacturerId, Integer cartridgeId) {
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
                .orElseThrow(() -> new EntityNotFoundException("Manufacturer not found with id: " + manufacturerId));

        Cartridge cartridge = cartridgeRepository.findById(cartridgeId)
                        .orElseThrow(() -> new EntityNotFoundException("Cartridge not found with id: " + cartridgeId));
        manufacturer.removeCartridge(cartridge);
    }

    public List<Cartridge> getAllCartridgesByManufacturerId(Integer manufacturerId) {
        return cartridgeRepository.findByManufacturerId(manufacturerId);
    }

}
 */
