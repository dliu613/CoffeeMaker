public class CoffeeMaker {

	/** Inventory in the coffee maker */
	private int coffee;
	private int milk;
	private int chocolate;

	/**
	 * Creates a coffee maker object with empty containers.
	 */
	public CoffeeMaker() {
		this.coffee = 0;
		this.milk = 0;
		this.chocolate = 0;
	}

	/**
	 * Returns the current number of chocolate units in 
	 * the coffee maker.
	 * @return int
	 */
	public int getChocolate() {
		return chocolate;
	}

	/**
	 * Returns the current number of coffee units in
	 * the coffee maker.
	 * @return int
	 */
	public int getCoffee() {
		return coffee;
	}

	/**
	 * Returns the current number of milk units in
	 * the coffee maker.
	 * @return int
	 */
	public int getMilk() {
		return milk;
	}

	/**
	 * Returns a string describing the current contents 
	 * of the inventory.
	 * @return String
	 */
	public String checkIngredients() {
		StringBuffer buf = new StringBuffer();
		buf.append("Coffee: ");
		buf.append(getCoffee());
		buf.append("\n");
		buf.append("Milk: ");
		buf.append(getMilk());
		buf.append("\n");
		buf.append("Chocolate: ");
		buf.append(getChocolate());
		buf.append("\n");
		return buf.toString();
	}

	/**
	 * Cleanup coffee maker emptying all its content
	 */
	public void cleanup() {
		
		this.coffee = 0;
		this.milk = 0;
		this.chocolate = 0;
	}

	/**
	 * Adds ingredients to the coffee maker
	 * @param amtCoffee
	 * @param amtMilk
	 * @param amtChocolate
	 * @return boolean
	 */
	public void addIngredients(int amtCoffee, int amtMilk, int amtChocolate) throws Exception {

		if (amtCoffee < 0 || amtMilk < 0 || amtChocolate < 0) {
			throw new Exception("Units must all be a positive integers");
		}

		this.coffee += amtCoffee;
		this.milk += amtMilk;
		this.chocolate += amtChocolate;
	}

	/**
	 * Make an espresso and return the change, or
	 * the user's money if the espresso cannot be made.
	 * An espresso uses one unit of coffee and costs one pound.
	 * @param amtPaid
	 * @return int
	 */
	public int makeEspresso(int amtPaid) {

		if (amtPaid >= 1 && this.getCoffee() >= 1) {
			this.coffee--;
			return amtPaid - 1;	
		}
		// not enough money or not enough coffee
		return amtPaid;
	}

	/**
	 * Make a latte and return the change, or
	 * the user's money if the latte cannot be made.
	 * A latte uses two units of coffee and one unit of milk.
	 * @param amtPaid
	 * @return int
	 */
	public int makeLatte(int amtPaid) {

		if (amtPaid >= 2 && this.getCoffee() >= 2 && this.getMilk() >= 1) {
			this.coffee--;
			this.milk = this.milk-2;
			return amtPaid - 2;
		}
		// not enough money or not enough coffee
		return amtPaid;
	}    
}
