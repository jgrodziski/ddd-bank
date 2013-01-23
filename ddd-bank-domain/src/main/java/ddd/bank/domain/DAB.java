package ddd.bank.domain;

/**
 * Created by jeremiegrodziski
 */
public class DAB {
    private Localisation localisation;
    private static boolean ticketEmis = true;

    public DAB(String localisation) {
        this.localisation = new Localisation(localisation);
    }

    public static boolean isTicketEmis() {
        return ticketEmis;
    }

    public Retrait retirer(Carte carte, Montant montant){
        carte.debiterImmediatement(montant);
        return new Retrait(carte, montant);
    };
}
