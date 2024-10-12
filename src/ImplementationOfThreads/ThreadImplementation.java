package ImplementationOfThreads;

public class ThreadImplementation implements Runnable {

	//Internally Thread Class Inherits Runnable Interface
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + "enters the run method");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new ThreadImplementation()); //calling thread constructor with runnable object as argument
		Thread thread2 = new Thread(new ThreadImplementation());
		thread1.setName("Yo Thread");//ANother way to set thread names
		thread2.setName("Yay Thread");
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
	}
}
