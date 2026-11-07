package com.example.printfixbot.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Cartridge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cartridge_model")
    private String model;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cartridge cartridge)) return false;
        return id != null && id.equals(cartridge.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
