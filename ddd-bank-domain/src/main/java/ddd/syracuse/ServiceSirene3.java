package ddd.syracuse;

/**
 * Représente le service web Sirene3.
 * Le service renvoit un
 * */
public interface ServiceSirene3 {

    Etablissement getEtablissementFromSiret(String siret);
    Etablissement getEntrepriseFromSiren(String siren);

}
