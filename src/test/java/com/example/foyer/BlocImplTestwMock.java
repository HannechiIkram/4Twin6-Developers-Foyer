package com.example.foyer;
import com.example.foyer.entity.Bloc;
import com.example.foyer.repository.BlocRepo;
import com.example.foyer.service.bloc.BlocServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class BlocImplTestwMock {

    @Mock
    private BlocRepo blocRepo;

    @InjectMocks
    private BlocServiceImpl blocService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDeleteBloc() {
        // Crée un objet Bloc fictif pour le test
        Bloc blocToDelete = new Bloc();
        blocToDelete.setIdBloc(1L); // Supposons que l'ID du bloc à supprimer soit 1

        // Mock de la méthode delete de BlocRepo
        doNothing().when(blocRepo).delete(any(Bloc.class));

        // Appel de la méthode delete de BlocServiceImpl
        blocService.delete(blocToDelete);

        // Vérification que la méthode delete de BlocRepo a été appelée avec le bon argument
        verify(blocRepo, times(1)).delete(blocToDelete);
    }
}
