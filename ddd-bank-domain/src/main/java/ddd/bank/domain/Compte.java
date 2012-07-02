package ddd.bank.domain;

/**
 * Created by jeremiegrodziski
 */
public class Compte {
    private Montant solde;
    private String numero;

    public Compte(Montant solde, String numero) {
        this.solde = solde;
        this.numero = numero;
    }

    public Montant getSolde() {
        return solde;
    }

    public String getNumero() {
        return numero;
    }

    public Montant debiter(Montant montant) {
        this.solde = solde.soustraire(montant);
        return solde;
    }
}
