package carbon;

import carbon.DateUtil.TestDateGenerator;
import carbon.entity.Compte;
import carbon.entity.Comptes;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/*
 * Unit test for simple App.
 */
public class AppTestComptes {

    @Test
    public void testCreationComptes()
    {
        Comptes comptes = new Comptes();
        assertEquals(0, comptes.nombreCompte());
    }

    @Test
    public void testAjouterCompte()
    {
        Comptes comptes = new Comptes();
        assertEquals(0, comptes.nombreCompte());

        Date date = new Date();
        TestDateGenerator dateGenerator = new TestDateGenerator(date);
        String numeroCompte = RandomStringUtils.random(10, true, true);
        Compte compteOne = new Compte(numeroCompte, dateGenerator);

        comptes.ajouterCompte(numeroCompte, compteOne);
        assertEquals(1, comptes.nombreCompte());
    }

    @Test
    public void testSupprimerCompte()
    {
        Comptes comptes = new Comptes();
        assertEquals(0, comptes.nombreCompte());

        Date date = new Date();
        TestDateGenerator dateGenerator = new TestDateGenerator(date);
        String numeroCompte = RandomStringUtils.random(10, true, true);
        Compte compteOne = new Compte(numeroCompte, dateGenerator);

        comptes.ajouterCompte(numeroCompte, compteOne);
        assertEquals(1, comptes.nombreCompte());

        comptes.supprimerCompte(numeroCompte);
        assertEquals(0, comptes.nombreCompte());
    }

    @Test
    public void testGetCompteById()
    {
        Comptes comptes = new Comptes();
        assertEquals(0, comptes.nombreCompte());

        Date date = new Date();
        TestDateGenerator dateGenerator = new TestDateGenerator(date);
        String numeroCompte = RandomStringUtils.random(10, true, true);
        Compte compteOne = new Compte(numeroCompte, dateGenerator);

        comptes.ajouterCompte(numeroCompte, compteOne);
        assertEquals(1, comptes.nombreCompte());

        Compte compteRecuperer = comptes.findCompteById(numeroCompte);
        assertNotNull(compteRecuperer);
    }

}
