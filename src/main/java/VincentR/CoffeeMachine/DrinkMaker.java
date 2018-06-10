package VincentR.CoffeeMachine;

import java.util.Scanner;

public class DrinkMaker {
	public static Drink ReceiveOrder(String command, double money) {
		String[] message = command.split(":");
		
    	if (message[0].equals('M')) {
    		System.out.println("information: " + message);
        	return null;
    	} else {
        	String drinkType, drinkName;
        	int drinkSugar = 0;
    		switch (command.charAt(0)) {
    		case 'T':
    			drinkType = "T";
    			drinkName = "tea";
    			break;
    		case 'H':
    			drinkType = "H";
    			drinkName = "chocolate";
    			break;
    		case 'O':
    			drinkType = "O";
    			drinkName = "orange juice";
    			break;
    		default:
    			drinkType = "C";
    			drinkName = "coffee";
    		}
    		if (message[0].length()>1)
    			drinkType += "h";
    		if(message.length>1) {
    			drinkSugar = Integer.parseInt(message[1]);
    		} else {
    			drinkSugar = 0;
    		}
    		double price = Price.valueOf(""+drinkType).getPrice(), moneyChange;
    		if (money<price) {
    			moneyChange = (10 * price - 10 *money)/10;
    			System.out.println("You need to put more money to order this product.\n"
    					+ "Add " + moneyChange + "e.");
    			return null;
    		} else if (money>price) {
    			moneyChange = (10 * money - 10 *price)/10;		// Using only this formula: "money - price"		returned 0.1999996 instead of 2, so I used the written formula to solve the problem.
    			System.out.println("You have put " + money + "e. Only "+ price + "e were needed, here is your change : " + moneyChange + "e");
    		}
        	ReportManagement.WriteOnFile(drinkName);
        	return new Drink(drinkType, drinkSugar);
    	}
    }
    
    public static String StartCommand() {
    	Scanner sc = new Scanner(System.in);
        String choice, answer = "";
        System.out.println("Hello, which drink do you want ?\n" +
                "-Coffee\n" +
                "-Tea\n" +
                "-Chocolate\n" +
                "-orange juice\n" +
               "-Information");
        while (true) {
            choice =  sc.nextLine();
            if (choice.toLowerCase().equals("coffee") || choice.toLowerCase().equals("tea") || choice.toLowerCase().equals("chocolate") || choice.toLowerCase().equals("information") || choice.toLowerCase().equals("orange juice"))
                break;
            else
                System.out.println("Unknown answer, please choose one of these 3 choices...");
        }
        if (choice.toLowerCase().equals("chocolate"))
            answer += "H";
        else if (choice.toLowerCase().equals("information"))
        	answer += "M";
        else
            answer += choice.toUpperCase().charAt(0);
        return answer;
    }
    
    public static String AddExtraHot() {
    	Scanner sc = new Scanner(System.in);
    	String answer;
    	System.out.println("Do you want your drink to be extrahot ?");
    	while (true) {
    		answer = sc.nextLine();
    		if (answer.equals("Yes") || answer.equals("yes") || answer.equals("Y") || answer.equals("y")) {
    			return "h";
    		} else if (answer.equals("No") || answer.equals("no") || answer.equals("N") || answer.equals("n")) {
    			return null;
    		}
    	}
    }
    
    public static String AddSugar(String commandType){
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        System.out.println("Would you like some sugar with it ?\n(0/1/2)");
        while (choice!=0 && choice!=1 && choice!=2) {
            choice = sc.nextInt();
            sc.nextLine();
            if (choice!=0 && choice!=1 && choice!=2)
                System.out.println("Choose one of the given answers.");
        }
        if (choice==0) {
        	commandType = "::";
        } else {
        	commandType = ":"+ choice + ":0";
        }
        sc.close();
        return commandType;
    }
}