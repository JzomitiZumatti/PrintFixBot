package com.example.printfixbot.repository;

import com.example.printfixbot.entity.Cartridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartridgeRepository extends JpaRepository<Cartridge, Long> {
    List<Cartridge> findByManufacturerId(Long manufacturer_id);
}
