package com.example.printfixbot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id")
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cartridge> cartridges;

    public void addCartridge(Cartridge cartridge) {
        cartridges.add(cartridge);
        cartridge.setManufacturer(this);
    }

    public void removeCartridge(Cartridge cartridge) {
        cartridges.remove(cartridge);
        cartridge.setManufacturer(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manufacturer manufacturer)) return false;
        return id != null && id.equals(manufacturer.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
