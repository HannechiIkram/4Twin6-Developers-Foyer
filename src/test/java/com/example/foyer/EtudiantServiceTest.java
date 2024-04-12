package com.example.foyer;
import com.example.foyer.service.IEtudiantService;
import com.example.foyer.entity.Etudiant;
import com.example.foyer.repository.EtudiantRepository;
import org.junit.jupiter.api.Test;

import com.example.foyer.service.etudiant.EtudiantServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest
public class EtudiantServiceTest {

    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    EtudiantServiceImpl etudiantService;
    @Test
    void addEtudiant() {
    
        Etudiant etudiant = Etudiant.builder()
                .nomEt("samar")
                .cin(125646463186335L)
                .email("hi00")
                .ecole("hello")
                .mdp("hi")
                .prenomEt("samar")

                .build();

      
        Etudiant savedEtudiant = etudiantService.addEtudiant(etudiant);

      
        assertNotNull(savedEtudiant);
        assertNotNull(savedEtudiant.getIdEtudiant());
    }}
