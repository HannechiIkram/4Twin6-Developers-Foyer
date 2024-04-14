package com.example.foyer.service;


import com.example.foyer.entity.Etudiant;
import org.springframework.data.crossstore.ChangeSetPersister;

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
}
