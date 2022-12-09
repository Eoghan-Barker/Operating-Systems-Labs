package ConsoleOrdered;

public class OutputConsole {

	private int state=1;
	
	public synchronized void display(String msg, int Desiredstate)
	{
		while(state != Desiredstate)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			System.out.println(msg);
			state = state +1;
			
			if(state==5)
				state = 1;
			
			notifyAll();
		}
	// public synchronized void displayS1(String msg)
	// {
	// 	while(state!=1)
	// 	{
	// 		try {
	// 			wait();
	// 		} catch (InterruptedException e) {
	// 			e.printStackTrace();
	// 		}
	// 	}
		
	// 	System.out.println(msg);
	// 	state = 2;
	// 	notifyAll();
	// }
	// public synchronized void displayS2(String msg)
	// {
	// 	while(state!=2)
	// 	{
	// 		try {
	// 			wait();
	// 		} catch (InterruptedException e) {
	// 			e.printStackTrace();
	// 		}
	// 	}
		
	// 	System.out.println(msg);
	// 	state = 3;
	// 	notifyAll();
	// }
	// public synchronized void displayS3(String msg)
	// {
	// 	while(state!=3)
	// 	{
	// 		try {
	// 			wait();
	// 		} catch (InterruptedException e) {
	// 			e.printStackTrace();
	// 		}
	// 	}
		
	// 	System.out.println(msg);
	// 	state = 4;
	// 	notifyAll();
	// }
	// public synchronized void displayS4(String msg)
	// {
	// 	while(state!=4)
	// 	{
	// 		try {
	// 			wait();
	// 		} catch (InterruptedException e) {
	// 			e.printStackTrace();
	// 		}
	// 	}
		
	// 	System.out.println(msg);
	// 	state = 1;
	// 	notifyAll();
	// }
	
}
