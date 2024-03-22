package com.example.foyer.service.foyer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Table(name = "foyer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;

    private String nomFoyer;

    @Column(name = "capaciteFoyer")
    private long capaciteFoyer;


    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] imageData;
}
