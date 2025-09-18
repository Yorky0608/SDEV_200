import java.util.Scanner;

public class assignment_12_9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a binary number: ");
		String binary = input.nextLine();
		try {
			int decimal = bin2Dec(binary);
			System.out.println("Decimal equivalent: " + decimal);
		} catch (BinaryFormatException e) {
			System.out.println("Not a binary number");
		}
		input.close();
	}

	public static int bin2Dec(String binaryString) throws BinaryFormatException {
		for (char c : binaryString.toCharArray()) {
			if (c != '0' && c != '1') {
				throw new BinaryFormatException("Not a binary number");
			}
		}
		return Integer.parseInt(binaryString, 2);
	}
}

class BinaryFormatException extends NumberFormatException {
	public BinaryFormatException(String message) {
		super(message);
	}
}