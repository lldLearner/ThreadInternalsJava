package ThreadSynchronization;

public class BankAccount {

	private int amount;
	
	public BankAccount(int amount) {
		// TODO Auto-generated constructor stub
		this.amount = amount;
	}
	
	public void depositMoney(int amount) {
		// TODO Auto-generated method stub
		this.amount = this.amount + amount;
		System.out.println(this.amount + " has been present in yourr bank account after depsot of " + amount);
	}
	
	public void withdrawMoney(int amount) {
		// TODO Auto-generated method stub

		this.amount = this.amount - amount;
		System.out.println(this.amount + " has been left in yourr bank account after withdrawal of " + amount);
	}
	
	public static void main(String[] args) {
		BankAccount kartikAccount = new BankAccount(5000);
		BankAccount kaivalyaBankAccount = new BankAccount(500000);
		Thread atmThread = new Thread(() -> {
			kartikAccount.withdrawMoney(2000);
		});
		
		Thread googlePayThread = new Thread(() -> {
			kartikAccount.depositMoney(5000);
		});
		/*
		 * Output should be 3000 left after withdrawal
		 * 8000 left after deposit
		 * 
		 * Got the output in one scenario
		 * 3000 has been left in yourr bank account after withdrawal of 2000
		 * 3000 has been present in yourr bank account after depsot of 5000
		 * 
		 * Clear cut need of synchronization here as amount for kartik account is being accessed by both the threads simultaneously
		 */
		atmThread.start();
		googlePayThread.start();
	}
}
