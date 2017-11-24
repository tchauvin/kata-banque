package carbon;

import carbon.DateUtil.TestDateGenerator;
import carbon.entity.Compte;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/*
 * Unit test for simple App.
 */
public class AppTestCompte {

    @Test
    public void testCreationCompte()
    {
        Date date = new Date();
        TestDateGenerator dateGenerator = new TestDateGenerator(date);
        String numeroCompte = RandomStringUtils.random(10, true, true);

        Compte compte = new Compte(numeroCompte, dateGenerator);
        assertEquals(compte.solde(), 0, 0);
        assertEquals(compte.nombreTransactions(), 0);
    }

    @Test
    public void testEffectuerTransaction()
    {
        Date date = new Date();
        TestDateGenerator dateGenerator = new TestDateGenerator(date);
        String numeroCompte = RandomStringUtils.random(10, true, true);
        String numeroTransaction = RandomStringUtils.random(10, true, true);

        Compte compte = new Compte(numeroCompte, dateGenerator);
        compte.effectuerTransaction(200, numeroTransaction);

        assertEquals(compte.solde(), 200, 0);
        assertEquals(compte.nombreTransactions(), 1);

        numeroTransaction = RandomStringUtils.random(10, true, true);
        compte.effectuerTransaction(-45.5, numeroTransaction);
        assertEquals(compte.solde(), 154.5, 0);
        assertEquals(compte.nombreTransactions(), 2);
    }


}
