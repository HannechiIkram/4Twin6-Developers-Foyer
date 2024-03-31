package com.example.foyer.service.foyer.repository;

import com.example.foyer.service.foyer.entity.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoyerRepo  extends JpaRepository<Foyer, Long> {

    List<Foyer> findAllByCapaciteFoyerGreaterThan(long capacity);



    List<Foyer> findAllByCapaciteFoyerLessThan(long capacity);

    List<Foyer> findAllByCapaciteFoyerBetween(long minCapacity, long maxCapacity);

    List<Foyer> findAllByNomFoyerContaining(String searchTerm);

    List<Foyer> findAllByNomFoyerStartingWith(String prefix);

    List<Foyer> findAllByNomFoyerEndingWith(String suffix);

    List<Foyer> findAllByNomFoyerContainingIgnoreCase(String searchTerm);

    List<Foyer> findAllByNomFoyerStartingWithIgnoreCase(String prefix);

    List<Foyer> findAllByNomFoyerEndingWithIgnoreCase(String suffix);
    List<Foyer>findByNomFoyer(String nomFoyer);

    Foyer findFoyerByNomFoyer(String nomFoyer);

}
