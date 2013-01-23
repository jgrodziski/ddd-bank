package bank.domain;

import bank.domain.exchange.ExchangeServiceMock;
import ddd.bank.domain.*;
import ddd.bank.domain.exchange.ExchangeService;
import ddd.bank.domain.exchange.QuoteDTO;
import junit.framework.Assert;
import org.jbehave.core.annotations.*;

import java.math.BigDecimal;
import java.util.Currency;
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

    ExchangeService exchange;
    private Paiement paiement;

    @Given("le porteur $prenom $nom possède la carte no $noCarte en $deviseCarte et un débit de $debit $deviseCarte associé au compte bancaire $noCompte avec un solde de $solde \u20AC \u00E0 la banque $nomBanque")
    public void givenLePorteurPossedeLaCarte(@Named("prenom") String prenom, @Named("nom") String nom, @Named("noCarte") String noCarte,@Named("deviseCarte") String deviseCarte,@Named("debit") Integer debit, @Named("noCompte") String noCompte,@Named("solde") Integer solde, @Named("nomBanque") String nomBanque) {
        porteur = new Porteur(prenom, nom);
        compte = new Compte(new Montant(solde),noCompte);
        long dansDeuxAns = System.currentTimeMillis()+(1000*60*60*24*365*2);
        carte = new Carte( new NumeroCarte(noCarte), new Date(dansDeuxAns),prenom + " " + nom, compte);
        banque = new Banque(nomBanque);
        re = null;
        dab = null;
        retrait = null;
    }

    @Given("le service ExchangeService est initialis\u00E9 avec le taux du jour $taux pour EUR-CHF")
    @Pending
    public void givenLeServiceExchangeServiceEstInitialise(double taux) {
        exchange = ExchangeServiceMock.getInstance(taux);
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
        Assert.assertEquals(valeurAttendu, retrait.getMontant());
    }

    @Then("le solde du compte est de $solde €")
    public void thenLeSoldeDuCompteEstDe(Integer solde) {
        Montant soldeAttendu = new Montant(solde);
        Assert.assertEquals(soldeAttendu, compte.getSolde());
    }

    @Then("il obtient le message \"solde insuffisant\"")
    public void thenIlObtientLeMessagesoldeInsuffisant() {
        //Assert.assertTrue(re != null);
        System.out.println(re.getMessage());
    }

    @When("le porteur effectue un paiement chez le commerçant $commercant de $montant $devisePaiementString")

    public void whenLePorteurEffectueUnPaiementDe(String commercant, Integer montant, String devisePaiementString) {
        Currency devisePaiement = Currency.getInstance(devisePaiementString);
        Montant montantPaiement = new Montant(new BigDecimal(montant), devisePaiement);

        QuoteDTO quote = exchange.findCurrentRate(devisePaiement);
        Taux taux = new Taux(quote.rate, devisePaiement, Currency.getInstance("EUR"));

        MontantEuro montantPaiementEuro = new MontantEuro(taux.convertir(montantPaiement));
        Frais frais = new Frais(montantPaiementEuro);

        MontantEuro montantTotal = montantPaiementEuro.additionner(frais.getResultat());
        carte.payer(montantPaiementEuro, new Commercant(commercant));
    }

    @Then("les frais calculés sont de 1.23 EUR")
    public void thenLesFraisCalculeSont() {
        // EN SUSPENS
    }

    @Then("le débit de la carte est de 83.23 EUR")
    @Pending
    public void thenLeDebitDeLaCarteEstDe() {
        // EN SUSPENS
    }

    @Then("le DAB émet le ticket récapitulatif")
    public void thenLeDABEmetLeTicketRecapitulatif() {
        Assert.assertTrue(DAB.isTicketEmis());
    }



}
