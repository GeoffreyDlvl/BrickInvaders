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
public class ScoreTest {
    
    public ScoreTest() {
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
     * Test of testerCollision method, of class Score.
     */
    @Test
    public void testTesterCollision() {
        System.out.println("testerCollision");
        BrickInvaders jeu = new BrickInvaders();
        Objet objet = new Brique(jeu,"brique",0,0,100);
        Score instance = new Score(jeu,"0",0,0);
        boolean expResult = false;
        boolean result = instance.testerCollision(objet);
        assertEquals(expResult, result);
    }

    /**
     * Test of evoluer method, of class Score.
     */
    @Test
    public void testEvoluer() {
        System.out.println("evoluer");
        BrickInvaders jeu = new BrickInvaders();
        long l = 3000;
        Score instance = new Score(jeu,"0",0,0);
        instance.evoluer(l);
        int expResult = 1;
        int result = instance.getScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of addToScore method, of class Score.
     */
    @Test
    public void testAddToScore() {
        System.out.println("addToScore");
        int points = 12;
        Score instance = new Score(new BrickInvaders(),"0",0,0);
        instance.addToScore(points);
        int expResult = 12;
        int result = instance.getScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScore method, of class Score.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Score instance = new Score(new BrickInvaders(),"0",0,0);
        int expResult = 0;
        int result = instance.getScore();
        assertEquals(expResult, result);
    }
    
}
