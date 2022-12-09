package BankSync;
public class BankTest {
	public static void main(String[] args) {
		// Create the shared object bank account
		BankExample account = new BankExample(0);
		Thread[] thread = new Thread[100];
		ThreadGroup g1 = new ThreadGroup("group");
		boolean done = false;

		// Create 100 BankThreads
		for (int i = 0; i < 100; i++) {
			thread[i] = new Thread(g1, new BankThread(account, i), "t");
			thread[i].start();
		}

		// Finish all the threads before continuing
		while (!done)
			if (g1.activeCount() == 0)
				done = true;

		// The final balance should be 100 if the threads have been synchronized
		System.out.println("The output balance of the account is" + account.getBalance());

	}

}
