package ddd.bank.domain;

import java.util.Date;

/**
 *
 */
public class Paiement {
    private Montant montant;
    private Carte carte;
    private Date date;

    public Paiement(Montant montant, Carte carte, Date date) {
        this.montant = montant;
        this.carte = carte;
        this.date = date;
    }

    public Montant getMontant() {
        return montant;
    }

    public Carte getCarte() {
        return carte;
    }

    public Date getDate() {
        return date;
    }
}
