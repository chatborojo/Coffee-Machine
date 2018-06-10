package VincentR.CoffeeMachine;

public class Drink {
    protected String type;
    protected boolean extraHot = false;
    protected int sugar;
    protected boolean stick;

    public Drink(String type_p, int sugar_p) {
        switch (type_p.charAt(0)) {
            case 'T':
                this.type = "tea";
                break;
            case 'H':
                this.type = "chocolate";
                break;
            case 'O':
            	this.type = "orange juice";
            	break;
            default:
                this.type = "coffee";
        }
        if (type_p.length()>1 && (type_p.equals("Th") || type_p.equals("Hh") || type_p.equals("Ch")))
        	this.extraHot = true;
        this.sugar = sugar_p;
        this.stick = (sugar_p > 0) ? true : false;
    }
    
    public String getType() {
        return type;
    }
    public int getSugar() {
        return sugar;
    }
    public boolean isStick() {
        return stick;
    }
    public boolean isExtraHot() {
		return extraHot;
	}


	public void setType(String type) {
        switch (type.charAt(0)) {
            case 'T':
                this.type = "tea";
                break;
            case 'H':
                this.type = "chocolate";
                break;
            case 'O':
            	this.type = "orange juice";
            	break;
            default:
                this.type = "coffee";
        }
    }
    public void setSugar(int sugar) {
        this.sugar = sugar;
    }
    public void setStick(boolean stick) {
        this.stick = stick;
    }
	public void setExtraHot(boolean extraHot) {
		this.extraHot = extraHot;
	}
}