package carbon.entity;

import carbon.DateUtil.DateGenerator;
import carbon.DateUtil.DefaultDateGenerator;
import org.apache.commons.lang3.RandomStringUtils;

/*
 * Created by tchauvin on 23/11/2017
 */
public class Bank {

    private final String nom;
    private Accounts accounts;

    public Bank(String nom) {
        this.nom = nom;
        this.accounts = new Accounts();
    }

    public String openAccount() {
        String numAccount = RandomStringUtils.random(8, true, true);
        DateGenerator dateGenerator = new DefaultDateGenerator();
        Account newAccount = new Account(numAccount, dateGenerator);
        this.accounts.addAccount(numAccount, newAccount);
        return numAccount;
    }

    public int numberOfAccounts() {
        return accounts.numberOfAccounts();
    }

    public void removeAccountById(String id) {
        accounts.removeAccount(id);
    }

    public Account findAccountById(String id) {
        return accounts.findAccountById(id);
    }

    public boolean depositOrWithdrawal(String idRetrievedAccount, String idCreditedAccount, double amount) {

        if(amount == 0.0) {
            return false;
        }
        Account debitedAccount = accounts.findAccountById(idRetrievedAccount);
        if(debitedAccount == null) {
            return false;
        }

        Account creditedAccount = accounts.findAccountById(idCreditedAccount);
        if(creditedAccount == null) {
            return false;
        }

        String numTransaction = RandomStringUtils.random(10, true, true);
        debitedAccount.performTransaction(-amount, numTransaction);
        creditedAccount.performTransaction(amount, numTransaction);

        return true;
    }
}
