import java.util.*;

enum MenuOption {
    ADD_BOOK("Add Book"),
    REMOVE_BOOK("Remove Book"),
    BORROW_BOOK("Borrow Book"),
    RETURN_BOOK("Return Book"),
    SHOW_BORROWED_BOOKS("Show Borrowed Books"),
    SEARCH_BOOK("Search Book"),
    SHOW_ALL_BOOKS("Show All Books"),
    EXIT("Exit");
    private final String label;
    MenuOption(String label) {
        this.label = label;
    }
    @Override
    public String toString() {
        return label;
    }
}



public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        String[][] bookData = {
                {"Clean Code", "Robert C. Martin", "1111", "3"},
                {"Design Patterns", "Erich Gamma", "2222", "2"},
                {"Effective Java", "Joshua Bloch", "3333", "4"},
        };
        for (String[] data : bookData)
            library.addBook(new Book(data[0], data[1],  data[2], Integer.parseInt(data[3])));
        library.addUser(new Admin(1, "Alice"));
        library.addUser(new Member(2, "Bob"));
        library.addUser(new Member(3, "Charlie"));

        Scanner scanner = new Scanner(System.in);
        User currentUser = null;
        while (currentUser == null) {
            System.out.println("🔑 Login:");
            System.out.print("Enter ID (0 to exit): ");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (id == 0) {
                System.out.println("👋 Exiting program...");
                return;
            }
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            currentUser = library.login(id, name);
            if (currentUser == null) {
                System.out.println("❌ User not found! Try again...\n");
            }
        }
        System.out.println("✅ Welcome " + currentUser.getName());
        int choice;
        do {
            List<MenuOption> menuOptions = new ArrayList<>();
            if (currentUser instanceof Admin) {
                menuOptions.add(MenuOption.ADD_BOOK);
                menuOptions.add(MenuOption.REMOVE_BOOK);
            }
            if (currentUser instanceof Member) {
                menuOptions.add(MenuOption.BORROW_BOOK);
                menuOptions.add(MenuOption.RETURN_BOOK);
                menuOptions.add(MenuOption.SHOW_BORROWED_BOOKS);
            }
            menuOptions.add(MenuOption.SEARCH_BOOK);
            menuOptions.add(MenuOption.SHOW_ALL_BOOKS);
            menuOptions.add(MenuOption.EXIT);

            System.out.println("\n===== MENU =====");
            for (int i = 0; i < menuOptions.size(); i++) {
                System.out.println((i + 1) + ". " + menuOptions.get(i));
            }
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice < 1 || choice > menuOptions.size()) {
                System.out.println("❌ Invalid choice!");
                continue;
            }

            MenuOption selected = menuOptions.get(choice - 1);
            switch (selected) {
                case ADD_BOOK:
                    if (currentUser instanceof Admin) {
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.print("Enter copies: ");
                        int copies = scanner.nextInt();
                        scanner.nextLine();
                        ((Admin) currentUser).addBook(library, new Book(title, author, isbn, copies));
                    }
                    break;

                case REMOVE_BOOK:
                    if (currentUser instanceof Admin) {
                        System.out.print("Enter ISBN to remove: ");
                        String isbn = scanner.nextLine();
                        ((Admin) currentUser).removeBook(library, isbn);
                    }
                    break;

                case BORROW_BOOK:
                    if (currentUser instanceof Member) {
                        System.out.print("Enter ISBN to borrow: ");
                        String isbn = scanner.nextLine();
                        library.borrowBook((Member) currentUser, isbn);
                    }
                    break;

                case RETURN_BOOK:
                    if (currentUser instanceof Member) {
                        System.out.print("Enter ISBN to return: ");
                        String isbn = scanner.nextLine();
                        library.returnBook((Member) currentUser, isbn);
                    }
                    break;

                case SEARCH_BOOK:
                    System.out.print("Enter title to search: ");
                    String title = scanner.nextLine();
                    library.searchBookByTitle(title);
                    break;

                case SHOW_ALL_BOOKS:
                    library.showAllBooks();
                    break;

                case SHOW_BORROWED_BOOKS:
                    if (currentUser instanceof Member) {
                        library.showBorrowedBooks((Member) currentUser);
                    }
                    break;

                case EXIT:
                    System.out.println("👋 Goodbye!");
                    choice = 0;
                    break;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        } while (choice != 0);
        scanner.close();
    }
}