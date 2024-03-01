package com.example.foyer.service.foyer;



import com.example.foyer.entity.Bloc;
import com.example.foyer.entity.Foyer;

import java.util.List;

public interface IFoyerService {

    Foyer addFoyer (Foyer f );


    List<Foyer> addFoyers(List<Foyer>foyers);
    Foyer editFoyer (Foyer f);

    List<Foyer> findAll();

    Foyer findById(long id);

    void deleteById(long id);

    void delete(Foyer f);

    List<Foyer> getFoyersByBloc(Bloc bloc);
    Foyer ajoutFoyerEtBloc(Foyer foyer);



    Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer);
    List<Foyer>findByNomFoyer(String nomFoyer);



}
