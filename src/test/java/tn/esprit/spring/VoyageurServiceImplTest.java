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
    VoyageurRepository sto;
    @InjectMocks
    VoyageurServiceImpl VoyageurService;
    Voyageur voyageur = new Voyageur((long) 10,"Ali");

    @Test
    public void testAjouterVoyageur() {

        Mockito.when(VoyageurService.ajouterVoyageur(ArgumentMatchers.any(Voyageur.class))).thenReturn(this.voyageur);
        Voyageur savedVoyageur= VoyageurService.ajouterVoyageur(this.voyageur);

        assertNotNull(savedVoyageur.getIdVoyageur());
        assertNotNull( savedVoyageur.getNomVoyageur());
    //	assertTrue(savedVoyageur.getQteMin()>0);

        VoyageurService.supprimerVoyageur(savedVoyageur);

    }

    @Test
    public void testSupprimerVoyageur() {
        VoyageurService.ajouterVoyageur(this.voyageur);
        VoyageurService.supprimerVoyageur(this.voyageur);
        assertNull(VoyageurService.recupererVoyageParId(this.voyageur.getIdVoyageur()));
    }

    @Test
    public void testRecupererVoyageParId() {
        Mockito.when(sto.findById(Mockito.anyLong())).thenReturn(Optional.of(this.voyageur));
        Voyageur voyageur = VoyageurService.recupererVoyageParId(this.voyageur.getIdVoyageur());
    }


    /* @Test
    public void testAddVoyageur() {
        Mockito.when(sto.save(s)).thenReturn(s);
        Voyageur s1 = VoyageurService.addVoyageur(s);
        Assertions.assertNotNull(s1);

    } */

    @Test
    public void testModifierVoyageur() {
        this.voyageur.setNomVoyageur("Salim");
        Mockito.when(sto.save(this.voyageur)).thenReturn(this.voyageur);
        Voyageur voyageur = VoyageurService.modifierVoyageur(this.voyageur);
        Assertions.assertEquals(this.voyageur,voyageur);

    }
}


