package MultiThreadedChanges;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {

	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String message;

	public ServerThread(Socket s) {
		socket = s;
	}

	public void run() {
		// 3. get Input and Output streams
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sendMessage("Connection successful");
		// 4. The two parts communicate via the input and output streams
		do {
			try {
				sendMessage("Please the phrase you wish to echo or the word FINISHED to exit");

				message = (String) in.readObject();

				sendMessage(message);
			} catch (ClassNotFoundException | IOException classnot) {
				System.err.println("Data received in unknown format");
			}
		} while (!message.equals("FINISHED"));
	}

	public void sendMessage(String msg) {
		try {
			out.writeObject(msg);
			out.flush();
			System.out.println("server>" + msg);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

}
