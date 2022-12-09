package ConsoleUnordered;

class MyConsole {	
	public synchronized void display(String s)
	{
		System.out.println(s);
	}
}