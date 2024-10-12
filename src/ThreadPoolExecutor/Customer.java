package ThreadPoolExecutor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Customer {

	private String name;

	public Customer(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {
		Customer c1 = new Customer("Kartik Sapra");
		Customer c2 = new Customer("Kaivalya Apte");
		Customer c3 = new Customer("Megha Arora");
		Customer c4 = new Customer("Karan Sapra");
		Customer c5 = new Customer("Neeraj Sapra");
		Customer c6 = new Customer("Savita Sapra");
		Customer c7 = new Customer("Ram Gupta");
		Customer c8 = new Customer("Khushi Gupta");

		List<Customer> list = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8);
		// Threads have a drawback they get destroyed after run is executed hence not
		// reusable, but Threadpoll has reusable threads in this 3 threads will be
		// reused for each customer
		ExecutorService ex = Executors.newFixedThreadPool(3);
		for (int i = 0; i < list.size(); i++) {
			ex.execute(new SendMailThread(list.get(i)));
		}
	}
}
