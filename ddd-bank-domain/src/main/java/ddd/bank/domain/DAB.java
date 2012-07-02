package ddd.bank.domain;

/**
 * Created by jeremiegrodziski
 */
public class DAB {
    private Localisation localisation;

    public DAB(String localisation) {
        this.localisation = new Localisation(localisation);
    }

    public Retrait retirer(Carte carte, Montant montant){
        carte.debiterImmediatement(montant);
        return new Retrait(carte, montant);
    };
}
