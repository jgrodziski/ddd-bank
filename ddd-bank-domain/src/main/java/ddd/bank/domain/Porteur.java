package ddd.bank.domain;

/**
 * Created by jeremiegrodziski
 */
public class Porteur {
    private String prenom;
    private String nom;

    public Porteur(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }
}
