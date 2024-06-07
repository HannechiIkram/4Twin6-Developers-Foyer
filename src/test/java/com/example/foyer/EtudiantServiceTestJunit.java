package com.example.foyer;
import com.example.foyer.entity.Etudiant;
import com.example.foyer.repository.EtudiantRepository;
import org.junit.jupiter.api.Test;

import com.example.foyer.service.etudiant.EtudiantServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest
public class EtudiantServiceTestJunit {

    
    @Autowired
    EtudiantRepository etudiantRepository;

    @Autowired
    EtudiantServiceImpl etudiantService;

    private static final String DEFAULT_PRENOM_NOM = "samar";

    @Test
    void addEtudiant() {
        // Test adding a single etudiant
        Etudiant etudiant = Etudiant.builder()
                .nomEt(DEFAULT_PRENOM_NOM)
                .cin(125646463186335L)
                .email("hi00")
                .ecole("hello")
                .mdp("hi")
                .prenomEt(DEFAULT_PRENOM_NOM)
                .build();

        Etudiant savedEtudiant = etudiantService.addEtudiant(etudiant);

        assertNotNull(savedEtudiant);
        assertNotNull(savedEtudiant.getIdEtudiant());
    }
@Test
void addEtudiantWithInvalidData() {
    // Test adding an etudiant with invalid data (e.g., null values)
Etudiant etudiant = Etudiant.builder()
                .nomEt()
                .cin()
                .email()
                .ecole()
                .mdp()
                .prenomEt()
                .build();
    // Create an etudiant with invalid data
    Etudiant etudiant = Etudiant.builder().build();

    // Assert that adding this etudiant throws an exception
    assertThrows(IllegalArgumentException.class, () -> etudiantService.addEtudiant(etudiant));
}

    @Test
    void getAllEtudiants() {
        // Test getting all etudiants
        List<Etudiant> responseEntity = etudiantService.getAllEtudiants();

        assertNotNull(responseEntity);
    }

    @Test
    void deleteEtudiantByID() {
        // Test deleting an etudiant by ID
        Etudiant etudiantToDelete = new Etudiant();
        etudiantToDelete.setIdEtudiant(1L);
        etudiantRepository.save(etudiantToDelete);

        assertThrows(EmptyResultDataAccessException.class, () ->
                etudiantService.deleteById(2L)
        );

        boolean isEtudiantExists = etudiantRepository.existsById(1L);
        assertTrue(isEtudiantExists);
    }

    @Test
    void addEtudiants() {
        // Test adding multiple etudiants
        List<Etudiant> etudiants = new ArrayList<>();
        Etudiant etudiant1 = Etudiant.builder()
                .nomEt(DEFAULT_PRENOM_NOM)
                .cin(125646463186335L)
                .email("hi00")
                .ecole("hello")
                .mdp("hi")
                .prenomEt(DEFAULT_PRENOM_NOM)
                .build();
        Etudiant etudiant2 = Etudiant.builder()
                .nomEt("john")
                .cin(123456789012345L)
                .email("john@example.com")
                .ecole("example")
                .mdp("password")
                .prenomEt("john")
                .build();
        etudiants.add(etudiant1);
        etudiants.add(etudiant2);

        List<Etudiant> savedEtudiants = etudiantService.addAllEtudiant(etudiants);

        assertNotNull(savedEtudiants);
        assertEquals(2, savedEtudiants.size());
    }

}
