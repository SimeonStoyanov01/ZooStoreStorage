package com.example.tinqin.zoostorestorage.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "storage")
public class StorageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "storage_id")
    private UUID storageID;
    private UUID itemId;
    private BigDecimal price;
    private Integer quantity;

}
