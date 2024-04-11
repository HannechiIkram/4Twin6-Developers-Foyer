package com.example.foyer;

import com.example.foyer.entity.Chambre;
import com.example.foyer.entity.TypeChambre;
import com.example.foyer.service.chambre.ChambreServiceImpl;
import com.example.foyer.service.chambre.IChambreService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.example.foyer.entity.TypeChambre.DOUBLE;
import static com.example.foyer.entity.TypeChambre.SIMPLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@ActiveProfiles("test")



public class ChambreServiceImplTest {
    @Autowired
ChambreServiceImpl chambreService;
@Test
    public void testaddChambre(){
    Chambre chambre =Chambre.builder().numeroChambre(60).typeChambre(SIMPLE).build();
    Chambre savedChambre = chambreService.addChambre(chambre);
    Assertions.assertNotNull(savedChambre.getIdChambre());
    //chambreService.delete(savedChambre);
}

@Test
    public void testAddChambres() {
        List<Chambre> chambres = new ArrayList<>();
        chambres.add(Chambre.builder().numeroChambre(55).typeChambre(TypeChambre.SIMPLE).build());
        chambres.add(Chambre.builder().numeroChambre(56).typeChambre(TypeChambre.DOUBLE).build());

        List<Chambre> savedChambres = chambreService.addChambres(chambres);
        assertEquals(2, savedChambres.size());
    }
    @Test
    public void testEditChambre() {
        Chambre chambre = Chambre.builder().idChambre(1).numeroChambre(20).typeChambre(TypeChambre.TRIPLE).build();
        Chambre editedChambre = chambreService.editChambre(chambre);
        assertEquals(chambre.getIdChambre(), editedChambre.getIdChambre());
    }
    @Test
    public void testFindAll() {
        List<Chambre> foundChambres = chambreService.findAll();
        Assertions.assertNotNull(foundChambres);
    }



}
