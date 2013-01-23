package ddd.bank.domain;

import org.springframework.util.Assert;



/**
 *
 */
public class TauxCompose {
    private Taux tauxSourceIntermediaire;
    private Taux tauxIntermediaireCible;

    public TauxCompose(Taux tauxSourceIntermediaire, Taux tauxIntermediaireCible) {
        this.tauxSourceIntermediaire = tauxSourceIntermediaire;
        this.tauxIntermediaireCible = tauxIntermediaireCible;
        Assert.state(tauxSourceIntermediaire.getCible().equals(tauxIntermediaireCible.getSource()));
    }

    public Montant convertir(Montant montantSource){
        Assert.state(montantSource.getDevise().equals(tauxSourceIntermediaire.getSource()));
        Montant montantIntermediaire = tauxSourceIntermediaire.convertir(montantSource);
        Montant montantcible = tauxIntermediaireCible.convertir(montantIntermediaire);
        return montantcible;
    }
}
