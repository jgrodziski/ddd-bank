package ddd.bank.domain;

import ddd.syracuse.PermissionRule;

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

    public void debiterImmediatement(Montant montantRetrait){
        new SoldeInsuffisantRule(compte.getSolde(), montantRetrait).estAutorise();
        compte.debiter(montantRetrait);
    }

    class SoldeInsuffisantRule implements PermissionRule {
        private Montant soldeCompte;
        private Montant montantRetrait;

        SoldeInsuffisantRule(Montant soldeCompte, Montant montantRetrait) {
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
