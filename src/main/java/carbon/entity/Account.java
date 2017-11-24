package carbon.entity;

import carbon.DateUtil.DateGenerator;
import carbon.DateUtil.DefaultDateGenerator;

import java.util.List;

/*
 * Created by tchauvin on 23/11/2017.
 */
public class Account {

    private final String id;
    private double balance;
    private Transactions transactions;
    private DateGenerator dateGenerator;

    public Account(String id, DateGenerator dateGenerator) {
        this.id = id;
        this.balance = 0;
        this.transactions = new Transactions();
        this.dateGenerator = dateGenerator;
    }

    public int numberOfTransactions() {
        return transactions.numberOfTransactions();
    }

    public double balance() {
        return this.balance;
    }

    public void performTransaction(double amount, String id) {
        DefaultDateGenerator dateGenerator = new DefaultDateGenerator();
        balance = DetailTransaction.determinedBalance(balance, amount);
        Transaction depositOrWithdrawal = new Transaction(id, -amount, balance, dateGenerator.getDate());
        transactions.addTransaction(id, depositOrWithdrawal);
    }

    public List<String> listStatementPrintStr() {
        return transactions.listToStringTransactions();
    }

}
