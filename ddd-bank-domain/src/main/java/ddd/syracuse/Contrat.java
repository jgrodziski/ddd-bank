package ddd.syracuse;

/**
 *
 */
public class Contrat {
    private EtatContrat etatContrat;
    Client client;

    public EtatContrat getEtat() {
        return etatContrat;
    }

    public Tarif calculerTarif(){
        return null;
    }

    public void lancer(){

    }

    public void relancer(){

    }

    /**
     *3-	Un contrat déjà en activité doit pouvoir être interrompu par le gestionnaire à tout moment. Ce n’est pas une résiliation mais une interruption pour cas de non-paiement ou autre à définir. Le contrat sera alors interrompu.
     */
    public void interrompre(){
        //TODO implémenter la régle :
        //3-	Un contrat déjà en activité doit pouvoir être interrompu par le gestionnaire à tout moment. Ce n’est pas une résiliation mais une interruption pour cas de non-paiement ou autre à définir. Le contrat sera alors interrompu.
        //4-	Un contrat interrompu doit pouvoir être relancé par le gestionnaire à tout moment.

    }

    public void resilier(){

    }
}
