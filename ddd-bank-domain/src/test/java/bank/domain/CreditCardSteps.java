package bank.domain;

import ddd.bank.domain.*;
import org.jbehave.core.annotations.*;
import org.joda.time.Duration;
import org.joda.time.ReadableInstant;
import org.springframework.util.Assert;

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
    RuntimeException re;

    @Given("le porteur $prenom $nom possède la carte no $noCarte en $deviseCarte et un débit de $debit EUR associé au compte bancaire $noCompte avec un solde de $solde \u20AC \u00E0 la banque $nomBanque")
    public void givenLePorteurPossedeLaCarte(String nom, String prenom, String noCarte, String deviseCarte, Integer debit, String noCompte, Integer solde, String nomBanque) {
        porteur = new Porteur(prenom, nom);
        compte = new Compte(new Montant(solde),noCompte);
        long dansDeuxAns = System.currentTimeMillis()+(1000*60*60*24*365*2);
        carte = new Carte( new NumeroCarte(noCarte), new Date(dansDeuxAns),prenom + " " + nom, compte);
        banque = new Banque(nomBanque);
    }

    @When("le porteur effectue un retrait de $retrait EUR au DAB de $localisation")
    public void whenLePorteurEffectueUnRetrait(Integer retrait, String localisation) {
        dab = new DAB(localisation);
        try {
            this.retrait = dab.retirer(carte, new Montant(retrait));
        } catch (RuntimeException re){
            this.re = re;
        }
    }

    @Then("il obtient $montant € en esp\u00E8ces")
    public void thenIlObtientMontantEnEspeces(Integer montant) {
        Montant valeurAttendu = new Montant(montant);
        Assert.state(retrait.getMontant().equals(valeurAttendu));
    }

    @Then("le solde du compte est de $solde €")
    public void thenLeSoldeDuCompteEstDe(Integer solde) {
        Montant soldeAttendu = new Montant(solde);
        Assert.state(compte.getSolde().equals(soldeAttendu));
    }

    @Then("il obtient le message \"solde insuffisant\"")
    public void thenIlObtientLeMessagesoldeInsuffisant() {
        Assert.state(re != null);
        System.out.println(re.getMessage());
    }


}
