package bank.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import ddd.bank.domain.*;
import org.jbehave.core.annotations.*;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Date;

/**
 *
 */
public class CreditCardSteps {
    Porteur porteur;
    Carte carte;
    Banque banque;
    Compte compte;
    DAB dab;
    Retrait retrait;

    @Given("le porteur $prenom $nom possède la carte no $noCarte en $deviseCarte et un débit de $debit EUR associé au compte bancaire $noCompte avec un solde de $solde \u20AC \u00E0 la banque $nomBanque")
    public void givenLePorteurPossèdeLaCarte(String nom, String prenom, String noCarte, String deviseCarte, Integer debit, String noCompte, Integer solde, String nomBanque) {
        porteur = new Porteur(prenom, nom);
        compte = new Compte(new Montant(solde),noCompte);
        carte = new Carte( new NumeroCarte(noCarte), new Date(System.currentTimeMillis()+(1000*60*60*24*365*2)),prenom + " " + nom, compte);
        banque = new Banque(nomBanque);
    }

    @When("le porteur effectue un retrait de $montantRetrait EUR au DAB de $localisation")
    public void whenLePorteurEffectueUnRetrait(Integer montantRetrait, String localisation) {
        dab = new DAB(localisation);
        retrait = dab.retirer(carte, new Montant(montantRetrait));
    }

    @Then("il obtient $montant € en esp\u00E8ces")
    public void thenIlObtientMontantEnEspeces(Integer montant) {
        Montant valeurAttendu = new Montant(montant);
        Assert.state(retrait.getMontant().equals(valeurAttendu));
    }

    @Then("le solde du compte est de $solde €")
    public void thenLeSoldeDuCompteEstDe900€(Integer solde) {
        Montant soldeAttendu = new Montant(solde);
        Assert.state(compte.getSolde().equals(soldeAttendu));
    }


}
