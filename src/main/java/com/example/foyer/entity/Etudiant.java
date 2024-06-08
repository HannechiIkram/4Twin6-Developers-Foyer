package com.example.foyer.entity;



import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;



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
    public LocalDate dateNaissance ;

    private String email;
    private String mdp;


}




