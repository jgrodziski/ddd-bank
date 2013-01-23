package ddd.bank.domain.facture;

/**
 *
 */
public class Prestation {
    private ReferencePrestation reference;
    private PrestationType prestationType;


    public Prestation(String typePresta, String ref) {
        this.reference = new ReferencePrestation(ref);
        this.prestationType = new PrestationType(typePresta);
    }

    public ReferencePrestation getReference() {
        return reference;
    }

    public PrestationType getPrestationType() {
        return prestationType;
    }
}
