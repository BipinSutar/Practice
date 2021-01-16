package com.bipin.practice.inheritance;

public class ParentAccount {
	public AccountDet1 accountDet1 = null;
	public String parentName;

	public static void main(String[] args) {
		try {

			ParentAccount parentAccount = new Assembler().getParentAccount();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class AccountDet1 {
	AccountDet2 accountDet2;

}

class AccountDet2 {
	public String name;
	public String id;
}

class Assembler {
	public ParentAccount getParentAccount() {
		AccountDet1 accountDet1 = new AccountDet1();

		AccountDet2 accountDet2 = new AccountDet2();
		accountDet2.name = "Bipin";
		accountDet2.id = "100";
		accountDet1.accountDet2 = accountDet2;
		ParentAccount account = new ParentAccount();
		account.accountDet1 = accountDet1;
		return account;
	}
}
