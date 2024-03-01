package com.example.foyer.repository;
import com.example.foyer.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant findEtudiantByCin(Long cin);
    Etudiant findEtudiantByEmail(String em);
}



