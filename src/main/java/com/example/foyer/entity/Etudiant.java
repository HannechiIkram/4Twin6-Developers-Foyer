package com.example.foyer.entity;



import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Etudiant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant ;
    @JsonIgnore
    private String nomEt ;

    private String prenomEt;

    private Long cin ;

    private String ecole ;

    @Temporal(TemporalType.DATE)
    private LocalDate dateNaissance ;

    private String email;
    private String mdp;


    //association with table Reservation
    @JsonIgnore
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<>();




}




