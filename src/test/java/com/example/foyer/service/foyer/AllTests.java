package com.example.foyer.service.foyer;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
        FoyerServiceImplTesting.class,

        FoyerServiceImplIT.class,
})
public class AllTests {
    // Cette classe ne contient aucun code car elle sert uniquement à exécuter tous les tests
}