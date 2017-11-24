package carbon.entity;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by tchauvin on 23/11/2017.
 */
public class Accounts {

    private Map<String, Account> accounts;

    public Accounts() {
        accounts = new HashMap<String, Account>(0);
    }

    public void addAccount(String id, Account account) {
        accounts.put(id, account);
    }

    public void removeAccount(String compteId) {
        accounts.remove(compteId);
    }

    public int numberOfAccounts() {
        return accounts.size();
    }

    public Account findAccountById(String id) {
        return accounts.get(id);
    }
}
