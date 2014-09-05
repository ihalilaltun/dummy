/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cooper
 */
public class TailSelectedListenerTest {
    
    public TailSelectedListenerTest() {
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
     * Test of LogLines method, of class TailSelectedListener.
     */
    @Test
    public void testLogLines() {
        System.out.println("LogLines");
        String line = "";
        TailSelectedListener instance = new TailSelectedListener();
        String expResult = "";
        String result = instance.LogLines(line);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ListenerStatus method, of class TailSelectedListener.
     */
    @Test
    public void testListenerStatus() throws Exception {
        System.out.println("ListenerStatus");
        String agentNo = "";
        TailSelectedListener instance = new TailSelectedListener();
        String expResult = "";
        String result = instance.ListenerStatus(agentNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
