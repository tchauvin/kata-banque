package carbon.entity;

import carbon.DateUtil.DateGenerator;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by tchauvin on 23/11/2017.
 */
public class Transaction {

    private final String id;
    private Date dateTransaction;
    private DetailTransaction detailTransaction;

    public Transaction(String idCreated, double montantTransaction, double solde, Date date) {
        id = idCreated;
        dateTransaction = date;
        detailTransaction = new DetailTransaction(montantTransaction, solde);
    }

    public static Comparator<Transaction> comparator = new Comparator<Transaction>() {
        public int compare(Transaction p1, Transaction p2) {
            return p1.dateTransaction.compareTo(p2.dateTransaction);
        }
    };

    public String toString() {
        String idStr = StringUtils.leftPad(id, 20);
        String mouvementStr = detailTransaction.toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateTransactionStr = StringUtils.leftPad(dateFormat.format(dateTransaction), 20);
        return "|" + idStr + "|" + dateTransactionStr + "|" + mouvementStr;
    }

}
