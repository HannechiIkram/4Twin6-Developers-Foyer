package com.example.foyer.service.foyer;


import com.example.foyer.service.foyer.entity.Foyer;
import com.example.foyer.service.foyer.repository.FoyerRepo;
import com.example.foyer.service.foyer.service.foyer.FoyerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")

@SpringBootTest
@RunWith(SpringRunner.class)

@ExtendWith(SpringExtension.class)

///

class FoyerServiceImplTest {
  @Autowired
FoyerService foyerService ;
    @Autowired
FoyerRepo foyerRepo;




    @Test
    void testAddFoyer() {
        // Given
        Foyer f = Foyer.builder().idFoyer(1).nomFoyer("ik").capaciteFoyer(500).build();

        // When
        Foyer savedFoyer = foyerService.addFoyer(f);

        // Then
        assertNotNull(savedFoyer);
        assertNotEquals(0, savedFoyer.getIdFoyer());
    }

    @Test
    void testEditFoyer() {
        // Given
        Foyer foyer = Foyer.builder().idFoyer(1).nomFoyer("ik").capaciteFoyer(500).build();

        // When
        Foyer saved = foyerService.editFoyer(foyer);

        // Then
        assertNotNull(saved);
        assertNotEquals(0, saved.getIdFoyer());
    }

    @Test
    void testFindAll() {
        // Given
        Foyer foyer1 = new Foyer();
        foyer1.setNomFoyer("ik1");
        foyer1.setCapaciteFoyer(500);
        foyerRepo.save(foyer1);

        Foyer foyer2 = new Foyer();
        foyer2.setNomFoyer("ik2");
        foyer2.setCapaciteFoyer(600);
        foyerRepo.save(foyer2);

        // When
        List<Foyer> allFoyers = foyerService.findAll();

        // Then
        assertNotNull(allFoyers);
        assertEquals(2, allFoyers.size());
    }

    @Test
    void testFindById() {
        // Given
        Foyer foyer = Foyer.builder().nomFoyer("ik").capaciteFoyer(500).build();
        Foyer saved = foyerService.addFoyer(foyer);

        // When
        Foyer foundFoyer = foyerService.findById(saved.getIdFoyer());

        // Then
        assertNotNull(foundFoyer);
        assertEquals("ik", foundFoyer.getNomFoyer());
    }
    // Example of a test case using Mockito mock objects


    @Test
    void testDelete() {
        // Given
        Foyer foyer = Foyer.builder().nomFoyer("ik").capaciteFoyer(500).build();
        Foyer saved = foyerService.addFoyer(foyer);

        // When
        foyerService.delete(saved);

        // Then
        assertNull(foyerService.findById(saved.getIdFoyer()));
    }

    @Test
    void testFindByNomFoyer() {
        // Given
        Foyer foyer = Foyer.builder().nomFoyer("ik").capaciteFoyer(500).build();
        Foyer saved = foyerService.addFoyer(foyer);

        // When
        List<Foyer> foundFoyers = foyerService.findByNomFoyer("ik");

        // Then
        assertNotNull(foundFoyers);
        assertFalse(foundFoyers.isEmpty());
    }

    @Test
    void testAddFoyers() {
        // Given
        List<Foyer> foyers = Arrays.asList(
                Foyer.builder().nomFoyer("ik1").capaciteFoyer(500).build(),
                Foyer.builder().nomFoyer("ik2").capaciteFoyer(600).build()
                // Add more foyer instances as needed
        );

        // When
        List<Foyer> savedFoyers = foyerService.addFoyers(foyers);

        // Then
        assertNotNull(savedFoyers);
        assertFalse(savedFoyers.isEmpty());
    }



    @Test
    void testFindByIdWithNonExistingId() {
        // Given
        long nonExistingId = 1000;

        // When
        Foyer foundFoyer = foyerService.findById(nonExistingId);

        // Then
        assertNull(foundFoyer);
    }
    @Test
    void testDeleteNonExistingFoyer() {
        // Given
        Foyer nonExistingFoyer = Foyer.builder().idFoyer(1000).nomFoyer("ik").capaciteFoyer(500).build();

        // When
        foyerService.delete(nonExistingFoyer);

        // Then
        assertNull(foyerService.findById(nonExistingFoyer.getIdFoyer()));
    }


    @Test
    void testFindByNonExistingNomFoyer() {
        // Given
        String nonExistingNomFoyer = "nonExistingNomFoyer";

        // When
        List<Foyer> foundFoyers = foyerService.findByNomFoyer(nonExistingNomFoyer);

        // Then
        assertNotNull(foundFoyers);
        assertTrue(foundFoyers.isEmpty());
    }

    @Test
    void testAddEmptyFoyersList() {
        // Given an empty list of foyers

        // When
        List<Foyer> savedFoyers = foyerService.addFoyers(Collections.emptyList());

        // Then
        assertNotNull(savedFoyers);
        assertTrue(savedFoyers.isEmpty());
    }




    @Test
    void testFindAllWhenNoFoyersExist() {
        // Given no foyers in the repository

        // When
        List<Foyer> allFoyers = foyerService.findAll();

        // Then
        assertNotNull(allFoyers,"List of foyers should not be null");
        assertTrue("List of foyers should be empty when no foyers exist" ,allFoyers.isEmpty());
    }




    @Test
    void testFindByNomFoyerWithNonExistingNom() {
        // Given a non-existing foyer name

        // When
        List<Foyer> foundFoyers = foyerService.findByNomFoyer("non_existing_nom");

        // Then
        assertNotNull(foundFoyers,"List of found foyers should not be null");
        assertTrue("List of found foyers should be empty when nom does not exist",foundFoyers.isEmpty());
    }







}
