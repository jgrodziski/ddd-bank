package ddd.syracuse;

/**
 *
 */
public class Tarif {
    private TarifId tarifId;
    private Contrat contrat;

    public Tarif(Contrat contrat) {
        this.contrat = contrat;
    }
}
