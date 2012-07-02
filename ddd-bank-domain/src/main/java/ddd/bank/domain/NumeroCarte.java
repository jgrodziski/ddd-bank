package ddd.bank.domain;

/**
 * Created by jeremiegrodziski
 */
public class NumeroCarte {
    private String valeur;
    public NumeroCarte(String noCarte) {
        valeur = noCarte;
    }

    @Override
    public String toString() {
        return valeur;
    }
}
