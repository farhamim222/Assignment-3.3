import model.Book;
import model.LibraryMember;
import system.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Java Basics", "John Doe", "123456");
        Book book2 = new Book("OOP Concepts", "Jane Smith", "789101");

        library.addBook(book1);
        library.addBook(book2);

        LibraryMember alice = new LibraryMember("Alice", 1);
        LibraryMember bob = new LibraryMember("Bob", 2);

        library.addMember(alice);
        library.addMember(bob);

        System.out.println("Reserving a book...");
        library.reserveBook(alice, book2);
        library.displayReservedBooks(alice);

        System.out.println("Cancelling reservation...");
        library.cancelReservation(alice, book2);
        library.displayReservedBooks(alice);
    }
}
