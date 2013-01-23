package ddd.bank.domain;

import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Currency;

/**
 *
 */
public class Taux {
    private BigDecimal taux;
    private Currency source;
    private Currency cible;

    public Taux(BigDecimal taux, Currency source, Currency cible) {
        this.taux = taux;
        this.source = source;
        this.cible = cible;
    }

    public Montant convertir(Montant montant){
        Assert.state(montant.getDevise().equals(source));
        return new Montant(montant.getValeur().multiply(taux), cible);
    }

    public BigDecimal getTaux() {
        return taux;
    }

    public Currency getSource() {
        return source;
    }

    public Currency getCible() {
        return cible;
    }
}


