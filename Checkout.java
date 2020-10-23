import java.util.*;

public class Checkout {

  public static void main(String[] args) {
    Receipt receipt = new Receipt();
    Scanner sc = new Scanner(System.in);
    String line;
    
    while (sc.hasNextLine()) {
      line = sc.nextLine();
      receipt.addItem(line);
    }

    System.out.println(Format.formatReceipt(receipt));
    sc.close();
  }

}
