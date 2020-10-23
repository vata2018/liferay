import java.util.*;

public class Receipt {

	// list with all items in each input
	private List<Merchandise> basket;

	public Receipt() {
		basket = new ArrayList<Merchandise>();
	}

	// adds items into basket
	public void addItem(String line) {
		basket.add(parseLine(line));
	}

	// returns the items in basket
	public List<Merchandise> getItems() {
		return new ArrayList<Merchandise>(basket);
	}

	// total taxes of items in basket
	public double getTaxes() {
		double totalTaxes = 0;
		for (int i = 0; i < basket.size(); i++) {
			totalTaxes += basket.get(i).getTaxes();
		}
		return totalTaxes;
	}

	// total of basket
	public double getTotal() {
		double totalPrice = 0;
		for (int i = 0; i < basket.size(); i++) {
			totalPrice += basket.get(i).getPrice();
		}
		return totalPrice;
	}
	
	// function that parses lines in an input
	public static Merchandise parseLine(String line) {

		String item = line.substring(line.indexOf(" "), line.indexOf(" at ")).replace(" imported", "").trim();
		int quantity = Integer.parseInt(line.substring(0, line.indexOf(" ")));
		double price = Double.parseDouble(line.substring(line.indexOf("at ")+3, line.length()));
		boolean isImported = line.indexOf("imported") >= 0;
		return new Merchandise(item, quantity, price, isImported);
	}

}
