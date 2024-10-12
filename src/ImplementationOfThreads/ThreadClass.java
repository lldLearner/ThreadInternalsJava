package ImplementationOfThreads;

public class ThreadClass extends Thread {

	public ThreadClass() {
		// TODO Auto-generated constructor stub
		super(); // will call empty Thread class constructor
	}

	public ThreadClass(String threadName) {
		super(threadName);// will call thread constructor to set custom thread name
	}

	// Override Thread Class Run to provide custom logic
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// Static Thread method to fetch current running thread and its name, Threads
		// are in running state
		System.out.println(Thread.currentThread().getName() + " enters the run method");
	}
	// Thread after executing run, comes into DEAD state

	public static void main(String[] args) throws InterruptedException {
		// Thread are in NEW state
		ThreadClass thread1 = new ThreadClass("Yo Thread");
		ThreadClass thread2 = new ThreadClass("Yay Thread");
		// Thread are in Runnable state i.e kept in runnable pool waiting for OS
		// scheduler to schedule
		thread1.start();// thread gets created/independant path of execution
		thread2.start();

		// Main thread needs to wait for completion of thread1 and thread2
		thread1.join();
		thread2.join();
		// DEAD state, Main thread will execute
		System.out.println(thread1.isAlive());
		System.out.println(thread2.isAlive());
	}
}
