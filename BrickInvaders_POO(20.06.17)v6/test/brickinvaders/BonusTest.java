/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickinvaders;

import iut.Objet;
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
public class BonusTest {
    
    public BonusTest() {
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
     * Test of getJeu method, of class Bonus.
     */
    @Test
    public void testGetJeu() {
        System.out.println("getJeu");
        BrickInvaders jeu = new BrickInvaders();
        Bonus instance = new Bonus(jeu,"bonus",0,0,100);
        BrickInvaders expResult = jeu;
        BrickInvaders result = instance.getJeu();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDurabilite method, of class Bonus.
     */
    @Test
    public void testGetDurabilite() {
        System.out.println("getDurabilite");
        Bonus instance = new Bonus(new BrickInvaders(), "bonus", 0,0, 200);
        int expResult = 200;
        int result = instance.getDurabilite();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDurabilite method, of class Bonus.
     */
    @Test
    public void testSetDurabilite() {
        System.out.println("setDurabilite");
        int durabilite = 75;
        Bonus instance = new Bonus (new BrickInvaders(),"bonus",0,0,200);
        instance.setDurabilite(durabilite);
        int expResult = 75;
        int result = instance.getDurabilite();
        assertEquals(expResult, result);
    }

    /**
     * Test of evoluer method, of class Bonus.
     */
    @Test
    public void testEvoluer() {
        System.out.println("evoluer");
        long l = 0L;
        Bonus instance = new Bonus(new BrickInvaders(),"bonus",0,0,200);
        double expResult = instance.posDroite()-2;
        instance.evoluer(l);
        double result = instance.posDroite();
        assertEquals(expResult, result, 0.01);
    }
    
}
