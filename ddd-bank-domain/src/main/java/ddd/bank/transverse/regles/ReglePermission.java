package ddd.bank.transverse.regles;

/**
 *
 */
public interface ReglePermission {
    public boolean estAutorise() throws AutorisationRegleException;
}
