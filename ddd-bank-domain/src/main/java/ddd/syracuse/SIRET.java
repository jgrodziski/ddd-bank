package ddd.syracuse;

/**
 *
 */
public class SIRET {
    NIC nic;
    SIREN siren;

    public SIRET(SIREN siren, NIC nic) {
        this.nic = nic;
        this.siren = siren;
    }

    public static final boolean estValide(String siret){
        return true;
    }
}
