import java.util.Iterator;
import java.util.LinkedList;

public class Listing {

	private LinkedList<Book> library;

	public Listing() {
		library = new LinkedList<Book>();
	}

	public synchronized void addBook(String title, String writer) {
		Book temp = new Book(title, writer);
		library.add(temp);
	}

	public synchronized String getList() {
		Iterator<Book> iter = library.iterator();
		Book temp;
		String result = "";
		while (iter.hasNext()) {
			temp = iter.next();
			result = result + temp.getTitle() + "*" + temp.getAuthor() + "?";
		}

		return result;
	}
}
