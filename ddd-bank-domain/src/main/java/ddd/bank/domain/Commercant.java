package ddd.bank.domain;

/**
 * Created by jeremiegrodziski
 */
public class Commercant {
    private Montant solde = Montant.ZERO;
    private String commercant;

    public Commercant(String commercant) {
        this.commercant = commercant;
    }

    public void crediter(Montant montant) {
        solde.additionner(montant);
    }
}
