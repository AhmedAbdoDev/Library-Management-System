import java.util.ArrayList;

public class Member extends User {
    private ArrayList<Book> borrowedBooks = new ArrayList<>();
    public Member(int id, String name) {
        super(id, name);
    }
    public void borrowBook(Book book) {
        if (book.getCopiesAvailable() > 0) {
            borrowedBooks.add(book);
            book.decreaseCopies();
            System.out.println(name + " borrowed " + book.getTitle());
        } else {
            System.out.println("No copies available for " + book.getTitle());
        }
    }
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.increaseCopies();
            System.out.println(name + " returned " + book.getTitle());
        } else {
            System.out.println("This book wasn't borrowed by " + name);
        }
    }
    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks;}
    @Override
    public void displayInfo() {
        System.out.println("Member: " + name + " (ID: " + id + ")");
    }
}