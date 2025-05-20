import model.Book;
import model.LibraryMember;
import system.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Java Basics", "John Doe", "123456");
        Book book2 = new Book("OOP Concepts", "Jane Smith", "789101");

        LibraryMember member1 = new LibraryMember("Alice", 1);
        LibraryMember member2 = new LibraryMember("Bob", 2);

        library.addBook(book1);
        library.addBook(book2);
        library.addMember(member1);
        library.addMember(member2);

        library.printBooks();
        library.borrowBook(book1);
        library.printBooks();
        library.returnBook(book1);
        library.printBooks();
    }
}
