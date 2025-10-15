import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }
    public void showAllBooks() {
        for (Book book : books) {
            book.displayInfo();
        }
    }
    public void addUser(User user) {
        users.add(user);
    }
    public ArrayList<User> getUsers() { return users; }
    public User login(int id, String name) {
        for (User u : users)
            if (u.getId() == id && u.getName().equalsIgnoreCase(name)) return u;
        return null;
    }
    public void removeBook(String isbn) {
        Book toRemove = null;
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                toRemove = b;
                break;
            }
        }
        if (toRemove != null) {
            books.remove(toRemove);
            System.out.println("✅ Book removed: " + toRemove.getTitle());
        } else
            System.out.println("❌ Book not found!");
    }
    public void borrowBook(Member m, String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                m.borrowBook(b);
                return;
            }
        }
        System.out.println("❌ Book not found!");
    }
    public void returnBook(Member m, String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                m.returnBook(b);
                return;
            }
        }
        System.out.println("❌ Book not found!");
    }
    public void searchBookByTitle(String title) {
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                b.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ No books found with title containing: " + title);
        }
    }
    public void showBorrowedBooks(Member m) {
        System.out.println("📚 Borrowed books by " + m.getName() + ":");
        if (m.getBorrowedBooks().isEmpty()) {
            System.out.println("   No borrowed books.");
        } else {
            for (Book b : m.getBorrowedBooks()) {
                b.displayInfo();
            }
        }
    }
}