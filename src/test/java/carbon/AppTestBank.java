package carbon;

import carbon.entity.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/*
 * Unit test for simple App.
 */
public class AppTestBank {

    @Test
    public void testCreationBanque()
    {
        Bank bank = new Bank("SG");
        assertEquals(bank.numberOfAccounts(), 0);
    }

    @Test
    public void testOuvertureCompte()
    {
        Bank bank = new Bank("SG");
        String idCompte = bank.openAccount();
        assertNotNull(idCompte);
    }

    @Test
    public void testSuppressionCompte()
    {
        Bank bank = new Bank("SG");
        String idCompte = bank.openAccount();
        int nbCompteBefore = bank.numberOfAccounts();
        bank.removeAccountById(idCompte);
        int nbCompteAfter = bank.numberOfAccounts();
        assertEquals(nbCompteBefore-1, nbCompteAfter);
        Account deletedAccount = bank.findAccountById(idCompte);
        assertNull(deletedAccount);
    }

    @Test
    public void testNombreComptes()
    {
        Bank bank = new Bank("SG");
        String idCompte = bank.openAccount();
        assertNotNull(idCompte);
        assertEquals(1, bank.numberOfAccounts());
    }

    @Test
    public void testFindCompteById()
    {
        Bank bank = new Bank("SG");
        String idCompte = bank.openAccount();
        assertNotNull(idCompte);
        assertNotNull(bank.findAccountById(idCompte));
    }

}
