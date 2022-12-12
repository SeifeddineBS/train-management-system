package tn.esprit.spring;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.repository.VoyageurRepository;
import tn.esprit.spring.services.VoyageurServiceImpl;




import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
@RunWith(SpringRunner.class)
@Slf4j
@ExtendWith(MockitoExtension.class)

@MockitoSettings(strictness = Strictness.LENIENT)
@SpringBootTest
public class VoyageurServiceImplTest {
    @Mock
    VoyageurRepository voyageurRepository;
    @InjectMocks
    VoyageurServiceImpl voyageurService;
    
    Voyageur voyageur = new Voyageur((long) 10,"Ali");

    @Test
    public void testAjouterVoyageur() {

        Mockito.when(voyageurService.ajouterVoyageur(ArgumentMatchers.any(Voyageur.class))).thenReturn(this.voyageur);
        Voyageur savedVoyageur= voyageurService.ajouterVoyageur(this.voyageur);

        assertNotNull(savedVoyageur.getIdVoyageur());
        assertNotNull( savedVoyageur.getNomVoyageur());
    //	assertTrue(savedVoyageur.getQteMin()>0);

        voyageurService.supprimerVoyageur(savedVoyageur);

    }

    @Test
    public void testSupprimerVoyageur() {
        voyageurService.ajouterVoyageur(this.voyageur);
        voyageurService.supprimerVoyageur(this.voyageur);
        assertNull(voyageurService.recupererVoyageParId(this.voyageur.getIdVoyageur()));
    }

    @Test
    public void testRecupererVoyageParId() {

        Mockito.when(voyageurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(this.voyageur));
        Voyageur savedVoyageur=voyageurService.ajouterVoyageur(this.voyageur);

       // Voyageur voyageur = voyageurService.recupererVoyageParId(savedVoyageur.getIdVoyageur());

  //      assertNotNull(voyageur.getIdVoyageur());
//        voyageurService.supprimerVoyageur(savedVoyageur);


    }


    /* @Test
    public void testAddVoyageur() {
        Mockito.when(sto.save(s)).thenReturn(s);
        Voyageur s1 = voyageurService.addVoyageur(s);
        Assertions.assertNotNull(s1);

    } */

    @Test
    public void testModifierVoyageur() {
        this.voyageur.setNomVoyageur("Salim");
        Mockito.when(voyageurRepository.save(this.voyageur)).thenReturn(this.voyageur);
        Voyageur voyageur = voyageurService.modifierVoyageur(this.voyageur);
        Assertions.assertEquals(this.voyageur,voyageur);

    }
}

