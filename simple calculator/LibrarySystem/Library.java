import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayBooks() {
        System.out.println("\n--- Book List ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void displayUsers() {
        System.out.println("\n--- User List ---");
        for (User u : users) {
            System.out.println(u);
        }
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book == null || user == null) {
            System.out.println("Invalid book or user ID!");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Sorry, the book is already issued!");
        } else {
            book.issueBook();
            user.borrowBook(book);
            System.out.println("Book issued successfully to " + user.getName());
        }
    }

    public void returnBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book == null || user == null) {
            System.out.println("Invalid book or user ID!");
            return;
        }

        if (book.isIssued()) {
            book.returnBook();
            user.returnBook(book);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("This book was not issued.");
        }
    }

    private Book findBook(int bookId) {
        for (Book b : books) {
            if (b.getId() == bookId) return b;
        }
        return null;
    }

    private User findUser(int userId) {
        for (User u : users) {
            if (u.getUserId() == userId) return u;
        }
        return null;
    }
}
