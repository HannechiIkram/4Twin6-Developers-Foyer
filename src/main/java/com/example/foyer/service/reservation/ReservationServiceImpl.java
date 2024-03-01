package com.example.foyer.service.reservation;

import com.example.foyer.entity.Chambre;
import com.example.foyer.entity.Etudiant;
import com.example.foyer.entity.Reservation;
import com.example.foyer.repository.ChambreRepo;
import com.example.foyer.repository.EtudiantRepository;
import com.example.foyer.repository.ReservationRepo;
import org.springframework.http.ResponseEntity;


import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ReservationServiceImpl implements IReservationService {

    ReservationRepo resRepo;
    ChambreRepo chambreRepo;
    EtudiantRepository etudianrepo;


    @Override
    public Reservation add(Reservation reservation) {
        return resRepo.save(reservation);
    }


    @Override
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(
            long numChambre,
            long cin
    ) {
        Chambre chambre = chambreRepo.findByNumeroChambre(numChambre);
        if (chambre == null) {
            throw new RuntimeException("Chambre introuvable");
        }
        boolean available = resRepo.
                countReservationByChambre_IdChambre(chambre.getIdChambre())
                <
                typeCToInt(chambre.getTypeChambre().toString());

        Etudiant etudiant = etudianrepo.findEtudiantByCin(cin);
        if (etudiant == null) {
            throw new RuntimeException("Étudiant introuvable");
        }
        Reservation reservation = new Reservation();

        reservation.setIdReservation(
                LocalDate.now().getYear() + "/" +
                        (LocalDate.now().getYear()+1) + "-"
                        + chambre.getNumeroChambre() + "-"
                        + etudiant.getCin()
        );

        if (available) {
            //reservation.setEtudiant(etudiant);
            reservation.setChambre(chambre);
            reservation.setEstValide(true);
            reservation.setAnneUniversitaire(LocalDate.now());
            reservation.setStatuReservation("en-cours");
            etudiant.setReservations(etudiant.getReservations().size()==0 ? (Set<Reservation>) new ArrayList<Reservation>() : etudiant.getReservations());
            etudiant.getReservations().add(reservation);
            etudianrepo.save(etudiant);
        } else {
            throw new RuntimeException("pas de place disponible");
        }

        return resRepo.findById(reservation.getIdReservation()).orElse(null);

    }



    @Override
    public List<Reservation> getReservationParAnneeUniversitaire(
            LocalDate debutAnnee,
            LocalDate finAnnee
    ) {
        return resRepo.findReservationByAnneUniversitaireBetween(debutAnnee, finAnnee);
    }

    @Override
    public List<Reservation> getAll() {
        return resRepo.findAll();
    }

    @Override
    public Reservation getById(String id) {
        return resRepo.findById(id).orElse(null);
    }



    @Override
    public ResponseEntity<String> annulerReservation(String idReservation) {
        try {
            Reservation reservation = resRepo.findById(idReservation).orElse(null);
            reservation.setStatuReservation("annuler");
            //reservation.setEtudiant(null);
            reservation.setChambre(null);
            reservation.setEstValide(false);
            resRepo.save(reservation);
            return ResponseEntity.ok().body("reservation annuler");
        }catch (NullPointerException ex){
            throw new RuntimeException("reservation not found");
        }

    }




    @Override
    public Reservation validate(String idRes) {
        Reservation reservation = resRepo.findById(idRes).orElse(null);
        reservation.setStatuReservation("valide");
        return resRepo.save(reservation);
    }

    @Override
    public Reservation refuse(String idRes) {
        Reservation reservation = resRepo.findById(idRes).orElse(null);
        reservation.setStatuReservation("refuse");
        return resRepo.save(reservation);
    }

    public int typeCToInt(String typeC) {
        switch (typeC) {
            case "SIMPLE":
                return 1;
            case "DOUBLE":
                return 2;
            case "TRIPLE":
                return 3;
            default:
                return 0;
        }
    }
}