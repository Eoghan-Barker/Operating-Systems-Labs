package ConsoleUnordered;
public class ConsoleTest {

	public static void main(String[] args) {
	   MyConsole SharedObj = new MyConsole();	
       DisplayThread T1 = new DisplayThread(1,SharedObj, "My");
       DisplayThread T2 = new DisplayThread(1,SharedObj, "Name");
       DisplayThread T3 = new DisplayThread(1,SharedObj, "Is");
       DisplayThread T4 = new DisplayThread(1,SharedObj, "Martin");
		
		T1.start();
		T2.start();
		T3.start();
		T4.start();
	}
}

