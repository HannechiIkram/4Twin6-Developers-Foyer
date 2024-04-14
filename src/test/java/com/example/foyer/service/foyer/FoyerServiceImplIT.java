//package com.example.foyer.service.foyer;


//import com.example.foyer.service.foyer.entity.Foyer;
//import com.example.foyer.service.foyer.repository.FoyerRepo;
//import com.example.foyer.service.foyer.service.foyer.FoyerService;
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit.jupiter.SpringExtension;

/*import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;*/

/*import static junit.framework.TestCase.*;
import static junit.framework.TestCase.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;*/


/*@ActiveProfiles("test")

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(SpringExtension.class)*/

/*public class FoyerServiceImplIT {
    @Mock
    private FoyerRepo foyerRepository; // Assuming you have a repository dependency

    @InjectMocks
    private FoyerService foyerService; // The class under test
    @Test

    public void testFindByIdd() {
        // Given
        Foyer foyer = new Foyer();
        when(foyerRepository.findById(anyLong())).thenReturn(Optional.of(foyer));

        // When
        Foyer foundFoyer = foyerService.findById(1L);

        // Then
        assertNotNull(foundFoyer);
        // Add more assertions as needed
    }*/
  /*  @Test
    public void testAddFoyerWithEmptyName() {
        // Given
        Foyer foyer = Foyer.builder().nomFoyer("").capaciteFoyer(500).build();

        // When
        Foyer savedFoyer = foyerService.addFoyer(foyer);

        // Then
        assertNull("Saved foyer should be null when adding a foyer with an empty name", savedFoyer);
    }*/

   /* @Test
    public void testEditFoyerWithNullInput() {
        // Given
        Foyer foyer = null;

        // When
        Foyer savedFoyer = foyerService.editFoyer(foyer);

        // Then
        assertNull("Saved foyer should be null when editing with null input", savedFoyer);
    }*/



   /* @Test
    public void testFindAllWithMocks() {
        // When
        List<Foyer> allFoyers = foyerService.findAll();

        // Then
        assertNotNull(allFoyers,"List of foyers should not be null");
        // Add assertions as needed for the actual content of the list
    }@Test
    public void testFindByIdWithMocks() {
        // Given
        Foyer foyer = new Foyer().builder().nomFoyer("ik").capaciteFoyer(500).build();

        // Mock the behavior of foyerRepository.save
        when(foyerRepository.save(any(Foyer.class))).thenAnswer(invocation -> {
            Foyer argument = invocation.getArgument(0);
            // Simulate the behavior of saving in a repository (this is just an example)
            argument.setIdFoyer(1L); // Set a sample ID
            return argument;
        });*/

        // When
     /*   Foyer saved = foyerService.addFoyer(foyer);
        assertNotNull(saved,"Saved foyer should not be null");
        assertNotNull(Long.valueOf(saved.getIdFoyer()), "The ID of the saved foyer should not be null");*/

        // Now, use the saved ID when setting up the findById mock
     /*   when(foyerRepository.findById(saved.getIdFoyer())).thenReturn(Optional.of(saved));*/

        // When finding by ID
     /*   Foyer foundFoyer = foyerService.findById(saved.getIdFoyer());*/

        // Then
   /*     assertNotNull(foundFoyer,"Found foyer should not be null");
        assertNotNull(Long.valueOf(foundFoyer.getIdFoyer()), "Found foyer ID should not be null");
        assertEquals( "IDs should be equal",saved.getIdFoyer(), foundFoyer.getIdFoyer());
        assertEquals("ik", foundFoyer.getNomFoyer());*/

        // Clean up (delete the foyer after the test)
     //   foyerService.deleteById(saved.getIdFoyer());

        // Additional logging for debugging
       // System.out.println("Saved Foyer ID: " + saved.getIdFoyer());
        //System.out.println("Found Foyer ID: " + foundFoyer.getIdFoyer());
    //}


   /* @Test
    public void testDeleteWithMocks() {
        // Given
        Foyer foyer = new Foyer().builder().nomFoyer("ik").capaciteFoyer(500).build();
        when(foyerRepository.save(any(Foyer.class))).thenReturn(foyer);

        // When
        Foyer saved = foyerService.addFoyer(foyer);
        foyerService.delete(saved);

        // Then
        assertNull("Foyer should be null after deletion", foyerService.findById(saved.getIdFoyer()));
    }*/
    ///////////



  /*  @Test
    public void testDeleteByIdWithMocks() {
        // Given
        long id = 1L;

        // When
        foyerService.deleteById(id);

        // Then
        verify(foyerRepository).deleteById(id);
    }*/
    /*@Test
    public void testFindByNomFoyerwithMocks() {
        // Given
        Foyer foyer = new Foyer().builder().nomFoyer("ik").capaciteFoyer(500).build();
        when(foyerRepository.findByNomFoyer("ik")).thenReturn(Arrays.asList(foyer));

        // When
        List<Foyer> foundFoyers = foyerService.findByNomFoyer("ik");

        // Then
        assertNotNull(foundFoyers,"List of found foyers should not be null");
        assertFalse("List of found foyers should not be empty", foundFoyers.isEmpty());

        // Clean up (delete the foyer after the test)
        foyerService.deleteById(foundFoyers.get(0).getIdFoyer());
    }*/

    /*@Test
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
        assertNotNull(savedFoyers,"List of saved foyers should not be null");
        assertFalse("List of saved foyers should not be empty", savedFoyers.isEmpty());

        // Clean up (delete the foyers after the test)
        savedFoyers.forEach(f -> foyerService.deleteById(f.getIdFoyer()));
    }

    @Test
    public void testFindFoyerByNomFoyerWithMocks() {
        // Given
        String nomFoyer = "ik";
        Foyer foyer = new Foyer().builder().nomFoyer(nomFoyer).capaciteFoyer(500).build();
        when(foyerRepository.findFoyerByNomFoyer(nomFoyer)).thenReturn(foyer);

        // When
        Foyer foundFoyer = foyerRepository.findFoyerByNomFoyer(nomFoyer);

        // Then
        assertNotNull(foundFoyer);
        assertEquals(nomFoyer, foundFoyer.getNomFoyer());
    }
    @Test
    public void testEditFoyerWithNonExistingId() {
        // Given
        Foyer foyer = Foyer.builder().idFoyer(1).nomFoyer("ik").capaciteFoyer(500).build();

        // When
        Foyer saved = foyerService.editFoyer(foyer);

        // Then
        assertNull("Saved foyer should be null when editing with non-existing ID",saved);
    }

    @Test
    public void testFindAllWhenNoFoyersExist() {
        // Given no foyers in the repository

        // When
        List<Foyer> allFoyers = foyerService.findAll();

        // Then
        assertNotNull(allFoyers,"List of foyers should not be null");
        assertTrue("List of foyers should be empty when no foyers exist",allFoyers.isEmpty());
    }

    @Test
    public void testFindByIdWithNonExistingId() {
        // Given a non-existing foyer ID

        // When
        Foyer foundFoyer = foyerService.findById(999L);

        // Then
        assertNull( "Found foyer should be null when ID does not exist",foundFoyer);
    }

    @Test
    public void testFindByNomFoyerWithNonExistingNom() {
        // Given a non-existing foyer name

        // When
        List<Foyer> foundFoyers = foyerService.findByNomFoyer("non_existing_nom");

        // Then
        assertNotNull(foundFoyers,"List of found foyers should not be null");
        assertTrue("List of found foyers should be empty when nom does not exist",foundFoyers.isEmpty());
    }
*/







  /*  @Test
    public void testFindByNonExistingNomFoyer() {
        // Given
        String nonExistingNomFoyer = "Non Existing Foyer";
        when(foyerRepository.findByNomFoyer(nonExistingNomFoyer)).thenReturn(Collections.emptyList());

        // When
        List<Foyer> foundFoyers = foyerService.findByNomFoyer(nonExistingNomFoyer);

        // Then
        assertNotNull(foundFoyers,"List of found foyers should not be null");
        assertTrue("List of found foyers should be empty when nom does not exist", foundFoyers.isEmpty());
    }



    @Test
    public void testAddFoyersWithEmptyList() {
        // Given an empty list of foyers

        // When
        List<Foyer> savedFoyers = foyerService.addFoyers(Collections.emptyList());

        // Then
        assertNotNull(savedFoyers,"List of saved foyers should not be null");
        assertTrue("List of saved foyers should be empty when adding an empty list", savedFoyers.isEmpty());
    }

    @Test
    public void testFindFoyerByIdWhenRepositoryReturnsEmptyOptional() {
        // Given a non-existing foyer ID
        long nonExistingId = 999L;
        when(foyerRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        // When
        Foyer foundFoyer = foyerService.findById(nonExistingId);

        // Then
        assertNull("Found foyer should be null when ID does not exist", foundFoyer);
    }

    @Test
    public void testFindAllWhenFoyersExist() {
        // Given some foyers in the repository
        List<Foyer> foyers = Arrays.asList(
                new Foyer().builder().nomFoyer("Foyer 1").capaciteFoyer(500).build(),
                new Foyer().builder().nomFoyer("Foyer 2").capaciteFoyer(600).build()
                // Add more foyer instances as needed
        );
        when(foyerRepository.findAll()).thenReturn(foyers);

        // When
        List<Foyer> allFoyers = foyerService.findAll();

        // Then
        assertNotNull(allFoyers,"List of foyers should not be null");
        assertFalse("List of foyers should not be empty when foyers exist", allFoyers.isEmpty());
        assertEquals("The number of foyers should match the number in the repository", foyers.size(), allFoyers.size());
        assertTrue("All foyers from the repository should be present in the result", allFoyers.containsAll(foyers));
    }

    @Test
    public void testAddFoyerWithNonEmptyName() {
        // Given
        Foyer foyer = Foyer.builder().nomFoyer("Foyer name").capaciteFoyer(500).build();

        // Mock the behavior of foyerRepository.save
        when(foyerRepository.save(any(Foyer.class))).thenReturn(foyer);

        // When
        Foyer savedFoyer = foyerService.addFoyer(foyer);

        // Then
        assertNotNull( savedFoyer,"Saved foyer should not be null when adding a foyer with a non-empty name");
        assertEquals("Saved foyer name should match", foyer.getNomFoyer(), savedFoyer.getNomFoyer());
    }


}*/


