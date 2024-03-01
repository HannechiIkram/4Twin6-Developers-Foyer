package com.example.foyer.repository;

import com.example.foyer.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,String> {

    long countResvationByAnneUniversitaireBetween(Date debut , Date fin);

    List<Reservation> findReservationByAnneUniversitaireBetween(Date debutAnnee, Date finAnnee);

    int countReservationByChambre_IdChambre(long idChambre);

    List<Reservation> findReservationByAnneUniversitaireBetween(LocalDate debutAnnee, LocalDate finAnnee);


}
