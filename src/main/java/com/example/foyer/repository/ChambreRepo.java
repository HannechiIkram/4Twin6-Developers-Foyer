package com.example.foyer.repository;

import com.example.foyer.entity.Bloc;
import com.example.foyer.entity.Chambre;
import com.example.foyer.entity.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepo extends JpaRepository<Chambre,Long> {

    // 1. Recherche par numéro de chambre
    Chambre findByNumeroChambre(long numeroChambre);

    // 2. Recherche par type de chambre
    List<Chambre> findByTypeChambre(TypeChambre typeChambre);

    //3- Recherche des chambres par bloc
    List<Chambre> findByBloc(Bloc bloc);

    @Query("select c from Chambre c where c.numeroChambre=?1")
    List<Chambre> selectByNum(long num);


    @Query(value="seelect *from chambre where numeroChambre=?1 ",nativeQuery = true)
    List<Chambre> selectByNumSQL(long num);

   @Query("SELECT COUNT(c) FROM Chambre c WHERE c.typeChambre = :typeChambre AND c.bloc.idBloc = :idBloc")
    long nbChambreParTypeEtBloc(@Param("typeChambre") TypeChambre typeChambre, @Param("idBloc") long idBloc);

    Chambre getChambreByIdChambre(long idChambre);
   int countChamberByTypeChambreAndBloc_IdBloc(TypeChambre typeChambre , long idBloc);
    int countChambreByTypeChambre(TypeChambre typeChambre);
    int countChambreByBloc_NomBloc(String nomBloc);
    List<Chambre> findChambreByBlocFoyerNomFoyerAndTypeChambreAndReservations_Empty(String NomFoyer , TypeChambre type);
   List<Chambre> findByBloc_NomBloc(String nomBloc);

}