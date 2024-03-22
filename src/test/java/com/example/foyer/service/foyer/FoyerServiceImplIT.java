package com.example.foyer.service.foyer;


import com.example.foyer.service.foyer.entity.Foyer;
import com.example.foyer.service.foyer.repository.FoyerRepo;
import com.example.foyer.service.foyer.service.foyer.FoyerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.*;
import static junit.framework.TestCase.assertFalse;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)

public class FoyerServiceImplIT {
    @Mock
    private FoyerRepo foyerRepository; // Assuming you have a repository dependency

    @InjectMocks
    private FoyerService foyerService; // The class under test

    @Test
    public void testAddFoyerWithEmptyName() {
        // Given
        Foyer foyer = Foyer.builder().nomFoyer("").capaciteFoyer(500).build();

        // When
        Foyer savedFoyer = foyerService.addFoyer(foyer);

        // Then
        assertNull("Saved foyer should be null when adding a foyer with an empty name", savedFoyer);
    }

    @Test
    public void testEditFoyerWithNullInput() {
        // Given
        Foyer foyer = null;

        // When
        Foyer savedFoyer = foyerService.editFoyer(foyer);

        // Then
        assertNull("Saved foyer should be null when editing with null input", savedFoyer);
    }



    @Test
    public void testFindAllWithMocks() {
        // When
        List<Foyer> allFoyers = foyerService.findAll();

        // Then
        assertNotNull("List of foyers should not be null", allFoyers);
        // Add assertions as needed for the actual content of the list
    }

    @Test
    public void testFindByIdWithMocks() {
        // Given
        Foyer foyer = new Foyer().builder().nomFoyer("ik").capaciteFoyer(500).build();

        // Mock the behavior of foyerRepository.save
        when(foyerRepository.save(any(Foyer.class))).thenAnswer(invocation -> {
            Foyer argument = invocation.getArgument(0);
            // Simulate the behavior of saving in a repository (this is just an example)
            argument.setIdFoyer(1L); // Set a sample ID
            return argument;
        });

        // When
        Foyer saved = foyerService.addFoyer(foyer);
        assertNotNull("Saved foyer should not be null", saved);
        assertNotNull("Saved foyer ID should not be null", saved.getIdFoyer());  // Ensure id is generated

        // Now, use the saved ID when setting up the findById mock
        when(foyerRepository.findById(saved.getIdFoyer())).thenReturn(Optional.of(saved));

        // When finding by ID
        Foyer foundFoyer = foyerService.findById(saved.getIdFoyer());

        // Then
        assertNotNull("Found foyer should not be null", foundFoyer);
        assertEquals("ik", foundFoyer.getNomFoyer());

        // Clean up (delete the foyer after the test)
        foyerService.deleteById(saved.getIdFoyer());

        // Additional logging for debugging
        System.out.println("Saved Foyer ID: " + saved.getIdFoyer());
        System.out.println("Found Foyer ID: " + foundFoyer.getIdFoyer());
    }

    @Test
    public void testDeleteWithMocks() {
        // Given
        Foyer foyer = new Foyer().builder().nomFoyer("ik").capaciteFoyer(500).build();
        when(foyerRepository.save(any(Foyer.class))).thenReturn(foyer);

        // When
        Foyer saved = foyerService.addFoyer(foyer);
        foyerService.delete(saved);

        // Then
        assertNull("Foyer should be null after deletion", foyerService.findById(saved.getIdFoyer()));
    }

    @Test
    public void testFindByNomFoyerwithMocks() {
        // Given
        Foyer foyer = new Foyer().builder().nomFoyer("ik").capaciteFoyer(500).build();
        when(foyerRepository.findByNomFoyer("ik")).thenReturn(Arrays.asList(foyer));

        // When
        List<Foyer> foundFoyers = foyerService.findByNomFoyer("ik");

        // Then
        assertNotNull("List of found foyers should not be null", foundFoyers);
        assertFalse("List of found foyers should not be empty", foundFoyers.isEmpty());

        // Clean up (delete the foyer after the test)
        foyerService.deleteById(foundFoyers.get(0).getIdFoyer());
    }

    @Test
    public void testAddFoyersWithMocks() {
        // Given
        List<Foyer> foyers = Arrays.asList(
                new Foyer().builder().nomFoyer("ik1").capaciteFoyer(500).build(),
                new Foyer().builder().nomFoyer("ik2").capaciteFoyer(600).build()
                // Add more foyer instances as needed
        );
        when(foyerRepository.saveAll(foyers)).thenReturn(foyers);

        // When
        List<Foyer> savedFoyers = foyerService.addFoyers(foyers);

        // Then
        assertNotNull("List of saved foyers should not be null", savedFoyers);
        assertFalse("List of saved foyers should not be empty", savedFoyers.isEmpty());

        // Clean up (delete the foyers after the test)
        savedFoyers.forEach(f -> foyerService.deleteById(f.getIdFoyer()));
    }




}
