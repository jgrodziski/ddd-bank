package ddd.syracuse;

/**
 *
 */
public class Client {

    public void ajouterCommande(Contrat contrat, Commande commande){
        new AjoutCommandeAutorisee(contrat.getEtat()).estAutorise();
    }

    /**
     * BR_001
     * 2-	Pour un contrat déjà en activité, le gestionnaire ne pourra pas ajouter une commande. En effet, cela obligerait le système à gérer plusieurs dates d’effet. Le gestionnaire devra mettre en place un nouveau dossier et un nouveau contrat. (à étudier)
     */
    public class AjoutCommandeAutorisee implements PermissionRule {
        EtatContrat etatContrat;

        public AjoutCommandeAutorisee(EtatContrat etatContrat) {
            this.etatContrat = etatContrat;
        }

        @Override
        public boolean estAutorise() {
            if (etatContrat == EtatContrat.CREE){
                return true;
            }
            return false;
        }
    }

}
