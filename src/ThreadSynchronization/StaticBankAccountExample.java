package ThreadSynchronization;

public class StaticBankAccountExample {

	private static int amount = 10000;

	// For instance methods, it is object level lock that is acquired.
	// 1. T1 calling deposit money for kartik
	// 2. T2 calling withdraw money for kartik
	// T1 will take lock on kartik and until it releases the lock T2 will be in
	// stepping state, then T2 will acquire lock and withdraw will be run and vice
	// versa is also possible
	public static synchronized void depositMoney(int am) {
		// TODO Auto-generated method stub
		amount = amount + am;
		System.out.println(amount+ " has been present in yourr bank account after depsot of " + am);
	}

	public static synchronized void withdrawMoney(int am) {
		// TODO Auto-generated method stub

        amount = amount - am;
		System.out.println(amount + " has been left in yourr bank account after withdrawal of " + am);
	}

	public static void main(String[] args) {

		Thread atmThread = new Thread(() -> {
			StaticBankAccountExample.withdrawMoney(2000);
		}, "kaivalya account");

		Thread googlePayThread = new Thread(() -> {
			StaticBankAccountExample.depositMoney(5000);
		}, "kartik account");


		/*
		 * Output can be 3000 left after withdrawal 8000 left after deposit
		 * 
		 * 10000 left after deposit 8000 left after withdrawal
		 * 
		 * Got the output in one scenario 3000 has been left in yourr bank account after
		 * withdrawal of 2000 3000 has been present in yourr bank account after depsot
		 * of 5000
		 * 
		 * Clear cut need of synchronization here as amount for kartik account is being
		 * accessed by both the threads simultaneously
		 */
		atmThread.start();
		googlePayThread.start();
	}
}
