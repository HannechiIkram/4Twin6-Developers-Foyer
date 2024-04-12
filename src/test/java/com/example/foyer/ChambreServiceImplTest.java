package com.example.foyer;

import com.example.foyer.entity.Chambre;
import com.example.foyer.entity.TypeChambre;
import com.example.foyer.service.chambre.ChambreServiceImpl;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.example.foyer.entity.TypeChambre.DOUBLE;
import static com.example.foyer.entity.TypeChambre.SIMPLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest

public class ChambreServiceImplTest {
    @Autowired
    ChambreServiceImpl chambreService;
    @Test
    public void testaddChambre(){
        Chambre chambre =Chambre.builder().numeroChambre(82).typeChambre(SIMPLE).build();
        Chambre savedChambre = chambreService.addChambre(chambre);
        Assertions.assertNotNull(savedChambre.getIdChambre());
        //chambreService.delete(savedChambre);
    }

@Test
    public void testAddChambres() {
        List<Chambre> chambres = new ArrayList<>();
        chambres.add(Chambre.builder().numeroChambre(603).typeChambre(TypeChambre.TRIPLE).build());
        chambres.add(Chambre.builder().numeroChambre(608).typeChambre(TypeChambre.TRIPLE).build());

        List<Chambre> savedChambres = chambreService.addChambres(chambres);
        assertEquals(2, savedChambres.size());
    }
    @Test
    public void testEditChambre() {
        Chambre chambre = Chambre.builder().idChambre(1).numeroChambre(204).typeChambre(TypeChambre.TRIPLE).build();
        Chambre editedChambre = chambreService.editChambre(chambre);
        assertEquals(chambre.getIdChambre(), editedChambre.getIdChambre());
    }
    @Test
    public void testFindAll() {
        List<Chambre> foundChambres = chambreService.findAll();
        Assertions.assertNotNull(foundChambres);
    }



}
