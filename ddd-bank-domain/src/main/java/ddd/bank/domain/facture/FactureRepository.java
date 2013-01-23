package ddd.bank.domain.facture;

/**
 *
 */
public interface FactureRepository {

    public Facture findBy(IdFacture id);
    public Facture findBy(ReferencePrestation ref);

    public void delete(IdFacture id);
    public void put(Facture facture);
}
