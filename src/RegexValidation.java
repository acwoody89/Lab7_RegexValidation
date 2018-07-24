import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cont = "y";

		while (cont.equalsIgnoreCase("y")) {
			
			nameValidation(scan);

			phoneValidation(scan);

			emailValidation(scan);
			
			dateValidation(scan);
			
			System.out.println("Would you like to continue? (y/n)");
			cont = scan.nextLine();
		}
	}


	public static void nameValidation(Scanner scan) {
		boolean valid = false;
		String s = "";
		while (valid == false) {
			System.out.println("Please enter your name, First and last name.");
			System.out.println("EX) Alex Wood");
			s = scan.nextLine();
			// first and last name needs to be capitalized. Had to look to google for this one.
			if (Pattern.matches("\\b[A-Z][a-z]* [A-Z][a-z]*([A-Z])?\\b", s)) {
				System.out.println("Valid Name");
				valid = true;
			} else {
				System.out.println("Invalid Name");
			}
		}

	}

	public static void phoneValidation(Scanner scan) {
		boolean valid = false;
		String s = "";
		while (valid == false) {
			System.out.println("PhoneNumber...ex)###-###-####");
			s = scan.nextLine();
			// \\d means digits only, {3} is how many digits, \\s.- means special character '-'
			// that is for the area code.
			if (Pattern.matches("(\\d{3}[\\s.-])(\\d{3}[\\s.-])\\d{4}", s)) {
				System.out.println("Valid Number");
				valid = true;
			} else {
				System.out.println("Invalid Phone Number");
			}
		}
		// find() - attempts to locate the next subsequence of the input
		// that matches the pattern
	}
	
	public static void emailValidation(Scanner scan) {
		boolean valid = false;
		String s = "";
		while (valid == false) {
			System.out.println("Please enter your email address. Must be 5 to 30 Characters.");
			System.out.println("EX) AlexWood@gmail.com");
			s = scan.nextLine();
		//	[Alphabet & numerical range]{character range][special character '/'][Alphabet & numerical range]{character range][special character '/'][Alphabet & numerical range]{character range}
			if (Pattern.matches("[A-z0-9]{5,30}[\\s.@][A-z0-9]{5,10}[\\s..][A-z0-9]{2,3}$", s)) {
				System.out.println("Valid Name");
				valid = true;
			} else {
				System.out.println("Invalid email adress");
			}
		}

	}
	
	
	public static void dateValidation(Scanner scan) {
		boolean valid = false;
		String s = "";
		while (valid == false) {
			System.out.println("Please enter a date...EX) 11/11/2011");
			s = scan.nextLine();
			// [0-9] is the numbers allowed, {1,2} allows 1-2 digits, \\s./ expects a //'
			if (Pattern.matches("[0-9]{1,2}[\\s./][0-9]{1,2}[\\s./][0-9]{4,}$", s)) {
				System.out.println("Valid Date");
				valid = true;
			} else {
				System.out.println("Invalid Date");
			}
		}

	}

}
