package VincentR.CoffeeMachine;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DrinkTest extends TestCase {
	public DrinkTest(String testName) {
		super(testName);
	}
	
	public static Test suite() {
        return new TestSuite(DrinkTest.class);
    }
  
	public void testDrink() {
		Drink dr = new Drink("T", 2);
		assertEquals("tea", dr.getType());
		assertEquals(2, dr.getSugar());
		assertEquals(true, dr.isStick());
	}
	
    public void testGetType() {
        Drink dr = new Drink("H", 0);
        assertEquals(dr.getType(), "chocolate");
    }

    public void testGetSugar() {
        Drink dr = new Drink("C", 0);
        assertEquals(0, dr.getSugar());
    }
    
    public void testIsStick() {
        Drink dr = new Drink("T", 2);
        assertEquals(true, dr.isStick());
    }

    public void testSetType() {
        Drink dr = new Drink("T", 2);
        dr.setType("C");
        assertEquals("coffee", dr.getType());
    }

    public void testSetSugar() {
        Drink dr = new Drink("C", 1);
        dr.setSugar(2);
        assertEquals(2, dr.getSugar());
    }

    public void testSetStick() {
        Drink dr = new Drink("H", 2);
        dr.setStick(false);
        assertEquals(false, dr.isStick());
    }
}