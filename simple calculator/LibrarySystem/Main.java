import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        // Add sample books & users
        library.addBook(new Book(1, "Java Programming", "James Gosling"));
        library.addBook(new Book(2, "Clean Code", "Robert C. Martin"));
        library.addUser(new User(101, "Neha"));
        library.addUser(new User(102, "Amit"));

        int choice;
        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Display all Books");
            System.out.println("2. Display all Users");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    library.displayUsers();
                    break;
                case 3:
                    System.out.print("Enter Book ID: ");
                    int bId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int uId = sc.nextInt();
                    library.issueBook(bId, uId);
                    break;
                case 4:
                    System.out.print("Enter Book ID: ");
                    bId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    uId = sc.nextInt();
                    library.returnBook(bId, uId);
                    break;
                case 5:
                    System.out.println("Thank you for using Library System!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 5);

        sc.close();
    }
}
