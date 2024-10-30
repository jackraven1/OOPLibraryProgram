package se.lexicon;

class Book {
    private static int bookCounter = 0; // Static counter to assign unique IDs to books
    private int id; // Unique identifier for each book
    private String title; // Title of the book
    private String author; // Author of the book
    private boolean available; // Indicates if the book is available for borrowing
    private String borrower; // Name of the person who borrowed the book

    // Constructor to create a book with a title and an author
    public Book(String title, String author) {
        this.id = ++bookCounter; // Increment the counter and assign a unique ID
        this.title = title; // Set the title
        this.author = author; // Set the author
        this.available = true; // The book is available by default
        this.borrower = null; // Initially, the book has no borrower
    }

    // Constructor to create a book with a title, an author, and a borrower
    public Book(String title, String author, String borrower) {
        this(title, author); // Call the first constructor to set title and author
        setBorrower(borrower); // Set the borrower using the setter method
    }

    // Getter method for the ID
    public int getId() {
        return id; // Return the unique ID of the book
    }

    // Getter method for the title
    public String getTitle() {
        return title; // Return the title of the book
    }

    // Getter method for the author
    public String getAuthor() {
        return author; // Return the author of the book
    }

    // Getter method for the borrower
    public String getBorrower() {
        return borrower; // Return the name of the borrower
    }

    // Setter method to set the borrower of the book
    public void setBorrower(String borrower) {
        this.borrower = borrower; // Set the borrower
        this.available = (borrower == null); // Update availability based on borrower status
    }

    // Method to get information about the book
    public String getBookInformation() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author +
                ", Available: " + (available ? "Yes" : "No, Borrower: " + borrower);
    }
}


