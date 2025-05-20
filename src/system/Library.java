package system;

import model.Book;
import model.LibraryMember;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<LibraryMember> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void addMember(LibraryMember member) {
        members.add(member);
        System.out.println("Member added: " + member);
    }

    public void borrowBook(Book book) {
        if (books.contains(book)) {
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

    public void printBooks() {
        System.out.println("Available books:");
        for (Book book : books) {
            System.out.println("- " + book);
        }
    }
}
