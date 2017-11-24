package carbon.entity;

import org.apache.commons.lang3.StringUtils;

/*
 * Created by tchauvin on 23/11/2017.
 */
public class DetailTransaction {

    private double amount;
    private double balance;

    public DetailTransaction(double amountTransaction, double balanceAccount) {
        amount = amountTransaction;
        balance = balanceAccount;
    }

    public static double determinedBalance(double balanceAccount, double amountTransaction) {
        return balanceAccount + amountTransaction;
    }

    public String toString() {
        String amountStr = StringUtils.leftPad(Double.toString(amount), 10);
        String balanceStr = StringUtils.leftPad(Double.toString(balance), 10);
        return "|" + amountStr + "|" + balanceStr + "|";
    }
}
