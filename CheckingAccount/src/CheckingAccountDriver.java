import java.util.Scanner;
public class CheckingAccountDriver {

	public static void main(String[] args)
	{
		CheckingAccount checking;
		Scanner input = new Scanner(System.in);
		
		boolean done = false;
		boolean hasAccount = false;
		
		int choice = 0;
		int account = -1;
		
		System.out.println("WELCOME TO THE ATM.");
		
		while(!(done))
		{
			System.out.println("\nWhat would you like to do?\n\t1. Create a new account\n\t 2. Deposit\n\t3. Withdraw\n\t4. Quit\n\n");
			choice = input.nextInt();
			
			switch(choice)
			{
				case 1:
					try{
						if(hasAccount)
						{
							throw new IllegalArgumentException("You already have an account.");
						}
						else
						{
							int acctNumber = 0;
							double balance = 0.0;
							
							System.out.print("Please enter a new account number: ");
							acctNumber = input.nextInt();
							System.out.print("Please enter your initial balance: ");
							balance = input.nextDouble();
							
							account = acctNumber;
							
							checking = new CheckingAccount(balance, acctNumber);
						}
					}
					catch(IllegalArgumentException e)
					{
						System.out.println("Error: " + e.getMessage());
					}
					break;
				case 2:
					try{
						double amountDeposited = 0.0;
						int accountNumber = 0;
						
						System.out.print("Please enter your account number: ");
						accountNumber = input.nextInt();
						System.out.print("Please enter the amount you'd like to deposit: ");
						amountDeposited = input.nextDouble();
						if(accountNumber != account || accountNumber < 0)
						{
							throw new IllegalArgumentException("Invalid account number.");
						}
						else if(amountDeposited < 0)
						{
							throw new IllegalArgumentException("Negative amount deposited.");
						}
						else
						{
							if(hasAccount)
							{
								checking.deposit(amountDeposited);
							}
						}
					}
					catch(IllegalArgumentException e)
					{
						System.out.println("Error: " + e.getMessage());
					}
					break;
				case 3:
					try{
						withdraw();
					}
					catch(IllegalArgumentException e)
					{
						System.out.println("\nAccount overdrawn!");
					}
					break;
				case 4:
					done = true;
					break;
			}
		}
	}
	
}
