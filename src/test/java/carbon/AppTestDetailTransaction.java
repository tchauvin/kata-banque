package carbon;

import carbon.DateUtil.TestDateGenerator;
import carbon.entity.Compte;
import carbon.entity.DetailTransaction;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTestDetailTransaction {

    @Test
    public void testCreationCompteWithToString()
    {
        DetailTransaction detail = new DetailTransaction(200.0, 0);
        assertEquals(detail.toString(), "     200.0|       0.0|");
    }

    @Test
    public void testDeterminerSolde()
    {
        double newSolde = DetailTransaction.determinerSolde(200.0, 50.0);
        assertEquals(250.0, newSolde, 0);
    }

}
