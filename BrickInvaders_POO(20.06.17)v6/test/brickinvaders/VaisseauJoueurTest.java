/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickinvaders;

import iut.Objet;
import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Geoffrey
 */
public class VaisseauJoueurTest {
    private BrickInvaders instanceJeu = new BrickInvaders();
    
    public VaisseauJoueurTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setBonusJoueur method, of class VaisseauJoueur.
     */
    @Test
    public void testSetBonusJoueur() {
        System.out.println("setBonusJoueur");
        VaisseauJoueur instance = new VaisseauJoueur(instanceJeu);
        instance.setBonusJoueur(true);
        boolean expResult = true;
        boolean result = instance.getBonusJoueur();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBonusJoueur method, of class VaisseauJoueur.
     */
    @Test
    public void testGetBonusJoueur() {
        System.out.println("getBonusJoueur");
        VaisseauJoueur instance = new VaisseauJoueur(instanceJeu);
        instance.setBonusJoueur(true);
        boolean expResult = true;
        boolean result = instance.getBonusJoueur();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTimerBonus method, of class VaisseauJoueur.
     */
    @Test
    public void testSetTimerBonus() {
        System.out.println("setTimerBonus");
        double moment = 12.45;
        VaisseauJoueur instance = new VaisseauJoueur(instanceJeu);
        instance.setTimerBonus(moment);
        double expResult = 12.45;
        double result = instance.getTimerBonus();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of deplacer method, of class VaisseauJoueur.
     */
    @Test
    public void testDeplacer() {
        System.out.println("deplacer");
        int keyCode = KeyEvent.VK_UP;
        VaisseauJoueur instance = new VaisseauJoueur(instanceJeu);
        double expResult = instance.posBasse()-6;
        instance.deplacer(keyCode);
        double result = instance.posBasse();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of getScore method, of class VaisseauJoueur.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        VaisseauJoueur instance = new VaisseauJoueur(instanceJeu);
        instance.getScore().addToScore(47);
        int expResult = 47;
        int result = instance.getScore().getScore();
        assertEquals(expResult, result);
    }
    
}
