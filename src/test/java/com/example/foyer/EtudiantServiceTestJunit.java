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
    }
    @Test
    void getAllEtudiants
            () {
        // Call the controller method to get all etudiants
        List <Etudiant> responseEntity = etudiantService.getAllEtudiants();

        // Now, you can add assertions to ensure the response is as expected
        assertNotNull(responseEntity);

    }

    @Test
    void updateEtudiant() {
        // Create an Etudiant object with updated information
        Etudiant updatedEtudiant = Etudiant.builder()
                .nomEt("UpdatedName")
                .cin(125646463186335L)
                .email("updated@example.com")
                .ecole("UpdatedEcole")
                .mdp("updatedPassword")
                .prenomEt("UpdatedFirstName")
                .build();

        // Assuming the ID does not exist in the database
        assertThrows(ChangeSetPersister.NotFoundException.class, () -> {
            etudiantService.editEtudiant(1L, updatedEtudiant);
        });
    }


    @Test
    void deleteEtudiantByID() {

        Etudiant etudiantToDelete = new Etudiant(); // Create an etudiant entity
        etudiantToDelete.setIdEtudiant(1L); // Set the ID of the etudiant to delete


        etudiantRepository.save(etudiantToDelete); // Save the etudiant to the database


        assertThrows(EmptyResultDataAccessException.class, () ->
            etudiantService.deleteById(2L)
        );

        // Optional: Assert that the etudiant is not deleted from the database
        boolean isEtudiantExists = etudiantRepository.existsById(1L);
        assertTrue(isEtudiantExists);
    }

    @Test
    void addEtudiants() {
        // Create a sample list of Etudiants
        List<Etudiant> etudiants = new ArrayList<>();
        Etudiant etudiant1 = Etudiant.builder()
                .nomEt("samar")
                .cin(125646463186335L)
                .email("hi00")
                .ecole("hello")
                .mdp("hi")
                .prenomEt("samar")
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

        // Call the controller method
        List<Etudiant> savedEtudiants = etudiantService.addAllEtudiant(etudiants);

        // Assertions
        assertNotNull(savedEtudiants);
        assertEquals(2, savedEtudiants.size()); // Check if all etudiants are saved
        // Add additional assertions as needed
    }

}