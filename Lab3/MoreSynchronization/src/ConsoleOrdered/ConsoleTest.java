package ConsoleOrdered;
public class ConsoleTest {
	public static void main(String[] args) {
		OutputConsole outputScreen = new OutputConsole();

		DisplayThread t1 = new DisplayThread(outputScreen, 1, "My");
		DisplayThread t2 = new DisplayThread(outputScreen, 2, "Name");
		DisplayThread t3 = new DisplayThread(outputScreen, 3, "Is");
		DisplayThread t4 = new DisplayThread(outputScreen, 4, "Martin");

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}