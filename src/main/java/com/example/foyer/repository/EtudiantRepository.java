package com.example.foyer.repository;
import com.example.foyer.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant findEtudiantByCin(Long cin);
    Etudiant findEtudiantByEmail(String em);

    List<Etudiant> findByEcole(String ecole);

    List<Etudiant> findEtudiantsBydateNaissance(LocalDate dateOfBirth);

    boolean existsByEmail(String email);


}



