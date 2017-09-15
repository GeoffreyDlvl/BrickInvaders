/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickinvaders;

import java.awt.Graphics;
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
public class BrickInvadersTest {
    
    public BrickInvadersTest() {
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
     * Test of aGagne method, of class BrickInvaders.
     */
    @Test
    public void testAGagne() {
        System.out.println("aGagne");
        BrickInvaders instance = new BrickInvaders();
        boolean expResult = false;
        boolean result = instance.aGagne();
        assertEquals(expResult, result);
    }

    /**
     * Test of aPerdu method, of class BrickInvaders.
     */
    @Test
    public void testAPerdu() {
        System.out.println("aPerdu");
        BrickInvaders instance = new BrickInvaders();
        boolean expResult = false;
        boolean result = instance.aPerdu();
        assertEquals(expResult, result);
    }
    
}
