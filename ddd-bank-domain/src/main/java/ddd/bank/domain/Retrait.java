package ddd.bank.domain;

import java.util.Date;

/**
 * Created by jeremiegrodziski
 */
public class Retrait {
    private Carte carteUtilise;
    private Montant montant;
    private Date date;

    public Retrait(Carte carteUtilise, Montant montant) {
        this.carteUtilise = carteUtilise;
        this.montant = montant;
        date = new Date();
    }

    public Carte getCarteUtilise() {
        return carteUtilise;
    }

    public Montant getMontant() {
        return montant;
    }

    public Date getDate() {
        return date;
    }
}
