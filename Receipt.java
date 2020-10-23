import java.util.*;

public class Receipt {

	private List<Merchandise> basket;

	public Receipt() {
		basket = new ArrayList<Merchandise>();
	}

	public void addItem(String line) {
		basket.add(parseLine(line));
	}

	public List<Merchandise> getItems() {
		return new ArrayList<Merchandise>(basket);
	}

	public double getTaxes() {
		double totalTaxes = 0;
		for (int i = 0; i < basket.size(); i++) {
			totalTaxes += basket.get(i).getTaxes();
		}
		return totalTaxes;
	}

	public double getTotal() {
		double totalPrice = 0;
		for (int i = 0; i < basket.size(); i++) {
			totalPrice += basket.get(i).getPrice();
		}
		return totalPrice;
	}

	public static Merchandise parseLine(String line) {

		String item = line.substring(line.indexOf(" "), line.indexOf(" at ")).replace(" imported", "").trim();
		int quantity = Integer.parseInt(line.substring(0, line.indexOf(" ")));
		double price = Double.parseDouble(line.substring(line.indexOf("at ")+3, line.length()));
		boolean isImported = line.indexOf("imported") >= 0;
		return new Merchandise(item, quantity, price, isImported);
	}

}