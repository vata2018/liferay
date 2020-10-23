import java.util.*;

public class Checkout {

  public static void main(String[] args) {
    Receipt receipt = new Receipt();
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    
    while (line.length() > 0) {
      receipt.addItem(line);
      line = sc.nextLine();
    }

    System.out.println(Format.formatReceipt(receipt));
    sc.close();
  }

}
