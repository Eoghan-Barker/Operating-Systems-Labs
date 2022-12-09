package BoundedBuffer;

public class Buffer {

	int array[] = new int[10];
	int in = 0;
	int out = 0;

	public synchronized void put(int value) {
		System.out.println("The value of in and out is " + in + " " + out);
		/* do nothing -- no free buffers */
		while ((in + 1) % 10 == out) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		in = (in + 1) % 10;
		array[in] = value;

		System.out.println("The value of in and out is " + in + " " + out);

		notifyAll();
	}

	public synchronized int get() {
		System.out.println("In & Out " + in + "" + out);

		// Don't let out overtake in so it won't read an empty buffer
		while (in == out) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // do nothing --
		}

		out = (out + 1) % 10;

		int item = array[out];

		System.out.println("Item " + item);

		notifyAll();
		return item;
	}

}
