package BoundedBuffer;

public class Consume extends Thread {

	public Buffer b;

	public Consume(Buffer shared) {
		b = shared;
	}

	public void run() {
		int num = 0;
		while (true) {
			System.out.println("I am going to read");

			num = b.get();
			System.out.println("I have read " + num);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
