package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ContextConfiguration(classes = {SecteurActiviteServiceImpl.class})
@ExtendWith(SpringExtension.class)
class SecteurTest {
    @MockBean
    private CategorieProduitRepository categorieProduitRepository;

    @MockBean
    private SecteurActiviteRepository secteurActiviteRepository;

    @Autowired
    private SecteurActiviteServiceImpl secteurActiviteService;
    @MockBean
    private StockRepository stockRepository;

    @Test
    void testRetrieveAllSectuer() {
        ArrayList<SecteurActivite> secteurList = new ArrayList<>();
        when(secteurActiviteRepository.findAll()).thenReturn(secteurList);
        List<SecteurActivite> actualRetrieveAllSectuerResult = secteurActiviteService.retrieveAllSecteurActivite();
        assertSame(secteurList, actualRetrieveAllSectuerResult);
        assertTrue(actualRetrieveAllSectuerResult.isEmpty());
        verify(secteurActiviteRepository).findAll();
    }

    @Test
    void testDeleteSectur() {
        doNothing().when(secteurActiviteRepository).deleteById((Long) any());
        secteurActiviteService.deleteSecteurActivite(123L);
        verify(secteurActiviteRepository).deleteById((Long) any());
    }
}
