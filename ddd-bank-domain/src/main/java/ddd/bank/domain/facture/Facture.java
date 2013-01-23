package ddd.bank.domain.facture;

import com.sun.corba.se.spi.ior.IdentifiableFactory;
import ddd.bank.domain.Paiement;

import java.util.Set;

/**
 *
 */
public class Facture {
    public ETAT getEtat() {
        return etat;
    }

    public static enum ETAT {
        RECUE, PAYEE, RECONCILIEE, CONFORME
    }
    private ETAT etat = null;
    private IdFacture id;
    Set<LigneFacture> lignes = null;


    public Facture(IdFacture id, Set<LigneFacture> lignes) {
        this.id = id;
        this.lignes = lignes;
        this.etat = ETAT.RECUE;
    }

    public void payer(Paiement paiement){

    }

    public void reconcilier(Prestation prestation){
        for (LigneFacture ligne : lignes) {
            if (ligne != null){
                if (ligne.getReferencePrestation() != null){
                    if (ligne.getReferencePrestation().equals(prestation.getReference())){
                        ligne.reconcilier();
                    }
                }
            }
        }
    }


}
