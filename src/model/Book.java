package model;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean reserved;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.reserved = false;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isReserved() { return reserved; }

    // Setters
    public void setReserved(boolean reserved) { this.reserved = reserved; }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " (ISBN: " + isbn + ")";
    }
}
