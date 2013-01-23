package ddd.bank.domain;


import ddd.bank.transverse.regles.ReglePermission;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * Created by jeremiegrodziski
 */
public class Carte implements Entity {
    private NumeroCarte numeroCarte;
    private Date dateExpiration;
    private String nom;
    private Compte compte;
    private CodeSecret codeSecret;
    private EtatCarte etatCarte;

    public Carte(NumeroCarte numeroCarte, Date dateExpiration, String nomPorteur, Compte compte) {
        this.numeroCarte = numeroCarte;
        this.dateExpiration = dateExpiration;
        this.nom = nomPorteur;
        this.compte = compte;
        this.etatCarte = EtatCarte.VALIDE;
    }

    public void expirer(Date dateDuJour){
        Assert.state(etatCarte == EtatCarte.VALIDE);
        if (dateDuJour.after(dateExpiration))
            etatCarte = EtatCarte.EXPIRE;
    }

    public void mettreEnOpposition(){
        Assert.state(etatCarte == EtatCarte.VALIDE);
        this.etatCarte = EtatCarte.BLOQUE;
    }

    public void payer(Montant montant, Commercant commercant){
        Assert.state(etatCarte == EtatCarte.VALIDE);
        compte.debiter(montant);
        commercant.crediter(montant);
    }

    public void debiterImmediatement(Montant montant){
        Assert.state(etatCarte == EtatCarte.VALIDE);
        new RegleSoldeInsuffisant(compte.getSolde(), montant).estAutorise();
        compte.debiter(montant);
    }

    class RegleSoldeInsuffisant implements ReglePermission {
        private Montant soldeCompte;
        private Montant montantRetrait;

        RegleSoldeInsuffisant(Montant soldeCompte, Montant montantRetrait) {
            this.soldeCompte = soldeCompte;
            this.montantRetrait = montantRetrait;
        }

        @Override
        public boolean estAutorise() {
            boolean estAutorise = montantRetrait.getValeur().compareTo(soldeCompte.getValeur()) < 0;
            if (! estAutorise) throw new RuntimeException("Le montant du retrait "+montantRetrait.getValeur()+" doit être inférieur au solde du compte "+soldeCompte.getValeur());
            return estAutorise;
        }
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
