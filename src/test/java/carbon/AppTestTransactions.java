package carbon;

import carbon.entity.Transaction;
import carbon.entity.Transactions;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple App.
 */
public class AppTestTransactions {

    @Test
    public void testCreationTransaction()
    {
        Transactions transactions = new Transactions();

        assertEquals(0, transactions.nombreTransactions());
    }

    @Test
    public void testAjouterTransaction()
    {
        DateTime dateTime = new DateTime(2017, 11, 23, 19, 37, 50);
        String numeroTransaction = RandomStringUtils.random(10, true, true);
        Transaction transaction = new Transaction(numeroTransaction, 200.0, 1000, dateTime.toDate());

        Transactions transactions = new Transactions();
        transactions.ajouterTransaction(numeroTransaction, transaction);

        assertEquals(1, transactions.nombreTransactions());
    }

    @Test
    public void testGetTransactionById()
    {
        DateTime dateTime = new DateTime(2017, 11, 23, 19, 37, 50);
        String numeroTransaction = RandomStringUtils.random(10, true, true);
        Transaction transaction = new Transaction(numeroTransaction, 200.0, 1000, dateTime.toDate());

        Transactions transactions = new Transactions();
        transactions.ajouterTransaction(numeroTransaction, transaction);

        Transaction transactionRecuperer = transactions.findTransactionById(numeroTransaction);
        assertNotNull(transactionRecuperer);
    }


}