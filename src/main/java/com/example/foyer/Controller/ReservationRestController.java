package com.example.foyer.Controller;

import com.example.foyer.entity.Reservation;
import com.example.foyer.service.reservation.IReservationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

public class ReservationRestController {
    IReservationService ireservationservice;


    @GetMapping("/getByAnneeUniversitaire/{deb}/{fin}")
    public List<Reservation> getReservationbyAnneeUniversitaire(
            @PathVariable("deb") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate debutAnnee,
            @PathVariable("fin") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate finAnnee
    ) {
        return ireservationservice.getReservationParAnneeUniversitaire(debutAnnee, finAnnee);
    }

    @GetMapping("/getAll")
    public List<Reservation> getAllReservations() {
        return ireservationservice.getAll();
    }

    @GetMapping("/getById/{id}")
    public Reservation getReservationById(@PathVariable("id") String id) {
        return ireservationservice.getById(id);
    }
/*
    @PostMapping("/add/{numChambre}/{cin}")
    public ResponseEntity<Reservation>
    ajouterReservationEtAssignerAChambreEtAEtudiant(
            @PathVariable("numChambre") long numChambre,
            @PathVariable("cin") long cin
    ) {
        return ResponseEntity.ok(ireservationservice.ajouterReservationEtAssignerAChambreEtAEtudiant(numChambre, cin));
    }

    @PostMapping("/annulerReservation/{idReservation}")
    public ResponseEntity<String>
    annulerReservation(
            @PathVariable("idReservation") String idReservation
    ) {
        return ireservationservice.annulerReservation(idReservation);
    }

 */

    @PutMapping("/validate")
    public ResponseEntity<Reservation> validate(@RequestParam String idReservation){
        return ResponseEntity.ok(ireservationservice.validate(idReservation));
    }

    @PutMapping("/refuse")
    public ResponseEntity<Reservation> refuse(@RequestParam String idReservation){
        return ResponseEntity.ok(ireservationservice.refuse(idReservation));
    }

}
