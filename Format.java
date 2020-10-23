import java.util.*;

public class Format {

  public static String formatReceipt(Receipt receipt) {
    String output = "";
    List<Merchandise> items = receipt.getItems();

    for (Merchandise item : items) {
    	String imported = "";
    	if (item.isImported()) {
    		imported = " imported";
    	}
    	int quantity = item.getQuantity();
    	String merch = item.getItem();
    	double price = item.getPrice();
    	output += String.format(
        "%d%s %s: %.2f\n",
        quantity, imported, merch, price);
    }
    
    output += String.format(
      "Sales Taxes: %.2f\nTotal: %.2f",
      receipt.getTaxes(),
      receipt.getTotal()
    );
    return output;
  }
}