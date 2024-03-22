package com.example.foyer.service.foyer.repository;

import com.example.foyer.service.foyer.entity.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoyerRepo  extends JpaRepository<Foyer, Long> {


    List<Foyer>findByNomFoyer(String nomFoyer);

    Foyer findFoyerByNomFoyer(String nomFoyer);

}
