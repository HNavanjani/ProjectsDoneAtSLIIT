package WordTest;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UITest {

    public UITest() {
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
     * Test of calCtc method, of class UI.
     */
    @Test
    public void testCalCtc() {
        System.out.println("Test of calCtc method");
        UI instance = new UI();
        ArrayList<Integer> expCtc = new ArrayList<Integer>(Arrays.asList(0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0));
        ArrayList<Integer> CtcResult = instance.calCtc();
        assertEquals(expCtc, CtcResult);
    }

    /**
     * Test of calcCnc method, of class UI.
     */
    @Test
    public void testCalcCnc() {
        System.out.println("Test of calcCnc method");
        UI instance = new UI();
        ArrayList<Integer> expCnc = new ArrayList<Integer>(Arrays.asList(0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0));
        ArrayList<Integer> CncResult = instance.calcCnc();
        assertEquals(expCnc, CncResult);
    }
    
      /**
     * Test of calcCs method, of class UI.
     */
   @Test
   public void testCalcCs() {
       System.out.println("Test of calcCs method");
       UI instance = new UI();
       ArrayList<Integer> expCs = new ArrayList<Integer>(Arrays.asList(1, 4, 8, 1, 0, 0, 0, 9, 0, 0, 4, 10, 13, 0, 0, 0));
       ArrayList<Integer> CsResult = instance.calculateCs();
       assertEquals(expCs, CsResult);
   }
}
