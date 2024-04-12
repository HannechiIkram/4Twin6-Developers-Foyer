package com.example.foyer;
import com.example.foyer.service.IEtudiantService;
import com.example.foyer.entity.Etudiant;
import com.example.foyer.repository.EtudiantRepository;
import org.junit.jupiter.api.Test;

import com.example.foyer.service.etudiant.EtudiantServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class EtudiantServiceTest {

    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    EtudiantServiceImpl etudiantService;
    @Test
    void testAddEtudiant() {
    
        Etudiant etudiant = Etudiant.builder()
                .nomEt("samar")
                .cin(Long.valueOf("250"))
                .email("hi00")
                .ecole("hello")
                .build();

      
        Etudiant savedEtudiant = etudiantService.addEtudiant(etudiant);

      
        assertNotNull(savedEtudiant);
        assertNotNull(savedEtudiant.getIdEtudiant());
    }}
