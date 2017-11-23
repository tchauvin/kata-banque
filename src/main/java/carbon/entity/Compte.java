package carbon.entity;

import carbon.DateUtil.DateGenerator;
import carbon.DateUtil.DefaultDateGenerator;

import java.util.Date;
import java.util.List;

/**
 * Created by tchauvin on 17/06/2017.
 */
public class Compte {

    private final String id;
    private double solde;
    private Transactions transactions;
    private DateGenerator dateGenerator;

    public Compte(String id, DateGenerator dateGenerator) {
        this.id = id;
        this.solde = 0;
        this.transactions = new Transactions();
        this.dateGenerator = dateGenerator;
    }

    public int nombreTransactions() {
        return transactions.nombreTransactions();
    }

    public double solde() {
        return this.solde;
    }

    public void effectuerTransaction (double somme, String id) {
        DefaultDateGenerator dateGenerator = new DefaultDateGenerator();
        String numeroTransaction = id;
        solde = DetailTransaction.determinerSolde(solde, somme);
        Transaction retrait = new Transaction(numeroTransaction, -somme, solde, dateGenerator.getDate());
        transactions.ajouterTransaction(numeroTransaction, retrait);
    }

    public List<String> listReleverDeCompteToString() {
        return transactions.listToStringTransactions();
    }

}
