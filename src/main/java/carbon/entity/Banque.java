package carbon.entity;

import carbon.DateUtil.DateGenerator;
import carbon.DateUtil.DefaultDateGenerator;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by tchauvin on 17/06/2017.
 */
public class Banque {

    final String nom;
    private Comptes comptes;

    public Banque(String nom) {
        this.nom = nom;
        this.comptes = new Comptes();
    }

    public String ouvrirCompte() {
        String numeroCompte = RandomStringUtils.random(8, true, true);
        DateGenerator dateGenerator = new DefaultDateGenerator();
        Compte nouveauCompte = new Compte(numeroCompte, dateGenerator);
        this.comptes.ajouterCompte(numeroCompte, nouveauCompte);
        return numeroCompte;
    }

    public int nombreComptes () {
        return comptes.nombreCompte();
    }

    public void supprimerCompte(String id) {
        comptes.supprimerCompte(id);
    }

    public Compte findCompteById(String id) {
        return comptes.findCompteById(id);
    }

    public boolean effectuerVirement(String idCompteDebiter, String idCompteCrediter, double montant) {

        if(montant == 0.0) {
            return false;
        }
        Compte compteDebiter = comptes.findCompteById(idCompteDebiter);
        if(compteDebiter == null) {
            return false;
        }

        Compte compteCrediter = comptes.findCompteById(idCompteCrediter);
        if(compteCrediter == null) {
            return false;
        }

        String numeroTransaction = RandomStringUtils.random(10, true, true);
        compteDebiter.effectuerTransaction(-montant, numeroTransaction);
        compteCrediter.effectuerTransaction(montant, numeroTransaction);

        return true;
    }
}
