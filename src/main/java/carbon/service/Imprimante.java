package carbon.service;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by tchauvin on 23/11/2017.
 */
public class Imprimante {

    private static void imprimerEnTeteReleveDeCompte() {
        String lineSeprator = StringUtils.leftPad("", 65, "_");
        System.out.println(lineSeprator);
        System.out.println("|     N° Transaction |   Date Transaction |  montant |  balance |");
        System.out.println(lineSeprator);
    }

    public static void print(List<String> listTransaction) {
        String lineSeprator = StringUtils.leftPad("", 65, "_");
        imprimerEnTeteReleveDeCompte();
        for(String transactionStr : listTransaction) {
            System.out.println(transactionStr);
            System.out.println(lineSeprator);
        }
    }
}
