package assignments;

import java.util.Scanner;

class balance extends RuntimeException
{
	balance(String s)
	{
		super(s);
	}
}

class amnt extends RuntimeException
{
	amnt(String s)
	{
		super(s);
	}
}

class pin extends RuntimeException
{
	pin(String s)
	{
		super(s);
	}
}

class choice extends RuntimeException
{
	choice(String s)
	{
		super(s);
	}
}
public class homewrk3 {
	private int password;
	private int bal = 0;
	homewrk3(int s)
	{
		password = s;
	}
homewrk3(int s, int x)
	{
		password = s;
		bal = x;
	}
	//public void OpenAcc() throws IncorrectPIN
	{
		
	}
	public void deposit(int x)
	{
		bal += x;
		System.out.println("Your available balance is :" + bal);
	}
	public void withdraw(int x)
	{
		if(x%100 != 0)
		{
			throw new amnt("Try a multiple of hundred. Please try again");
		}
		if(x < 100)
		{
			throw new amnt("Minimum withdrawl is Rs. 100. Please try again.");
		}
		if(bal > x)
		{
			bal -= x;
			System.out.println("Your available balance is :" + bal);
		}
		else 
			throw new balance("Insufficient Balance, available Bal :"+bal+". Try a lesser amount.");
	}
	public void CheckBal()
	{
		//OpenAcc();
		System.out.println("Your available balance is :" + bal);
	}
	public static void main(String args[])
	{
		homewrk3 a = new homewrk3(2017,10000);
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter your PIN");
		int s = inp.nextInt();
		if(s != a.password)
		{
			throw new pin("Incorrect PIN. Try again");
		}
		System.out.print("Enter your choice:\n1.Deposit\n2.Withdraw\n3.Check Balance\n");
		int x,ch = inp.nextInt();
		switch(ch)
		{
		case 1:
			System.out.print("Enter the amount.\n");
			x = inp.nextInt();
			a.deposit(x);
			System.out.println("Transaction Successfull.");
			break;
		case 2:
			System.out.print("Enter the amount.\n");
			x = inp.nextInt();
			a.withdraw(x);
			System.out.println("Transaction Successfull.");
			break;
		case 3:
			a.CheckBal();
			break;
		default:
			throw new choice("Please choose from the given options.");
		}
	}
}