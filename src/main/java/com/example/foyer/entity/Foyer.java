package com.example.foyer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

   // @OneToMany(mappedBy = "foyer")
    //List<Bloc> bloc=new ArrayList<>();

   // @OneToOne(mappedBy = "foyer")
   // private Universite universite;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] imageData;
}
