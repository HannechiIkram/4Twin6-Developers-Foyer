
package com.example.foyer;


import com.example.foyer.entity.Bloc;
import com.example.foyer.service.bloc.BlocServiceImpl;
import com.example.foyer.service.bloc.IBlocService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.class)

public class BlocImplTest {
    @Autowired
    @JsonIgnore

    BlocServiceImpl blocService;
    @Test
    public void testAjouterBloc(){


        // Create a Bloc instance
        Bloc bloctest = Bloc.builder()
                .nomBloc("bloc A")
                .capaciteBloc(1500)
                .build();

        // Add the Bloc to the service
        Bloc blocajouté = blocService.addBloc(bloctest);

        // Now, blocajouté should have the associated chambre
        //  Assertions.assertNotNull(blocajouté.getIdBloc());
        assertNotEquals(0, blocajouté.getIdBloc());
    }
}



