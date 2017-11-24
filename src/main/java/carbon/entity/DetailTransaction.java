package carbon.entity;

import org.apache.commons.lang3.StringUtils;

/*
 * Created by tchauvin on 23/11/2017.
 */
public class DetailTransaction {

    private double montant;
    private double solde;

    public DetailTransaction(double valeurTransaction, double soldeCompte) {
        montant = valeurTransaction;
        solde = soldeCompte;
    }

    public static double determinerSolde(double soldeCompte, double valeurTransaction) {
        return soldeCompte + valeurTransaction;
    }

    public String toString() {
        String montantStr = StringUtils.leftPad(Double.toString(montant), 10);
        String soldeStr = StringUtils.leftPad(Double.toString(solde), 10);
        return "|" + montantStr + "|" + soldeStr + "|";
    }
}
