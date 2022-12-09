package BankSync;
public class BankThread extends Thread{
	
	private BankExample account;
	private int no;
	public BankThread(BankExample sharedObj, int id)
	{
		account = sharedObj;
		no = id;
	}

	public void run()
	{
		System.out.println(no+"Called addBalance");
		account.addPenny();
		//System.out.println(no+"Finished addBalance");
		
	}
}
