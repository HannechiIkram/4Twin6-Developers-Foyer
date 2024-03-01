package com.example.foyer.entity;

import com.example.foyer.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Chambre")
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;
    @Column(unique = true)
    private long numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;
   @ManyToOne
    @JsonIgnore
    private Bloc bloc;
    @JsonIgnore
    @OneToMany(mappedBy = "chambre")
    private Set<Reservation> reservations;



}
