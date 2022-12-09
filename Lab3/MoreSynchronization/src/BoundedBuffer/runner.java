package BoundedBuffer;
public class runner {

	public static void main(String[] args) {
		Buffer sharedRes = new Buffer();
		Producer P = new Producer(sharedRes);
		Consume C= new Consume(sharedRes);
		
		P.start();
		C.start();
	
	}

}
