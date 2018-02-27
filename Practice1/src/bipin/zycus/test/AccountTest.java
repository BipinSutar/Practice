package bipin.zycus.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AccountTest {

	public static void main(String[] args) {
		// local variable declarations go here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String id = null;
		NullPointerException ne = new NullPointerException();
		// display welcome message
		System.out.println("Welcome to Bank Interest Calculator..");
		System.out.println("Please enter your Student Id: ");
		for (int i = 0; i < 1; i++) {
			try {
				id = br.readLine();
				if (id == null || id.equals("") || id.length() == 0)
					throw ne;
			} catch (NullPointerException | IOException e) {
				System.out.println("Please enter proper Sudent id");
				i--;
			}
		}
		Account acc = new Account(id);
		// System.out.println("N is " + acc.getN());
		int accounts[] = new int[acc.getN()];
		double interests[] = new double[acc.getN()];

		// loop to input amount, calculate and display interest, calculate summary
		// values

		for (int i = 0; i < acc.getN(); i++) {
			try {
				System.out.println("Enter the amount for account number " + (i + 1) + ": ");
				accounts[i] = Integer.parseInt(br.readLine());
				interests[i] = acc.interest(accounts[i]);
				System.out.println("The interest for account number " + (i + 1) + " is $" + interests[i]);
			} catch (NumberFormatException | IOException e) {
				System.out.println("Please enter proper amount");
				i--;
			}

		}
		// generate and display summary
		acc.setAccounts(accounts);
		acc.calculateInterests(interests);

		System.out.println(
				"------------------------------------------------Interest Details---------------------------------------------------");
		System.out.println("Total Interest: $" + acc.getTotalInterest());
		System.out.println("Lowest Interest: $" + acc.getLowestInterest());
		System.out.println("Highest Interest: $" + acc.getHighestInterest());
		System.out.println("Average Interest: $" + acc.getAvgInterest());
		System.out.println("Number of accounts with no interest: " + acc.getNoInterestAccounts());
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		// display exit message
		System.out.println("Thank you for using this service. We are happy to help you.");
	}

}
