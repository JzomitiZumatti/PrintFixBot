package com.example.printfixbot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id")
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cartridge> cartridges = new HashSet<>();

    public void addCartridge(Cartridge cartridge) {
        cartridges.add(cartridge);
        cartridge.setManufacturer(this);
    }

    public void removeCartridge(Cartridge cartridge) {
        cartridges.remove(cartridge);
        cartridge.setManufacturer(null);
    }
}
