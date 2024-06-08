package com.example.foyer.service;


import com.example.foyer.entity.Etudiant;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant etudiant);

    List<Etudiant> addAllEtudiant(List<Etudiant> liste);

    List<Etudiant> getAllEtudiants();

    Etudiant findById(Long id);

    void deleteById(Long id);

    Etudiant editEtudiant(Long id, Etudiant etudiant) throws ChangeSetPersister.NotFoundException;
    void deleteAll();


    Etudiant findEtudiantByCin(Long cin);
    Etudiant findEtudiantByEmail(String em);

    // Method to update the email of an existing etudiant
    Etudiant updateEtudiantEmail(Long id, String newEmail) throws ChangeSetPersister.NotFoundException;

    // Method to find all etudiants belonging to a specific ecole
    List<Etudiant> findEtudiantsByEcole(String ecole);

    // Method to find all etudiants born on a specific date
    List<Etudiant> findEtudiantsByDateOfBirth(Date dateOfBirth);

    // Method to count the total number of etudiants
    long countEtudiants();

    // Method to check if an etudiant with a specific email exists
    boolean existsByEmail(String email);
}

