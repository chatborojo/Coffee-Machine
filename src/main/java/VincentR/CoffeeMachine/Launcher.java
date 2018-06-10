package VincentR.CoffeeMachine;

public class Launcher {
	public static void main(String[] args) {
		ReportManagement.CreateFile();		
    	String command = DrinkMaker.StartCommand();
    	if (!command.equals("M")) {
    		if (!command.equals("O"))
    			command += DrinkMaker.AddExtraHot();
    		command += DrinkMaker.AddSugar(command);
    		double money = 0.6;
    		Drink dr = DrinkMaker.ReceiveOrder(command, money);
    		if (!(dr==null)) {
            	System.out.println("Here is your " + ((dr.isExtraHot()) ? "extrahot " : "") + dr.getType() + ((dr.isStick()==true)? " with " + dr.getSugar() + " sugar." : " without sugar."));
    		}
    	} else {
    		System.out.println("Information about the drinks:\n"
    				+ "Coffee\t\t0,6e\n"
    				+ "Tea\t\t0,4e\n"
    				+ "Chocolate\t0,5e\n"
    				+ "Orange juice\t0,6e");
    	}
		ReportManagement.WriteOnFile("coffee");
		double total = ReportManagement.AmountSoldDrinks();
		System.out.println("Total amount of money earned: " + total + "€");
    }
}