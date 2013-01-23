package ddd.bank.domain;

import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by jeremiegrodziski
 */
public class Montant {
    private BigDecimal valeur;
    private Currency devise;
    public static final Montant ZERO = new Montant(BigDecimal.ZERO);

    public Montant(BigDecimal valeur){
        this.valeur = new BigDecimal(valeur.intValue());
        devise = Currency.getInstance("EUR");
    }

    public Montant(Integer valeur){
        this(new BigDecimal(valeur.intValue()));
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

    public Montant additionner(Montant montant) {
        Assert.state(montant.getDevise().equals(this.getDevise()),"La devise du montant additionné ("+montant.getDevise()+") doit être identique à l'objet source "+this.getDevise());
        return new Montant(this.getValeur().add(montant.getValeur()), this.getDevise());
    }

    @Override
    public String toString() {
        return "{"+ valeur + " " + devise + '}';
    }
}
