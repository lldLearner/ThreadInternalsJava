package ThreadPoolExecutor;

public class SendMailThread implements Runnable {

	private Customer customer;

	public SendMailThread(Customer customer) {
		// TODO Auto-generated constructor stub
		this.customer = customer;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("HI + " + customer.getName());
	}

}
