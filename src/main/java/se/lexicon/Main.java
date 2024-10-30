package se.lexicon;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("mr", "jack");
        Book book2 = new Book("not ", "mke");
        Book book3 = new Book("sd", "sad");

        Person person = new Person("jack", "sd");

        person.loanBook(book1);
        person.loanBook(book2);
        person.loanBook(book3);

        person.showBorrowedBooks();

        person.returnBook(book2); //

        person.showBorrowedBooks();
        person.returnBook(book3);
    }
}