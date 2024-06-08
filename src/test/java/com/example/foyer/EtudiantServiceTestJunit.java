package com.example.foyer;
import com.example.foyer.entity.Etudiant;
import com.example.foyer.repository.EtudiantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;

import com.example.foyer.service.etudiant.EtudiantServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
                .ecole("hoo")
                .mdp("hi")
                .prenomEt(DEFAULT_PRENOM_NOM)
                .build();

        Etudiant savedEtudiant = etudiantService.addEtudiant(etudiant);

        assertNotNull(savedEtudiant);
        assertNotNull(savedEtudiant.getIdEtudiant());
    }





    @Test
    void addEtudiants() {
        // Test adding multiple etudiants
        List<Etudiant> etudiants = new ArrayList<>();
        Etudiant etudiant1 = Etudiant.builder()
                .nomEt(DEFAULT_PRENOM_NOM)
                .cin(125646463186335L)
                .email("hi00")
                .ecole("helo")
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


    @Test
    void getAllEtudiantsWhenDatabaseIsEmpty() {
        // Test getting all etudiants when the database is empty

        // Clear all etudiants from the database
        etudiantRepository.deleteAll();

        // Retrieve all etudiants
        List<Etudiant> allEtudiants = etudiantService.getAllEtudiants();

        // Assert that the list is empty
        assertTrue(allEtudiants.isEmpty());
    }
    @Test
    void getAllEtudiants() {
        // Test getting all etudiants
        List<Etudiant> responseEntity = etudiantService.getAllEtudiants();

        assertNotNull(responseEntity);
    }
    @Test
    void findByIdExistingId() {
        // Prepare an etudiant and save it to the database
        Etudiant etudiant = Etudiant.builder()
                .nomEt("alice")
                .prenomEt("Smith")
                .cin(1111111111111L)
                .ecole("esprit")
                .email("alice@gmail.com")
                .mdp("hi")
                .build();
        Etudiant savedEtudiant = etudiantService.addEtudiant(etudiant);

        // Find the etudiant by its ID
        Etudiant foundEtudiant = etudiantService.findById(savedEtudiant.getIdEtudiant());

        // Assert that the found etudiant is not null
        assertNotNull(foundEtudiant);
        // Assert that the found etudiant has the same ID as the saved etudiant
        assertEquals(savedEtudiant.getIdEtudiant(), foundEtudiant.getIdEtudiant());
    }

    @Test
    void findByIdNonExistingId() {
        // Attempt to find an etudiant with a non-existing ID
        Long nonExistingId = Long.MAX_VALUE; // Assuming Long.MAX_VALUE is not used as an ID
        // Try to find an etudiant with a non-existing ID and expect an exception
        assertThrows(EntityNotFoundException.class, () -> etudiantService.findById(nonExistingId));
    }
    @Test
    void editExistingEtudiant() throws ChangeSetPersister.NotFoundException {
        // Prepare an etudiant and save it to the database
        Etudiant etudiant = Etudiant.builder()
                .nomEt("robert")
                .prenomEt("evans")
                .cin(1111111111111L)
                .ecole("esp")
                .email("roberts@gmail.com")
                .mdp("helllo")
                .build();
        Etudiant savedEtudiant = etudiantService.addEtudiant(etudiant);

        // Modify some attributes of the etudiant
        savedEtudiant.setNomEt("Updated Name");
        savedEtudiant.setEmail("updated_email@example.com");

        // Update the etudiant using the service
        Etudiant updatedEtudiant = etudiantService.editEtudiant(savedEtudiant.getIdEtudiant(), savedEtudiant);

        // Retrieve the updated etudiant from the database
        Etudiant retrievedEtudiant = etudiantService.findById(savedEtudiant.getIdEtudiant());

        // Assert that the retrieved etudiant matches the updated attributes
        assertNotNull(updatedEtudiant);
        assertEquals(savedEtudiant.getIdEtudiant(), updatedEtudiant.getIdEtudiant());
        assertEquals(savedEtudiant.getNomEt(), updatedEtudiant.getNomEt());
        assertEquals(savedEtudiant.getEmail(), updatedEtudiant.getEmail());

        // Assert that the etudiant in the database is also updated
        assertNotNull(retrievedEtudiant);
        assertEquals(savedEtudiant.getIdEtudiant(), retrievedEtudiant.getIdEtudiant());
        assertEquals(savedEtudiant.getNomEt(), retrievedEtudiant.getNomEt());
        assertEquals(savedEtudiant.getEmail(), retrievedEtudiant.getEmail());
    }

    @Test
    void findEtudiantByCinNonExistingCin() {
        // Attempt to find an etudiant with a non-existing CIN
        long nonExistingCin = Long.MAX_VALUE; // Assuming Long.MAX_VALUE is not used as a CIN
        // Try to find an etudiant with a non-existing CIN and expect an exception
        assertThrows(EntityNotFoundException.class, () -> etudiantService.findEtudiantByCin(nonExistingCin));
    }
    @Test
    void findEtudiantByCinExistingCin() {
        // Prepare an etudiant with a specific CIN and save it to the database
        Long existingCin = 1234567890123L;
        Etudiant etudiant = Etudiant.builder().cin(existingCin).build();
        Etudiant savedEtudiant = etudiantService.addEtudiant(etudiant);
        // Retrieve the etudiant by its CIN using the service method
        Etudiant foundEtudiant = etudiantService.findEtudiantByCin(existingCin);

        // Assert that the retrieved etudiant is not null
        assertNotNull(foundEtudiant);
        // Assert that the retrieved etudiant has the same CIN as the saved etudiant
        assertEquals(existingCin, foundEtudiant.getCin());
    }
    @Test
    void findEtudiantByEmailExistingEmail() {
        // Prepare an etudiant and save it to the database
        Etudiant etudiant = Etudiant.builder()
                .nomEt("ella")
                .prenomEt("chris")
                .cin(1111111111111L)
                .ecole("supcom")
                .email("ella@gmail.com")
                .mdp("flowers")
                .build();
        Etudiant savedEtudiant = etudiantService.addEtudiant(etudiant);

        // Find the etudiant by its email
        Etudiant foundEtudiant = etudiantService.findEtudiantByEmail(savedEtudiant.getEmail());

        // Assert that the found etudiant is not null
        assertNotNull(foundEtudiant);
        // Assert that the found etudiant has the same email as the saved etudiant
        assertEquals(savedEtudiant.getEmail(), foundEtudiant.getEmail());
    }
    @Test
    void findEtudiantByEmailNonExistingEmail() {
        // Attempt to find an etudiant with a non-existing email
        String nonExistingEmail = "nonexisting@example.com";
        // Try to find an etudiant with a non-existing email and expect an exception
        assertThrows(EntityNotFoundException.class, () -> etudiantService.findEtudiantByEmail(nonExistingEmail));
    }
    @Test
    void findEtudiantsByEcole() {
        // Prepare etudiants with the same ecole and save them to the database
        String ecole = "Example Ecole";
        Etudiant etudiant1 = Etudiant.builder().nomEt("John").prenomEt("Doe").ecole(ecole).build();
        Etudiant etudiant2 = Etudiant.builder().nomEt("Jane").prenomEt("Doe").ecole(ecole).build();
        etudiantRepository.save(etudiant1);
        etudiantRepository.save(etudiant2);

        // Retrieve etudiants by ecole using the service method
        List<Etudiant> etudiants = etudiantService.findEtudiantsByEcole(ecole);

        // Assert that the retrieved etudiants match the expected count
        assertEquals(2, etudiants.size());
    }

    @Test
    void findEtudiantsByDateOfBirth() {
        // Prepare an etudiant with a specific date of birth and save it to the database
        LocalDate dateOfBirth = LocalDate.of(2000, 1, 1);
        Etudiant etudiant = Etudiant.builder().nomEt("John").prenomEt("Doe").dateNaissance(dateOfBirth).build();
        etudiantRepository.save(etudiant);

        // Retrieve etudiants by date of birth using the service method
        List<Etudiant> etudiants = etudiantService.findEtudiantsByDateOfBirth(dateOfBirth);

        // Assert that the retrieved etudiants match the expected count
        assertEquals(1, etudiants.size());
    }
    @Test
    void countEtudiants() {
        etudiantRepository.deleteAll();
        // Save multiple etudiants to the database
        etudiantRepository.save(new Etudiant());
        etudiantRepository.save(new Etudiant());
        etudiantRepository.save(new Etudiant());

        // Retrieve the count of etudiants using the service method
        long count = etudiantService.countEtudiants();

        // Assert that the count matches the expected count
        assertEquals(3,count);
    }
    @Test
    void existsByEmail() {
        // Prepare an etudiant with a specific email and save it to the database
        String email = "john.doe@example.com";
        Etudiant etudiant = Etudiant.builder().nomEt("John").prenomEt("Doe").email(email).build();
        etudiantRepository.save(etudiant);

        // Check if an etudiant exists by email using the service method
        boolean exists = etudiantService.existsByEmail(email);

        // Assert that the etudiant exists
        assertTrue(exists);
    }

    @Test
    void deleteById() {
        // Prepare an etudiant and save it to the database
        Etudiant etudiant = Etudiant.builder().nomEt("John").prenomEt("Doe").build();
        etudiant = etudiantRepository.save(etudiant);

        // Delete the etudiant by ID using the service method
        etudiantService.deleteById(etudiant.getIdEtudiant());

        // Attempt to retrieve the deleted etudiant from the database
        Optional<Etudiant> deletedEtudiant = etudiantRepository.findById(etudiant.getIdEtudiant());

        // Assert that the etudiant is deleted
        assertFalse(deletedEtudiant.isPresent());
    }
    @Test
    void deleteAll() {
        // Save multiple etudiants to the database
        etudiantRepository.save(new Etudiant());
        etudiantRepository.save(new Etudiant());
        etudiantRepository.save(new Etudiant());

        // Delete all etudiants using the service method
        etudiantService.deleteAll();

        // Retrieve the count of etudiants after deletion
        long count = etudiantRepository.count();

        // Assert that the count is zero
        assertEquals(0, count);
    }
    @Test
    void editNonExistingEtudiant() {
        // Prepare an etudiant with attributes for editing
        Etudiant etudiant = Etudiant.builder()
                .nomEt("John")
                .prenomEt("Doe")
                .cin(1234567890123L)
                .ecole("Example Ecole")
                .email("john.doe@example.com")
                .mdp("password")
                .build();

        // Attempt to edit an etudiant with a non-existing ID and expect a NotFoundException
        assertThrows(ChangeSetPersister.NotFoundException.class, () -> etudiantService.editEtudiant(Long.MAX_VALUE, etudiant));
    }
    @Test
    void updateExistingEtudiantEmail() throws ChangeSetPersister.NotFoundException {
        // Prepare an etudiant and save it to the database
        Etudiant etudiant = Etudiant.builder()
                .nomEt("John")
                .prenomEt("Doe")
                .cin(1234567890123L)
                .ecole("Example Ecole")
                .email("john.doe@example.com")
                .mdp("password")
                .build();
        Etudiant savedEtudiant = etudiantService.addEtudiant(etudiant);

        // New email for updating
        String newEmail = "updated_email@example.com";

        // Update the etudiant email using the service
        Etudiant updatedEtudiant = etudiantService.updateEtudiantEmail(savedEtudiant.getIdEtudiant(), newEmail);

        // Retrieve the updated etudiant from the database
        Etudiant retrievedEtudiant = etudiantService.findById(savedEtudiant.getIdEtudiant());

        // Assert that the retrieved etudiant has the updated email
        assertNotNull(updatedEtudiant);
        assertEquals(newEmail, updatedEtudiant.getEmail());

        // Assert that the etudiant in the database has the updated email
        assertNotNull(retrievedEtudiant);
        assertEquals(newEmail, retrievedEtudiant.getEmail());
    }
    @Test
    void updateNonExistingEtudiantEmail() {
        // New email for updating
        String newEmail = "updated_email@example.com";

        // Attempt to update the email of a non-existing etudiant and expect a NotFoundException
        assertThrows(ChangeSetPersister.NotFoundException.class, () -> etudiantService.updateEtudiantEmail(Long.MAX_VALUE, newEmail));
    }
}
