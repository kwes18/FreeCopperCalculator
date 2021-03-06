import java.util.Scanner;

/**
 * 
 * @author Kayla Weselowski
 *
 */

public class MainDriver {

	public static void main(String[] args) {
		// list variables and types
		double cu, cp;
		int units;
		boolean valid = false; // set valid to false
		// instantiates new bloodlevel obj
		BloodLevel bl = new BloodLevel();
		// creates scanner obj takes keyboard input from user
		Scanner s = new Scanner(System.in);
		// use do-while loop for input error handling
		do {
			System.out.println("Please enter your serum copper value: ");
			// check if user input is double, set to cu var if true
			if (s.hasNextDouble()) {
				cu = s.nextDouble();
				if (cu >= 0) {
					bl.setCuValue(cu); // store cu value in mem
					valid = true;
				} else // message for invalid input from static method
					invalid("The value cannot be negative.");
			} else
				invalid("The value must be a number.");
			s.nextLine(); // advance scanner
		} while (valid == false); // loop while not valid

		valid = false;
		do {
			System.out.println("Please enter your ceruloplasmin value: ");
			if (s.hasNextDouble()) {
				cp = s.nextDouble();
				if (cp >= 0) {
					bl.setCpValue(cp);
					valid = true;
				} else
					invalid("The value cannot be negative.");
			} else
				invalid("The value must be a number.");
			s.nextLine();
		} while (valid == false);

		valid = false;

		do {
			System.out.println(
					"Please enter either 1 if the units of measurement are mcg/dl and mg/dl \nor 2 if the units are umol/L and mg/L.");
			if (s.hasNextInt()) { // checks for type int
				units = s.nextInt();
				if (units == 1 || units == 2) { // checks for specific values
					bl.freeCopper(bl.getCuValue(), bl.getCpValue(), units); // call method to calc free copper
					System.out.println(bl.displayResults(units)); // call method to show entered values
					valid = true;
				} else
					invalid("The value entered must be 1 or 2.");
			} else
				invalid("The value must be a number.");
			s.nextLine();
		} while (valid == false);

		System.out.println(bl.displayEvaluation()); // display evaluation of results
		s.close();

	}

	public static void invalid(String add) {
		System.out.println("Invalid input. " + add);
	}

}
