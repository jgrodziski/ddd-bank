package bank.domain;

import ddd.bank.domain.facture.Facture;
import ddd.bank.domain.facture.FactureRepository;
import ddd.bank.domain.facture.IdFacture;
import ddd.bank.domain.facture.Prestation;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.util.Assert;

/**
 *
 */
public class FactureSteps {
    FactureRepository factureRepository = FactureRepositoryMock.getInstance();
    private Facture facture;

    @Given("la facture $idFacture existe dans le syst\u00E8me")
    public void givenLaFactureExisteDansLeSystème(String idFacture) {
        facture = factureRepository.findBy(new IdFacture(Long.valueOf(idFacture)));
    }

    @When("je reconcilie la prestation type $typePresta ref $ref avec la facture")
    public void whenJeReconcilieLaPrestationtypeDépannageAutoRefABCAvecLaFacture001(String typePresta, String ref) {
        facture.reconcilier(new Prestation(typePresta, ref));
    }

    @Then("l'\u00E9tat de la facture est RECONCILIEE")
    public void thenLétatDeLaFactureEstRECONCILIEE() {
        Assert.state(facture.getEtat().equals(Facture.ETAT.RECONCILIEE));
    }

}
