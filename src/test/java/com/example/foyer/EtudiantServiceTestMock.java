package com.example.foyer;

import com.example.foyer.entity.Etudiant;
import com.example.foyer.repository.EtudiantRepository;
import com.example.foyer.service.etudiant.EtudiantServiceImpl;
import com.example.foyer.service.IEtudiantService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EtudiantServiceTestMock {

    @Mock
    private EtudiantRepository etudiantRepository;

    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deleteById() {
        // Définir l'ID de l'étudiant à supprimer
        Long idToDelete = 1L;

       
       // Simuler le cas où l'identifiant de l'étudiant n'est pas trouvé dans la base de données
doThrow(EmptyResultDataAccessException.class).when(etudiantRepository).deleteById(idToDelete);

// Appeler la méthode deleteById de votre service
assertThrows(EmptyResultDataAccessException.class, () -> etudiantService.deleteById(idToDelete));



    }

    @Test
    public void addEtudiant() {
        // Créer un étudiant de test
        Etudiant etudiant = new Etudiant();
        etudiant.setNomEt("John");
        etudiant.setPrenomEt("Doe");
        etudiant.setEmail("john.doe@example.com");
        etudiant.setCin(1234567890L);

        // Simuler le comportement du repository pour sauvegarder l'étudiant
        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(etudiant);

        // Appeler la méthode addEtudiant de votre service
        Etudiant savedEtudiant = etudiantService.addEtudiant(etudiant);

        // Vérifier si l'étudiant retourné correspond à celui qui a été sauvegardé
        assertEquals("John", savedEtudiant.getNomEt());
        assertEquals("Doe", savedEtudiant.getPrenomEt());
        assertEquals("john.doe@example.com", savedEtudiant.getEmail());
        assertEquals(1234567890L, savedEtudiant.getCin());
    }

    @Test
    public void findById() {
        // Créer un étudiant de test
        Etudiant etudiant = new Etudiant();

        etudiant.setNomEt("Jane");
        etudiant.setPrenomEt("Doe");
        etudiant.setEmail("jane.doe@example.com");
        etudiant.setCin(9876543210L);

        // Simuler le comportement du repository pour retourner l'étudiant par ID
        when(etudiantRepository.findById(1L)).thenReturn(Optional.of(etudiant));

        // Appeler la méthode findById de votre service
        Etudiant foundEtudiant = etudiantService.findById(1L);

        // Vérifier si l'étudiant retourné correspond à celui qui a été simulé
        assertEquals("Jane", foundEtudiant.getNomEt());
        assertEquals("Doe", foundEtudiant.getPrenomEt());
        assertEquals("jane.doe@example.com", foundEtudiant.getEmail());
        assertEquals(9876543210L, foundEtudiant.getCin());
    }

    @Test
    public void deleteAll() {
        // Appeler la méthode deleteAll de votre service
        etudiantService.deleteAll();

        // Vérifier si la méthode deleteAll du repository a été appelée une fois
        verify(etudiantRepository, times(1)).deleteAll();
    }

}
