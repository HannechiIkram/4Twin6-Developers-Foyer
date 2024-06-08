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


}
