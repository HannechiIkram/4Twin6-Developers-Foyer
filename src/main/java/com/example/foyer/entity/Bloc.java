package com.example.foyer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Bloc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long idBloc ;
    @Column(name="nomBloc")
    private String nomBloc ;
    @Column(name="capaciteBloc")
    private int capaciteBloc ;

    @ManyToOne
    @JoinColumn(name = "foyer_id")
    @JsonBackReference
    private Foyer foyer;
    @JsonIgnoreProperties("bloc")
    @JsonIgnore
    @OneToMany(mappedBy="bloc",cascade = CascadeType.ALL)
    List<Chambre> chambres =new ArrayList<>();

}
