package VincentR.CoffeeMachine;

public enum Price {
	T(0.4),
	H(0.5),
	C(0.6),
	O(0.6),
	Th(0.4),
	Hh(0.5),
	Ch(0.6);
	
	private double price;
	
	private Price(double price_p) {
		this.price = price_p;
	}
	
	public double getPrice() {
		return price;
	}
}