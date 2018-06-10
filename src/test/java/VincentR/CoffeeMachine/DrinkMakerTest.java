package VincentR.CoffeeMachine;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DrinkMakerTest extends TestCase{
	public DrinkMakerTest(String testName) {
		super(testName);
	}
	
	public static Test suite() {
        return new TestSuite(DrinkMakerTest.class);
    }
	
    public void testReceiveOrder() {
    	Drink dr = DrinkMaker.ReceiveOrder("H:1:0", 0.5);
    	assertEquals("chocolate", dr.getType());
    	assertEquals(1, dr.getSugar());
    	assertEquals(true, dr.isStick());
    }
    
    public void testNotEnoughMoney() {
    	Drink dr = DrinkMaker.ReceiveOrder("C:2:0", 0.5);
    	assertEquals(null, dr);
    }
    
    public void testTooMuchMoney() {
    	Drink dr = DrinkMaker.ReceiveOrder("C:2:0", 0.8);
    	assertEquals("coffee", dr.getType());
    	assertEquals(2, dr.getSugar());
    	assertEquals(true, dr.isStick());
    }
    
    public void testStartCommand() {
    	String choice = "Coffee", answer = "";
    	if (choice.toLowerCase().equals("chocolate"))
            answer += "H";
        else if (choice.toLowerCase().equals("information"))
        	answer += "M";
        else
            answer += choice.toUpperCase().charAt(0);
        assertEquals("C", answer);
    }
    
    public void testBuyOrangeJuice() {
    	Drink dr = new Drink("O", 0);
    	assertEquals("orange juice", dr.getType());
    	assertEquals(0, dr.getSugar());
    	assertEquals(false, dr.isStick());
    }
    
    public void testAddSugar() {
    	String command = "T";
    	int choice = 1;
    	if (choice==0) {
        	command += "::";
        } else {
        	command += ":"+ choice + ":0";
        }
    	assertEquals("T:1:0", command);
    }

    public void testCreateExtraHotCoffee() {
    	String command = "Ch";
    	int sugar = 1;
    	Drink dr = new Drink(command, sugar);
    	assertEquals("coffee", dr.getType());
    	assertEquals(true, dr.isExtraHot());
    }
}
