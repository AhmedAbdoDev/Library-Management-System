public class Admin extends User {

    public Admin(int id, String name) {
        super(id, name);
    }
    @Override
    public void displayInfo() {
        System.out.println("Admin: " + name + " (ID: " + id + ")");
    }
    public void addBook(Library library, Book book) {
        library.addBook(book);
        System.out.println("✅ Admin added the book: " + book.getTitle());
    }
    public void removeBook(Library library, String isbn) {
        library.removeBook(isbn);
        System.out.println("✅ Admin removed the book with ISBN: " + isbn);
    }
    public void updateBook(){}
}
