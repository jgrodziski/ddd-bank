package ddd.bank.domain;

import java.util.Date;

/**
 * Created by jeremiegrodziski
 */
public class Carte {
    private NumeroCarte numeroCarte;
    private Date dateExpiration;
    private String nom;
    private Compte compte;

    public Carte(NumeroCarte numeroCarte, Date dateExpiration, String nom, Compte compte) {
        this.numeroCarte = numeroCarte;
        this.dateExpiration = dateExpiration;
        this.nom = nom;
        this.compte = compte;
    }

    public void debiterImmediatement(Montant montant){
        compte.debiter(montant);
    }

    public NumeroCarte getNumeroCarte() {
        return numeroCarte;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public String getNom() {
        return nom;
    }

    public Compte getCompte() {
        return compte;
    }
}
