package se.lexicon;

import java.util.Arrays;

class Person {
    private static int personCounter = 0; // Counter to assign unique IDs to each person
    private int id; // Unique ID for the person
    private String firstName; // First name of the person
    private String lastName; // Last name of the person
    private Book[] borrowedBooks; // Array to hold borrowed books

    // Constructor to initialize a person with their first and last names
    public Person(String firstName, String lastName) {
        this.id = ++personCounter; // Assign a unique ID
        this.firstName = firstName; // Set the person's first name
        this.lastName = lastName; // Set the person's last name
        this.borrowedBooks = new Book[0]; // Initialize borrowedBooks as an empty array
    }

    // Getter for the person's ID
    public int getId() {
        return id;
    }

    // Getter for the person's first name
    public String getFirstName() {
        return firstName;
    }

    // Getter for the person's last name
    public String getLastName() {
        return lastName;
    }

    // Getter for the borrowedBooks array
    public Book[] getBorrowedBooks() {
        return borrowedBooks;
    }

    // Method to loan a book to the person
    public void loanBook(Book book) {
        if (book.getBorrower() == null) { // Check if the book is available for loan
            book.setBorrower(this); // Set the borrower of the book

            // Resize the array to hold one more book
            borrowedBooks = Arrays.copyOf(borrowedBooks, borrowedBooks.length + 1);
            borrowedBooks[borrowedBooks.length - 1] = book; // Add the new book at the last index
            System.out.println(firstName + " " + lastName + " has borrowed the book: " + book.getTitle()); // Inform that the book has been borrowed
        } else {
            System.out.println("The book is currently unavailable for loan."); // Inform that the book is not available
        }
    }

    // Method to return a book borrowed by the person
    public void returnBook(Book book) {
        for (int i = 0; i < borrowedBooks.length; i++) { // Iterate through borrowed books
            if (borrowedBooks[i] == book) { // Check if the current book is the one being returned
                book.setBorrower(null); // Remove the borrower from the book
                borrowedBooks[i] = null; // Set the returned book's array slot to null

                // Create a new array without the returned book
                Book[] newBorrowedBooks = new Book[borrowedBooks.length - 1];
                int newIndex = 0;

                // Copy existing books into the new array, skipping nulls
                for (int j = 0; j < borrowedBooks.length; j++) {
                    if (borrowedBooks[j] != null) { // Check for non-null books
                        newBorrowedBooks[newIndex++] = borrowedBooks[j]; // Add to new array
                    }
                }

                borrowedBooks = newBorrowedBooks; // Update the borrowedBooks reference
                System.out.println(firstName + " " + lastName + " has returned the book: " + book.getTitle()); // Inform that the book has been returned
                return;
            }
        }
        System.out.println("The book is not borrowed by " + firstName + " " + lastName + "."); // Inform if the book was not borrowed
    }

    // Method to display all borrowed books by the person
    public void showBorrowedBooks() {
        System.out.println(firstName + " " + lastName + " has borrowed the following books:");
        for (Book borrowedBook : borrowedBooks) { // Iterate through borrowed books
            if (borrowedBook != null) { // Check for non-null books
                System.out.println("- " + borrowedBook.getTitle()); // Print the title of the borrowed book
            }
        }
    }

    // Method to get the person's information as a formatted string
    public String getPersonInformation() {
        return "ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName; // Return formatted string with person's information
    }
}




