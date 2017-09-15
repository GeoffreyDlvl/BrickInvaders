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
public class BriqueTest {
    
    public BriqueTest() {
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
     * Test of getJeu method, of class Brique.
     */
    @Test
    public void testGetJeu() {
        System.out.println("getJeu");
        BrickInvaders jeu = new BrickInvaders();
        Brique instance = new Brique(jeu,"brique",0,0,100);
        BrickInvaders expResult = jeu;
        BrickInvaders result = instance.getJeu();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDurabilite method, of class Brique.
     */
    @Test
    public void testGetDurabilite() {
        System.out.println("getDurabilite");
        BrickInvaders jeu = new BrickInvaders();
        Brique instance = new Brique(jeu,"brique",0,0,100);
        int expResult = 100;
        int result = instance.getDurabilite();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDurabilite method, of class Brique.
     */
    @Test
    public void testSetDurabilite() {
        System.out.println("setDurabilite");
        int durabilite = 76;
        BrickInvaders jeu = new BrickInvaders();
        Brique instance = new Brique(jeu,"brique",0,0,100);
        instance.setDurabilite(durabilite);
        int expResult = durabilite;
        int result = instance.getDurabilite();
        assertEquals(expResult, result);
    }

    /**
     * Test of degats method, of class Brique.
     */
    @Test
    public void testDegats() {
        System.out.println("degats");
        int pointsDegat = 10;        
        BrickInvaders jeu = new BrickInvaders();
        jeu.creeObjets();
        Brique instance = new Brique(jeu,"brique",0,0,100);
        int expResult = instance.getDurabilite()-10;
        instance.degats(pointsDegat);
        int result = instance.getDurabilite();
        assertEquals(expResult, result);
    }

    /**
     * Test of effetCollision method, of class Brique.
     */
    @Test
    public void testEffetCollision() {
        System.out.println("effetCollision");
        BrickInvaders jeu = new BrickInvaders();
        jeu.creeObjets();
        Brique instance = new Brique(jeu,"brique",0,0,100);
        Tir tir = new Tir(jeu,"tir",0,0);
        int durabiliteBase = instance.getDurabilite();
        boolean expResult = true;
        instance.effetCollision(tir);
        boolean result = instance.getDurabilite() < durabiliteBase;
        assertEquals(expResult, result);
    }

    /**
     * Test of evoluer method, of class Brique.
     */
    @Test
    public void testEvoluer() {
        System.out.println("evoluer");
        long l = 0L;
        BrickInvaders jeu = new BrickInvaders();
        jeu.creeObjets();
        Brique instance = new Brique(jeu,"brique",0,0,100);
        jeu.getJoueur().getScore().addToScore(501);
        int expResult = instance.posDroite()-3;
        instance.evoluer(l);
        int result = instance.posDroite();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVelocite method, of class Brique.
     */
    @Test
    public void testGetVelocite() {
        System.out.println("getVelocite");
        BrickInvaders jeu = new BrickInvaders();
        Brique instance = new Brique(jeu,"brique",0,0,100);
        instance.setVelocite(2.1);
        double expResult = 2.1;
        double result = instance.getVelocite();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of setVelocite method, of class Brique.
     */
    @Test
    public void testSetVelocite() {
        System.out.println("setVelocite");
        double velocite = 0.8;
        BrickInvaders jeu = new BrickInvaders();
        Brique instance = new Brique(jeu,"brique",0,0,100);
        instance.setVelocite(velocite);
        double expResult = 0.8;
        double result = instance.getVelocite();
        assertEquals(expResult, result, 0.1);
    }
    
}
