package carbon;

import carbon.DateUtil.TestDateGenerator;
import carbon.entity.Account;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/*
 * Unit test for simple App.
 */
public class AppTestAccount {

    @Test
    public void testCreationCompte()
    {
        Date date = new Date();
        TestDateGenerator dateGenerator = new TestDateGenerator(date);
        String numAccount = RandomStringUtils.random(10, true, true);

        Account account = new Account(numAccount, dateGenerator);
        assertEquals(account.balance(), 0, 0);
        assertEquals(account.numberOfTransactions(), 0);
    }

    @Test
    public void testEffectuerTransaction()
    {
        Date date = new Date();
        TestDateGenerator dateGenerator = new TestDateGenerator(date);
        String numAccount = RandomStringUtils.random(10, true, true);
        String numeroTransaction = RandomStringUtils.random(10, true, true);

        Account account = new Account(numAccount, dateGenerator);
        account.performTransaction(200, numeroTransaction);

        assertEquals(account.balance(), 200, 0);
        assertEquals(account.numberOfTransactions(), 1);

        numeroTransaction = RandomStringUtils.random(10, true, true);
        account.performTransaction(-45.5, numeroTransaction);
        assertEquals(account.balance(), 154.5, 0);
        assertEquals(account.numberOfTransactions(), 2);
    }


}
