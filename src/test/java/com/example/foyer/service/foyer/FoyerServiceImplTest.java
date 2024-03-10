package com.example.foyer.service.foyer;

import com.example.foyer.service.foyer.entity.Foyer;
import com.example.foyer.service.foyer.repository.FoyerRepo;
import com.example.foyer.service.foyer.service.foyer.foyerServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class FoyerServiceImplTest {
    @Autowired
    foyerServiceImpl foyerService;
FoyerRepo foyerRepo;
    @Test
    public void testaddFoyer() {
        Foyer f = Foyer.builder().nomFoyer("ik").capaciteFoyer(500).build();
        Foyer savedFoyer = foyerService.addFoyer(f);
        Assertions.assertNotNull(savedFoyer.getIdFoyer());
         foyerService.deleteById(f.getIdFoyer());


    }




    @Test
    public void testEditFoyer() {
        // Given
        Foyer foyer = new Foyer().builder().nomFoyer("ik").capaciteFoyer(500).build();
        Foyer saved = foyerService.editFoyer(foyer);

        // When
        Assertions.assertNotNull(saved.getIdFoyer());



        // Clean up (delete the foyer after the test)
        foyerService.deleteById(foyer.getIdFoyer());
    }


    @Test
    public void testFindAll() {
        // When
        List<Foyer> allFoyers = foyerService.findAll();

        // Then
        Assertions.assertNotNull(allFoyers);
        // Add assertions as needed for the actual content of the list
    }

    @Test
    public void testFindById() {
        // Given
        Foyer foyer = Foyer.builder().nomFoyer("ik").capaciteFoyer(500).build();
        Foyer saved = foyerService.addFoyer(foyer);

        // When
        Foyer foundFoyer = foyerService.findById(saved.getIdFoyer());

        // Then
        Assertions.assertNotNull(foundFoyer);
        Assertions.assertEquals("ik", foundFoyer.getNomFoyer());

        // Clean up (delete the foyer after the test)
        foyerService.deleteById(saved.getIdFoyer());
    }

    @Test
    public void testDelete() {
        // Given
        Foyer foyer = Foyer.builder().nomFoyer("ik").capaciteFoyer(500).build();
        Foyer saved = foyerService.addFoyer(foyer);

        // When
        foyerService.delete(saved);

        // Then
        Assertions.assertNull(foyerService.findById(saved.getIdFoyer()));
    }
    @Test
    public void testFindByNomFoyer() {
        // Given
        Foyer foyer = Foyer.builder().nomFoyer("ik").capaciteFoyer(500).build();
        Foyer saved = foyerService.addFoyer(foyer);

        // When
        List<Foyer> foundFoyers = foyerService.findByNomFoyer("ik");

        // Then
        Assertions.assertNotNull(foundFoyers);
        Assertions.assertFalse(foundFoyers.isEmpty());

        // Clean up (delete the foyer after the test)
        foyerService.deleteById(saved.getIdFoyer());
    }
    @Test
    public void testAddFoyers() {
        // Given
        List<Foyer> foyers = Arrays.asList(
                Foyer.builder().nomFoyer("ik1").capaciteFoyer(500).build(),
                Foyer.builder().nomFoyer("ik2").capaciteFoyer(600).build()
                // Add more foyer instances as needed
        );

        // When
        List<Foyer> savedFoyers = foyerService.addFoyers(foyers);

        // Then
        Assertions.assertNotNull(savedFoyers);
        Assertions.assertFalse(savedFoyers.isEmpty());

        // Clean up (delete the foyers after the test)
        savedFoyers.forEach(f -> foyerService.deleteById(f.getIdFoyer()));
    }





}



