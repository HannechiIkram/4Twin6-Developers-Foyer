package com.example.foyer.service.chambre;

import com.example.foyer.entity.Bloc;
import com.example.foyer.entity.Chambre;
import com.example.foyer.entity.TypeChambre;

import java.util.List;

public interface IChambreService {


    Chambre addChambre (Chambre c );


    List<Chambre> addChambres(List<Chambre>chambres);
    Chambre editChambre (Chambre c);

    List<Chambre> findAll();

    Chambre findById(long id);

    String deleteById(long id);

    void delete(Chambre c);

    Chambre findChambreByNumero(long numeroChambre);
    List<Chambre> findChambreByType(TypeChambre typeChambre);
    List<Chambre> findByBloc(Bloc bloc);
    public List<Chambre> getChambresParNomBloc(String nomBloc);

   long nbChambreParTypeEtBloc(TypeChambre type, long idBloc);

    void pourcentageChambreParTypeChambre();

    long nbChambreParBloc(String nomBloc);
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(String nomFoyer, TypeChambre type);

    Chambre getChambreByIdChambre(long idChambre);

    public Chambre UpdateChambreById(Chambre c);


    public List<Chambre> getChambresByBloc(String nomBloc);
}
