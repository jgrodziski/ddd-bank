package bank.domain;

import ddd.bank.domain.facture.Facture;
import ddd.bank.domain.facture.FactureRepository;
import ddd.bank.domain.facture.IdFacture;
import ddd.bank.domain.facture.LigneFacture;

import java.util.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 */
public class FactureRepositoryMock {

    static {
        LigneFacture ligne = new LigneFacture();
        Set<LigneFacture> lignes = new LinkedHashSet<LigneFacture>();
        lignes.add(ligne);
        FACTURE = new Facture(new IdFacture(Long.valueOf("001")), lignes);
    }
    private static final Facture FACTURE;

    public static final FactureRepository getInstance() {
        FactureRepository repo = mock(FactureRepository.class);

        when(repo.findBy(any(IdFacture.class))).thenReturn(FACTURE);

        return repo;
    }

}
