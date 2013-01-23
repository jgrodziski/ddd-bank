package ddd.bank.domain;

import ddd.bank.transverse.RegleCalcul;

import java.math.BigDecimal;

/**
 * calculated_fee = amount in EUR * 1.5%, when calculated_fee < 1 EUR then return 1 EUR
 */
public class Frais implements RegleCalcul<Montant>{
    private MontantEuro montantEuro;
    public static final BigDecimal TAUX_FRAIS = new BigDecimal(0.015);

    public Frais(MontantEuro montantEuro) {
        this.montantEuro = montantEuro;
    }

    @Override
    public MontantEuro getResultat() {
        BigDecimal fraisCalcules = montantEuro.getValeur().multiply(TAUX_FRAIS);
        if (fraisCalcules.compareTo(BigDecimal.ONE) < 0) {
            return new MontantEuro(BigDecimal.ONE);
        }
        return new MontantEuro(fraisCalcules);
    }
}
