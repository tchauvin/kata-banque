package carbon.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tchauvin on 23/11/2017.
 */
public class Comptes {

    private Map<String, Compte> comptes;

    public Comptes() {
        comptes = new HashMap<String, Compte>(0);
    }

    public void ajouterCompte(String id, Compte compte) {
        comptes.put(id, compte);
    }

    public void supprimerCompte(String compteId) {
        comptes.remove(compteId);
    }

    public int nombreCompte () {
        return comptes.size();
    }

    public Compte findCompteById (String id) {
        return comptes.get(id);
    }
}
