package ddd.syracuse;

import org.springframework.util.Assert;

/**
 *
 */
public class Commande {
    private Client client;
    private EtatCommande etatCommande;
    private Devis devis;

    public Commande(Client client){
        Assert.notNull(client, "Le client est obligatoire pour créer une commande");
        this.client = client;
    }

    public void annuler(){}
    public void mettreDansUn(Devis devis){}
    public void mettreDansUn(Contrat contrat){
        Assert.isTrue(etatCommande == EtatCommande.DANS_DEVIS, "La mise dans un contrat doit être précédé d'un devis");
    }
    public void demanderExecution(){}


}
