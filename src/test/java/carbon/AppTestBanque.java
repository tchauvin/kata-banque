package carbon;

import carbon.entity.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/*
 * Unit test for simple App.
 */
public class AppTestBanque {

    @Test
    public void testCreationBanque()
    {
        Banque banque = new Banque("SG");
        assertEquals(banque.nombreComptes(), 0);
    }

    @Test
    public void testOuvertureCompte()
    {
        Banque banque = new Banque("SG");
        String idCompte = banque.ouvrirCompte();
        assertNotNull(idCompte);
    }

    @Test
    public void testSuppressionCompte()
    {
        Banque banque = new Banque("SG");
        String idCompte = banque.ouvrirCompte();
        int nbCompteBefore = banque.nombreComptes();
        banque.supprimerCompte(idCompte);
        int nbCompteAfter = banque.nombreComptes();
        assertEquals(nbCompteBefore-1, nbCompteAfter);
        Compte compteSupp = banque.findCompteById(idCompte);
        assertNull(compteSupp);
    }

    @Test
    public void testNombreComptes()
    {
        Banque banque = new Banque("SG");
        String idCompte = banque.ouvrirCompte();
        assertNotNull(idCompte);
        assertEquals(1, banque.nombreComptes());
    }

    @Test
    public void testFindCompteById()
    {
        Banque banque = new Banque("SG");
        String idCompte = banque.ouvrirCompte();
        assertNotNull(idCompte);
        assertNotNull(banque.findCompteById(idCompte));
    }

}
