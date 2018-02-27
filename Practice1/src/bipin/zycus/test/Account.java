package bipin.zycus.test;

public class Account {
	final private int n;
	private String studentId;
	private int[] accounts;
	private double totalInterest, lowestInterest, highestInterest, avgInterest;
	int noInterestAccounts;

	// public Account() {
	// // constructor
	// }
	public Account(String studentId) {
		this.studentId = studentId;
		int max = 0;
		for (int i = 0; i < studentId.length(); i++) {
			Character ch = studentId.charAt(i);
			int ch_v = Character.getNumericValue(ch);

			if (Character.isDigit(ch) && ch_v > max) {
				max = ch_v;
			}
		}
		n = max;
	}

	public double interest(int amount) {
		double interest = 0.0;
		if (amount > 1000 && amount <= 5000)
			interest = 0.025;
		else if (amount > 5000 && amount <= 10000)
			interest = 0.05;
		else if (amount > 10000)
			interest = 0.08;
		return interest * amount;
	}

	public int[] getAccounts() {
		return accounts;
	}

	public void setAccounts(int[] accounts) {
		this.accounts = accounts;
	}

	public double getTotalInterest() {
		return totalInterest;
	}

	public void setTotalInterest(double totalInterest) {
		this.totalInterest = totalInterest;
	}

	public double getLowestInterest() {
		return lowestInterest;
	}

	public void setLowestInterest(double lowestInterest) {
		this.lowestInterest = lowestInterest;
	}

	public double getHighestInterest() {
		return highestInterest;
	}

	public void setHighestInterest(double highestInterest) {
		this.highestInterest = highestInterest;
	}

	public double getAvgInterest() {
		return avgInterest;
	}

	public void setAvgInterest(double avgInterest) {
		this.avgInterest = avgInterest;
	}

	public int getNoInterestAccounts() {
		return noInterestAccounts;
	}

	public void setNoInterestAccounts(int noInterestAccounts) {
		this.noInterestAccounts = noInterestAccounts;
	}

	public String getStudentId() {
		return studentId;
	}

	public int getN() {
		return n;
	}

	public int interestType(double interest) {
		return noInterestAccounts;
	}

	public void calculateInterests(double data[]) {
		totalInterest = 0.0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == 0.0)
				noInterestAccounts++;
			if (data[i] < lowestInterest)
				lowestInterest = data[i];
			if (data[i] > highestInterest)
				highestInterest = data[i];
			totalInterest = totalInterest + data[i];
		}
		if (data.length > 0)
			avgInterest = totalInterest / (data.length);
	}

}
