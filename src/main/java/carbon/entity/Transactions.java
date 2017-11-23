package carbon.entity;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Created by tchauvin on 17/06/2017.
 */
public class Transactions {

    private Map<String, Transaction> transactions;

    public Transactions() {
        transactions = new HashMap<String, Transaction>(0);
    }

    public void ajouterTransaction(String id, Transaction transaction) {
        transactions.put(id, transaction);
    }

    public Transaction findTransactionById (String id) {
        return transactions.get(id);
    }

    public int nombreTransactions() {
        return transactions.size();
    }

    public List<String> listToStringTransactions() {
        List<Transaction> listTransaction = new ArrayList<Transaction>(transactions.values());
        Collections.sort(listTransaction, Transaction.comparator);
        List<String> listRetour = new ArrayList<String>(listTransaction.size());
        for(Transaction transaction : listTransaction) {
            listRetour.add(transaction.toString());
        }
        return listRetour;
    }

}
