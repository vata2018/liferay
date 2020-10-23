import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Checkout {

	public static void main(String[] args) {

		try {
			File fromFile = new File("inputfiles/" + args[0]);
			BufferedReader in = new BufferedReader(new FileReader(fromFile));

			Receipt receipt = new Receipt();
			String line = in.readLine();

			while (line != null) {
				receipt.addItem(line);
				line = in.readLine();
			}

			System.out.println(Format.formatReceipt(receipt));
			in.close();


		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

