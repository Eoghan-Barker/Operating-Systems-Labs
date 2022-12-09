package BoundedBuffer;

public class Producer extends Thread {

	public Buffer b;

	public Producer(Buffer shared) {
		b = shared;
	}

	public void run() {
		int num = 0;
		while (true) {
			b.put(num);
			System.out.println("Put value " + num);
			num++;

		}
	}
}
