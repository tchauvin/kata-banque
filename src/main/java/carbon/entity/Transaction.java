package carbon.entity;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/*
 * Created by tchauvin on 23/11/2017.
 */
public class Transaction {

    private final String id;
    private Date dateTransaction;
    private TypeOperation typeOperation;
    private DetailTransaction detailTransaction;

    public enum TypeOperation {
        DEPOT, RETRAIT
    }

    public Transaction(String idCreated, double amountTransaction, double balance, Date date) {
        id = idCreated;
        dateTransaction = date;
        detailTransaction = new DetailTransaction(amountTransaction, balance);
        typeOperation = TypeOperation.DEPOT;
        if(amountTransaction < 0) typeOperation = TypeOperation.RETRAIT;
    }

    public static Comparator<Transaction> comparator = new Comparator<Transaction>() {
        public int compare(Transaction p1, Transaction p2) {
            return p1.dateTransaction.compareTo(p2.dateTransaction);
        }
    };

    public String toString() {
        String idStr = StringUtils.leftPad(id, 20);
        String detailTransactionStr = detailTransaction.toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateTransactionStr = StringUtils.leftPad(dateFormat.format(dateTransaction), 20);

        StringBuilder vTransactionStr = new StringBuilder();
        vTransactionStr.append("|");
        vTransactionStr.append(idStr);
        vTransactionStr.append("|");
        vTransactionStr.append(dateTransactionStr);
        vTransactionStr.append("|");
        vTransactionStr.append(StringUtils.leftPad(typeOperation.name(), 10));
        vTransactionStr.append(detailTransactionStr);

        return vTransactionStr.toString();
    }

}
