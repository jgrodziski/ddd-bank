package ddd.bank.domain;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by jeremiegrodziski
 */
public class Montant {
    private BigDecimal valeur;
    private Currency devise;

    public Montant(Integer valeur){
        this.valeur = new BigDecimal(valeur.intValue());
        devise = Currency.getInstance("EUR");
    }

    public Montant(BigDecimal valeur, Currency devise) {
        this.valeur = valeur;
        this.devise = devise;
    }

    public BigDecimal getValeur() {
        return valeur;
    }

    public Currency getDevise() {
        return devise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Montant montant = (Montant) o;

        if (devise != null ? !devise.equals(montant.devise) : montant.devise != null) return false;
        if (valeur != null ? !valeur.equals(montant.valeur) : montant.valeur != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = valeur != null ? valeur.hashCode() : 0;
        result = 31 * result + (devise != null ? devise.hashCode() : 0);
        return result;
    }

    public Montant soustraire(Montant montant) {
        return new Montant(this.valeur.subtract(montant.getValeur()), this.getDevise());
    }
}
