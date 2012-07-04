package ddd.syracuse;

import java.util.HashSet;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Training
 * Date: 7/4/12
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class ServiceSirene3Impl implements ServiceSirene3{

    private static ServiceSirene3Impl instance=null;
    private static Set<String> nomencSiren=new HashSet<String>();
    private ServiceSirene3Impl() {
        nomencSiren.add("123456782") ;
    }
    public static ServiceSirene3Impl getInstance() {
        if (instance==null) {
            instance=new ServiceSirene3Impl();
        }
        return instance;
    }
    public Etablissement getEtablissement(String siret) {
        if (siret.length()<9) {
            return null;
        }
        if (nomencSiren.contains(siret.substring(0,9)))  {
            String nic="";
            if (siret.length() > 9) {
                nic=siret.substring(9);
                if (!nic.matches("([0-9])5"))  {
                    return null;
                }
            }
            Etablissement et=new Etablissement();
            et.setSiret(siret);
            et.setAdresse(nic+" suresne");
            et.setCj("315");
            et.setPays("France");
            et.setRaisonSociale("DANONE");
            et.setStatutJuridique("55SA A CONSEIL ADMINISTRATION");
            et.setApen("7010z");
            et.setApet("1000a");
            return et;
        }
        return null;
    }

}
