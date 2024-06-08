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
import org.springframework.data.crossstore.ChangeSetPersister;

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
    public void testUpdateEtudiantEmail() throws ChangeSetPersister.NotFoundException {
        // Given
        Long etudiantId = 1L;
        String newEmail = "newemail@example.com";
        Etudiant existingEtudiant = new Etudiant();

        existingEtudiant.setEmail("oldemail@example.com");

        when(etudiantRepository.findById(etudiantId)).thenReturn(Optional.of(existingEtudiant));
        when(etudiantRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        // When
        Etudiant updatedEtudiant = etudiantService.updateEtudiantEmail(etudiantId, newEmail);

        // Then
        assertEquals(newEmail, updatedEtudiant.getEmail());
        verify(etudiantRepository, times(1)).findById(etudiantId);
        verify(etudiantRepository, times(1)).save(any());
    }

}
