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

    //List<Foyer> getFoyersByBloc(Bloc bloc);
   // Foyer ajoutFoyerEtBloc(Foyer foyer);
   // Foyer addFoyerAndAssociateUniversiteAndBloc(Foyer foyer, long idUniversite, List<Long> idBloc);
    //Foyer ajouterFoyerEtAffecteUniversite(Foyer foyer,long idUniversite);
  //  Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite);
  //  Universite desaffecterFoyerAUniversite (long idUniversite);
    //Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer);
    List<Foyer>findByNomFoyer(String nomFoyer);
 ///   void deleteFoyerAndDesaffecterUniversite(Long id);
  //  Foyer updateFoyerWithAssociations(Foyer updatedFoyer, long id, Long idUniversite, List<Long> idBloc);

}
