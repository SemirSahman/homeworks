package ba.bitcamp.task234;

import javax.naming.OperationNotSupportedException;

public class Main {

	public static void main(String[] args) {

		Author a1 = new Author("Ivo Andric", "ivoa@gmail.com", "male");
		Author a2 = new Author("Mesa Selimovic", "mesas@yahoo.com", "male");
		Book b1 = new Book("Knjiga1", 10, 2, a1);
		Book b2 = new Book("Knjiga2", 10, 2, a1);
		Book b3 = new Book("Knjiga3", 10, 2, a1);
		Book b4 = new Book("Knjiga4", 10, 2, a1);
		Book b5 = new Book("Knjiga5", 10, 2, a1);
		Book b6 = new Book("Knjiga6", 10, 2, a2);
		Book b7 = new Book("Knjiga7", 10, 2, a2);
		Book[] books = new Book[] { b1, b2, b3, b4, b5, b6, b7 };
		BookStore b = new BookStore("Book Store", books);

		b.printBooksByAuthor(a1);
		Book b8 = new Book("Knjiga8", 10, 2, a2);
		b.addBook(b8);
		System.out.println();
		b.printBooks();
		try {
			b.sellBook(77, 2);
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}

	}

}
