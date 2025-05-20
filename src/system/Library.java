package system;

import model.Book;
import model.LibraryMember;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<LibraryMember> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void addMember(LibraryMember member) {
        members.add(member);
        System.out.println("Member added: " + member.getName() + " (ID: " + member.getMemberId() + ")");
    }

    public void borrowBook(LibraryMember member, Book book) {
        if (books.contains(book) && !book.isReserved()) {
            books.remove(book);
            System.out.println("Book borrowed: " + book);
        } else {
            System.out.println("Book not available.");
        }
    }

    public void returnBook(Book book) {
        books.add(book);
        System.out.println("Book returned: " + book);
    }

    public void reserveBook(LibraryMember member, Book book) {
        if (!book.isReserved()) {
            book.setReserved(true);
            member.addReservedBook(book);
            System.out.println("Book reserved: " + book);
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    public void cancelReservation(LibraryMember member, Book book) {
        if (book.isReserved() && member.hasReservedBook(book)) {
            book.setReserved(false);
            member.removeReservedBook(book);
            System.out.println("Reservation canceled: " + book);
        } else {
            System.out.println("No reservation to cancel.");
        }
    }

    public void displayReservedBooks(LibraryMember member) {
        System.out.println("Reserved books for " + member.getName() + ":");
        for (Book book : member.getReservedBooks()) {
            System.out.println("- " + book);
        }
    }

    public List<Book> getAvailableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book book : books) {
            if (!book.isReserved()) {
                available.add(book);
            }
        }
        return available;
    }
}
