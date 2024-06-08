package com.example.foyer;
import com.example.foyer.entity.Etudiant;
import com.example.foyer.repository.EtudiantRepository;
import com.example.foyer.service.etudiant.EtudiantServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EtudiantServiceTestMock {

    @Mock
    private EtudiantRepository etudiantRepository;

    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    private static final String DEFAULT_PRENOM_NOM = "samar";



    @Test
    void addEtudiants() {
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

        when(etudiantRepository.saveAll(anyIterable())).thenReturn(etudiants);

        List<Etudiant> savedEtudiants = etudiantService.addAllEtudiant(etudiants);

        assertNotNull(savedEtudiants);
        assertEquals(2, savedEtudiants.size());
    }

    @Test
    void getAllEtudiantsWhenDatabaseIsEmpty() {
        when(etudiantRepository.findAll()).thenReturn(new ArrayList<>());

        List<Etudiant> allEtudiants = etudiantService.getAllEtudiants();

        assertTrue(allEtudiants.isEmpty());
    }

    @Test
    void getAllEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(new Etudiant());
        etudiants.add(new Etudiant());

        when(etudiantRepository.findAll()).thenReturn(etudiants);

        List<Etudiant> responseEntity = etudiantService.getAllEtudiants();

        assertNotNull(responseEntity);
        assertEquals(2, responseEntity.size());
    }

    // Implement the rest of the test methods similarly using Mockito
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
        when(etudiantRepository.findById(etudiant.getIdEtudiant())).thenReturn(Optional.of(etudiant));

        // Find the etudiant by its ID
        Etudiant foundEtudiant = etudiantService.findById(etudiant.getIdEtudiant());

        // Assert that the found etudiant is not null
        assertNotNull(foundEtudiant);
        // Assert that the found etudiant has the same ID as the saved etudiant
        assertEquals(etudiant.getIdEtudiant(), foundEtudiant.getIdEtudiant());
    }

    @Test
    void findByIdNonExistingId() {
        // Prepare a non-existing ID
        long nonExistingId = Long.MAX_VALUE;

        // Stub the repository method to return an empty Optional
        when(etudiantRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        // Attempt to find an etudiant with a non-existing ID and expect an exception
        assertThrows(EntityNotFoundException.class, () -> etudiantService.findById(nonExistingId));
    }

    @Test
    void editExistingEtudiant() throws EntityNotFoundException, ChangeSetPersister.NotFoundException {
        // Prepare an etudiant and save it to the database
        Etudiant etudiant = Etudiant.builder()
                .nomEt("robert")
                .prenomEt("evans")
                .cin(1111111111111L)
                .ecole("esp")
                .email("roberts@gmail.com")
                .mdp("helllo")
                .build();
        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(etudiant);
        when(etudiantRepository.findById(etudiant.getIdEtudiant())).thenReturn(Optional.of(etudiant));

        // Modify some attributes of the etudiant
        etudiant.setNomEt("Updated Name");
        etudiant.setEmail("updated_email@example.com");

        // Update the etudiant using the service
        Etudiant updatedEtudiant = etudiantService.editEtudiant(etudiant.getIdEtudiant(), etudiant);

        // Verify that the etudiant was saved and returned correctly
        assertNotNull(updatedEtudiant);
        assertEquals("Updated Name", updatedEtudiant.getNomEt());
        assertEquals("updated_email@example.com", updatedEtudiant.getEmail());
    }



    // Implement the rest of the test methods similarly using Mockito
    @Test
    void findEtudiantByCinNonExistingCin() {
        // Prepare a non-existing CIN
        long nonExistingCin = Long.MAX_VALUE;

        // Stub the repository method to return null
        when(etudiantRepository.findEtudiantByCin(nonExistingCin)).thenReturn(null);

        // Attempt to find an etudiant with a non-existing CIN and expect an exception
        assertThrows(EntityNotFoundException.class, () -> etudiantService.findEtudiantByCin(nonExistingCin));
    }

    @Test
    void findEtudiantByCinExistingCin() {
        // Prepare an etudiant with a specific CIN
        long existingCin = 1234567890123L;
        Etudiant etudiant = Etudiant.builder().cin(existingCin).build();

        // Stub the repository method to return the etudiant with the specific CIN
        when(etudiantRepository.findEtudiantByCin(existingCin)).thenReturn(etudiant);

        // Retrieve the etudiant by its CIN using the service method
        Etudiant foundEtudiant = etudiantService.findEtudiantByCin(existingCin);

        // Assert that the retrieved etudiant is not null
        assertNotNull(foundEtudiant);
        // Assert that the retrieved etudiant has the same CIN as expected
        assertEquals(existingCin, foundEtudiant.getCin());
    }

    @Test
    void findEtudiantByEmailExistingEmail() {
        // Prepare an etudiant and save it to the database
        String existingEmail = "ella@gmail.com";
        Etudiant etudiant = Etudiant.builder()
                .nomEt("ella")
                .prenomEt("chris")
                .cin(1111111111111L)
                .ecole("supcom")
                .email(existingEmail)
                .mdp("flowers")
                .build();

        // Stub the repository method to return the etudiant with the specific email
        when(etudiantRepository.findEtudiantByEmail(existingEmail)).thenReturn(etudiant);

        // Retrieve the etudiant by its email using the service method
        Etudiant foundEtudiant = etudiantService.findEtudiantByEmail(existingEmail);

        // Assert that the retrieved etudiant is not null
        assertNotNull(foundEtudiant);
        // Assert that the retrieved etudiant has the same email as expected
        assertEquals(existingEmail, foundEtudiant.getEmail());
    }

    @Test
    void findEtudiantByEmailNonExistingEmail() {
        // Prepare a non-existing email
        String nonExistingEmail = "nonexisting@example.com";

        // Stub the repository method to return null
        when(etudiantRepository.findEtudiantByEmail(nonExistingEmail)).thenReturn(null);

        // Attempt to find an etudiant with a non-existing email and expect an exception
        assertThrows(EntityNotFoundException.class, () -> etudiantService.findEtudiantByEmail(nonExistingEmail));
    }

    @Test
    void findEtudiantsByEcole() {
        // Prepare etudiants with the same ecole
        String ecole = "Example Ecole";
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(Etudiant.builder().nomEt("John").prenomEt("Doe").ecole(ecole).build());
        etudiants.add(Etudiant.builder().nomEt("Jane").prenomEt("Doe").ecole(ecole).build());

        // Stub the repository method to return the etudiants with the specific ecole
        when(etudiantRepository.findByEcole(ecole)).thenReturn(etudiants);

        // Retrieve etudiants by ecole using the service method
        List<Etudiant> foundEtudiants = etudiantService.findEtudiantsByEcole(ecole);

        // Assert that the retrieved etudiants match the expected count
        assertEquals(etudiants.size(), foundEtudiants.size());
    }

    @Test
    void findEtudiantsByDateOfBirth() {
        // Prepare an etudiant with a specific date of birth
        LocalDate dateOfBirth = LocalDate.of(2000, 1, 1);
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(Etudiant.builder().nomEt("John").prenomEt("Doe").dateNaissance(dateOfBirth).build());

        // Stub the repository method to return the etudiants with the specific date of birth
        when(etudiantRepository.findEtudiantsBydateNaissance(dateOfBirth)).thenReturn(etudiants);

        // Retrieve etudiants by date of birth using the service method
        List<Etudiant> foundEtudiants = etudiantService.findEtudiantsByDateOfBirth(dateOfBirth);

        // Assert that the retrieved etudiants match the expected count
        assertEquals(etudiants.size(), foundEtudiants.size());
    }

    @Test
    void countEtudiants() {
        // Prepare the count of etudiants
        long count = 3;

        // Stub the repository method to return the count of etudiants
        when(etudiantRepository.count()).thenReturn(count);

        // Retrieve the count of etudiants using the service method
        long etudiantsCount = etudiantService.countEtudiants();

        // Assert that the count matches the expected count
        assertEquals(count, etudiantsCount);
    }

    @Test
    void existsByEmail() {
        // Prepare an etudiant with a specific email
        String email = "john.doe@example.com";
        Etudiant etudiant = Etudiant.builder().nomEt("John").prenomEt("Doe").email(email).build();

        // Stub the repository method to return true
        when(etudiantRepository.existsByEmail(email)).thenReturn(true);

        // Check if an etudiant exists by email using the service method
        boolean exists = etudiantService.existsByEmail(email);

        // Assert that the etudiant exists
        assertTrue(exists);
    }




}
