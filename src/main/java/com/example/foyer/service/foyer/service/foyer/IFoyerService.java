package com.example.foyer.service.foyer.service.foyer;



import com.example.foyer.service.foyer.entity.Foyer;

import java.util.List;

public interface IFoyerService {

    Foyer addFoyer (Foyer f );


    List<Foyer> addFoyers(List<Foyer>foyers);
    Foyer editFoyer (Foyer f);

    List<Foyer> findAll();

    Foyer findById(long id);

    void deleteById(long id);

    void delete(Foyer f);

    public Foyer updateFoyerCapacity(long id, long newCapacity) ;
    List<Foyer>findByNomFoyer(String nomFoyer);

    // Existing methods...

    List<Foyer> findAllByCapacityGreaterThan(long capacity);

    List<Foyer> findAllByCapacityLessThan(long capacity);

    List<Foyer> findAllFoyersSortedByName();

    List<Foyer> findAllFoyersSortedByCapacity();

    List<Foyer> findAllFoyersSortedByCapacityDesc();

    List<Foyer> findAllFoyersSortedByNomFoyerLength();

    List<Foyer> findAllFoyersWithCapacityInRange(long minCapacity, long maxCapacity);

    List<Foyer> findAllFoyersWithNamesContaining(String searchTerm);

    List<Foyer> findAllFoyersWithNamesStartingWith(String prefix);

    List<Foyer> findAllFoyersWithNamesEndingWith(String suffix);

    List<Foyer> findAllFoyersWithNamesContainingIgnoreCase(String searchTerm);

    List<Foyer> findAllFoyersWithNamesStartingWithIgnoreCase(String prefix);

    List<Foyer> findAllFoyersWithNamesEndingWithIgnoreCase(String suffix);




}
