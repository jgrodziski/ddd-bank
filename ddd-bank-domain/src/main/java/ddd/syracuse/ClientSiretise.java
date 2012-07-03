package ddd.syracuse;


/**
 *
 */
public class ClientSiretise {


    //TODO ID ?
    //TODO type client enum? SIRETISE, NON_SIRETISE, PARTICULIER ?
    //ID = SIRET
    SIRET siret;//ID
    RaisonSocialeCourte raisonSociale;
    RaisonSocialeLongue raisonSocialeLongue;
    CategorieJuridique categorieJuridique;
    StatutJuridique statutJuridique;
    CodeAPEN codeAPEN;//VO
    CodeAPET codeAPET;//VO
    Adresse adresse;//VO

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientSiretise that = (ClientSiretise) o;

        if (siret != null ? !siret.equals(that.siret) : that.siret != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return siret != null ? siret.hashCode() : 0;
    }
}
