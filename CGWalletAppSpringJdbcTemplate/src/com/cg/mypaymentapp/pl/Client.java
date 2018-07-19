package com.cg.mypaymentapp.pl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.text.html.HTMLDocument.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transactions;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;

public class Client 
{		
		WalletService walletService;
		

		public Client() 
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("projectBeans.xml");
			
			walletService=(WalletService)context.getBean("walletService");
		}

		public void menu()
		{
			Scanner console = new Scanner( System.in );

			System.out.println("1) Create Account"); 
			System.out.println("2) Show Balance");
			System.out.println("3) Fund Transfer"); 
			System.out.println("4) Deposit Money");
			System.out.println("5) Withdraw Money");
			System.out.println("6) MiniStatement");
			System.out.println("0) Exit");
			System.out.print("\nEnter Your Choice: ");
			int choice = console.nextInt();
			
			operation( choice );

		}
		public void operation( int choice )
		{
			switch ( choice ) 
			{
			case 1: createAccount(); break;
			case 2: showBalance(); break;
			case 3: fundTransfer(); break;
			case 4: depositMoney(); break;
			case 5: withdrawMoney(); break;
			case 6: miniStatement(); break;
			case 0: exitApplication(); break;
			default:
				break;
			}
		}
		
		private void miniStatement() 
		{

			Scanner console = new Scanner( System.in );

			System.out.print("\n\nEnter Your mobileno: ");
			String mobileno = console.nextLine();
			ArrayList<Transactions> transactions= walletService.miniStatement(mobileno);
			java.util.Iterator<Transactions> it =transactions.iterator();
			
			while (it.hasNext()) 
			{
				System.out.println(it.next());
			}
			System.out.println(transactions);
		}

		private void createAccount() 
		{
			//Taking details from the User

			Scanner console = new Scanner( System.in );

			System.out.print("\n\nEnter Your Name: ");
			String accountName = console.nextLine();

			System.out.print("Enter Phone Number: ");
			String phoneNumber = console.next();

			System.out.print("Enter Amount: ");
			BigDecimal amount= console.nextBigDecimal();
			
			try
			{
				Customer customer = walletService.createAccount(accountName, phoneNumber, amount);
				System.out.println("\nYour account created successfully with account number :"+ customer.getMobileNo());
			}
			catch(InvalidInputException e)
			{
				System.out.println("Something went wrong.Reason:"+e.getMessage());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		private void showBalance() 
		{
			Scanner console = new Scanner( System.in );
			
			System.out.print("\nEnter the mobile number: ");
			String mobilenumber = console.next();
			
			try
			{
				Customer customer = walletService.showBalance(mobilenumber);
				BigDecimal balance = customer.getWallet().getBalance();
				System.out.println("Your bank balance is:"+balance);
			} 
			catch(InvalidInputException e)
			{
				System.out.println("Something went wrong.Reason:"+e.getMessage());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		private void fundTransfer()
		{
			Scanner console = new Scanner( System.in );
		
			System.out.print("\n\nEnter Source account number : ");
			String sphoneNumber = console.next();

			System.out.print("Enter destination account Number: ");
			String dphoneNumber = console.next();

			System.out.print("Enter Amount: ");
			BigDecimal amount= console.nextBigDecimal();
			try
			{
				walletService.fundTransfer(sphoneNumber, dphoneNumber, amount);
			} 
			catch(InvalidInputException e)
			{
				System.out.println("Something went wrong.Reason:"+e.getMessage());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		private void depositMoney()
		{
			Scanner console = new Scanner( System.in );
			
			System.out.print("\n\nEnter account number : ");
			String phoneNumber = console.next();
			System.out.print("Enter Amount: ");
			BigDecimal amount= console.nextBigDecimal();
			
			try 
			{
				walletService.depositAmount(phoneNumber, amount);
				System.out.println("successfully deposited\n");
			} 
			catch(InvalidInputException e)
			{
				System.out.println("Something went wrong.Reason:"+e.getMessage());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		private void withdrawMoney()
		{
			Scanner console = new Scanner( System.in );
			
			System.out.print("\n\nEnter account number : ");
			String phoneNumber = console.next();
			System.out.print("Enter Amount: ");
			BigDecimal amount= console.nextBigDecimal();
			
			try 
			{
				walletService.withdrawAmount(phoneNumber, amount);
				System.out.println("successfully withdrawed");
			} 
			catch(InvalidInputException e)
			{
				System.out.println("Something went wrong.Reason:"+e.getMessage());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		private void exitApplication()
		{
			System.out.println("Thank you for using wallet application");
			System.exit( 0 );
		}
	


		public static void main(String[] args) 
		{
			
			Client client = new Client();
			while(true)
				client.menu();
			
	
		}
}

