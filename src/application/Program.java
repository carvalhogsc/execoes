package application;

import java.util.Locale;
import java.util.Scanner;

import models.entities.Account;
import models.exceptions.AccountException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner inpuData = new Scanner(System.in);
		
		
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int numberAccount = inpuData.nextInt();
			System.out.print("Holder: ");
			inpuData.nextLine();
			String holderAccount = inpuData.nextLine();
			System.out.print("Initial balance: ");
			double initialBalance = inpuData.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = inpuData.nextDouble();
			
			Account account = new Account(numberAccount, holderAccount, initialBalance, withdrawLimit);
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = inpuData.nextDouble();
			
		try {
			
			account.withdraw(amount);
			
			System.out.println("New balance: " + account.getBalance());
		}
		catch (AccountException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		finally {
			if(inpuData != null) {
				inpuData.close();
			}
		}
	}

}
