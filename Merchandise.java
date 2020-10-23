import java.util.*;

public class Merchandise {

	private String item;
	private double price;
	private int quantity;
	private double taxes;
	private boolean IsExempt;
	private boolean IsImported;

	private static final double SALES_TAX = 0.10;
	private static final double IMPORTED_TAX = 0.05;
	private static final String[] EXEMPT_ITEMS = {"book", "pill", "chocolate"};


	public Merchandise(String item, int quantity, double price, boolean IsImported) {
		this.item = item;
		this.quantity = quantity;
		this.taxes = calculateTax(price);
		this.IsImported = IsImported;
		this.price = (price * quantity) + taxes;
	}

	// Return the name of the item
	public String getItem() {
		return item;
	}

	// Return the quantity of item(s)
	public int getQuantity() {
		return quantity;
	}

	// Return the total taxes on an item
	public double getTaxes() {
		return taxes;
	}

	// Return the basic price of the item
	public double getPrice() {
		return price;
	}

	// Helper function that rounds a number up
	private static double roundUp(double num) {
		return Math.round(num * 20.0) / 20.0;
	}

	// Returns a boolean whether or not an item is exempt
	public boolean IsExempt() {
		return IsExempt;
	}

	// Returns a boolean whether or not an item is imported
	public boolean isImported() {
		return IsImported;
	}

	// Checks if the line with the name of item contains one of the exempt items
	private static boolean isItemExempt(String line) {
		for(int i = 0; i < EXEMPT_ITEMS.length; i++) {
			if (line.contains(EXEMPT_ITEMS[i])) {
				return true;
			} 
		}
		return false;
	}

	// Calculates the tax of an item at a certain price
	public double calculateTax(double price) {
		double totaltaxes = 0;
		if (!isItemExempt(item)) {
			totaltaxes += price * SALES_TAX;
		}
		if (IsImported) {
			totaltaxes += price * IMPORTED_TAX;
		}
		return roundUp(totaltaxes) * quantity;
	}

}



