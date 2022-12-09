package BankSync;
public class BankExample {

	private int balance;

	public BankExample(int initialBal) {
		balance = initialBal;
	}

	public synchronized void setBalance(int newBalance) {
		balance = newBalance;
	}

	public synchronized int getBalance() {
		return balance;
	}

	public synchronized void addPenny() {
		System.out.println("In add a penny");
		balance = balance + 1;

		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished add a penny");
	}
}
