import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {

	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String message;
	private String message2;
	private Listing lib;

	public ServerThread(Socket s, Listing l) {
		socket = s;
		lib = l;
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

		// Conversation from the server to the client
		try {
			do {
				sendMessage("Press 1 to Add to a book or 2 to get the library listing");
				message = (String) in.readObject();

				if (message.equalsIgnoreCase("1")) {
					sendMessage("Please enter the book name");
					message = (String) in.readObject();

					sendMessage("Please enter the book author");
					message2 = (String) in.readObject();

					// Add book to the list....
					lib.addBook(message, message2);
				} else if (message.equalsIgnoreCase("2")) {
					// message = "name"+"*"+"author"+"?"+"name1"+"*"+"author1"+"?";
					message = lib.getList();

					// Option 1
					// sendMessage(message);

					// Option2
					String[] books = message.split("\\?");

					sendMessage("" + books.length);

					for (int i = 0; i < books.length; i++) {
						String[] details = books[i].split("\\*");

						sendMessage(details[0]);
						sendMessage(details[1]);

					}
				}

				sendMessage("Please enter 1 to repeat or 2 to exit");
				message = (String) in.readObject();

			} while (message.equalsIgnoreCase("1"));
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		}

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
