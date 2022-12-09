package ConsoleOrdered;
public class DisplayThread extends Thread{
	
	private OutputConsole shared;
	private int state;
	private String msg;
	
	public DisplayThread(OutputConsole o, int i, String m)
	{
		shared = o;
		state = i;
		msg = m;
	}
	
	public void run()
	{
		for(int i=0; i<20; i++)
		{
			/*if(state == 1)
				shared.displayS1(msg);
			else if(state ==2)
				shared.displayS2(msg);
			else if(state ==3)
				shared.displayS3(msg);
			else if(state ==4)
				shared.displayS4(msg);
				*/
			
			shared.display(msg, state);
		}
	}

}
