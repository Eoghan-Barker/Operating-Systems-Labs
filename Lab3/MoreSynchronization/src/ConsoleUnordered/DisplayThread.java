package ConsoleUnordered;

class DisplayThread extends Thread{
	
	private int threadId;
	private MyConsole share;
	private String myString;
	
	public DisplayThread(int t, MyConsole s, String myS)
	{
		threadId = t;
		share = s;
		myString = myS;
	}
	
	public void run()
	{
		for(int i=0;i<20;i++)
		{
			share.display(myString);
			
		}
	}

}