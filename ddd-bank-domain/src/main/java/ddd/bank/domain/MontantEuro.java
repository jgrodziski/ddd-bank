package ddd.bank.domain;

import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Currency;

/**
 *
 */
public class MontantEuro extends Montant {

    public MontantEuro(BigDecimal valeur) {
        super(valeur, Currency.getInstance("EUR"));
    }

    public MontantEuro(Montant montant){
        super(montant.getValeur(), montant.getDevise());
        Assert.state(montant.getDevise().equals(Currency.getInstance("EUR")));
    }

    public MontantEuro additionner(MontantEuro montantEuro) {
        return (MontantEuro)super.additionner((Montant)montantEuro);
    }
}
