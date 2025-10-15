public class Book {
    private String title;
    private String author;
    private String isbn;
    private int copiesAvailable;

    public Book(String title, String author, String isbn, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.copiesAvailable = copiesAvailable;
    }

    public void displayInfo() {
        System.out.println(title + " by " + author + " | ISBN: " + isbn + " | Copies: " + copiesAvailable);
    }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getCopiesAvailable() { return copiesAvailable; }
    public void decreaseCopies() { copiesAvailable--; }
    public void increaseCopies() { copiesAvailable++; }
}