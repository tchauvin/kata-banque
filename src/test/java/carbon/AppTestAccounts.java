package carbon;

import carbon.DateUtil.TestDateGenerator;
import carbon.entity.Account;
import carbon.entity.Accounts;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/*
 * Unit test for simple App.
 */
public class AppTestAccounts {

    @Test
    public void testCreationComptes()
    {
        Accounts accounts = new Accounts();
        assertEquals(0, accounts.numberOfAccounts());
    }

    @Test
    public void testAjouterCompte()
    {
        Accounts accounts = new Accounts();
        assertEquals(0, accounts.numberOfAccounts());

        Date date = new Date();
        TestDateGenerator dateGenerator = new TestDateGenerator(date);
        String numAccount = RandomStringUtils.random(10, true, true);
        Account accountOne = new Account(numAccount, dateGenerator);

        accounts.addAccount(numAccount, accountOne);
        assertEquals(1, accounts.numberOfAccounts());
    }

    @Test
    public void testSupprimerCompte()
    {
        Accounts accounts = new Accounts();
        assertEquals(0, accounts.numberOfAccounts());

        Date date = new Date();
        TestDateGenerator dateGenerator = new TestDateGenerator(date);
        String numeroCompte = RandomStringUtils.random(10, true, true);
        Account accountOne = new Account(numeroCompte, dateGenerator);

        accounts.addAccount(numeroCompte, accountOne);
        assertEquals(1, accounts.numberOfAccounts());

        accounts.removeAccount(numeroCompte);
        assertEquals(0, accounts.numberOfAccounts());
    }

    @Test
    public void testGetCompteById()
    {
        Accounts accounts = new Accounts();
        assertEquals(0, accounts.numberOfAccounts());

        Date date = new Date();
        TestDateGenerator dateGenerator = new TestDateGenerator(date);
        String numeroCompte = RandomStringUtils.random(10, true, true);
        Account accountOne = new Account(numeroCompte, dateGenerator);

        accounts.addAccount(numeroCompte, accountOne);
        assertEquals(1, accounts.numberOfAccounts());

        Account recoveredAccount = accounts.findAccountById(numeroCompte);
        assertNotNull(recoveredAccount);
    }

}
