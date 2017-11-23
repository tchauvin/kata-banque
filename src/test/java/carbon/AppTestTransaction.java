package carbon;

import carbon.entity.Transaction;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple App.
 */
public class AppTestTransaction {

    @Test
    public void testCreationTransaction()
    {
        String numeroTransaction = RandomStringUtils.random(10, true, true);
        Transaction transaction = new Transaction(numeroTransaction, 200.0, 1000, new Date());

        assertNotNull(transaction);
    }

    @Test
    public void testTransactionToString()
    {
        DateTime dateTime = new DateTime(2017, 11, 23, 19, 37, 50);
        String numeroTransaction = RandomStringUtils.random(10, true, true);
        Transaction transaction = new Transaction(numeroTransaction, 200.0, 1000, dateTime.toDate());

        assertEquals(transaction.toString(), "|          "+numeroTransaction+"| 23/11/2017 19:37:50|     DEPOT|     200.0|    1000.0|");
    }


}
