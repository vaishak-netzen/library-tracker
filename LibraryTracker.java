import java.util.ArrayList;
import java.util.Scanner;

public class LibraryTracker {
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Library Tracker ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1: addBook(); break;
                case 2: viewBooks(); break;
                case 3: searchBook(); break;
                case 4: deleteBook(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while(choice != 5);
    }

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        books.add(new Book(title, author, isbn));
        System.out.println("Book added successfully!");
    }

    private static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("\n--- All Books ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private static void searchBook() {
        System.out.print("Enter title or author to search: ");
        String query = sc.nextLine().toLowerCase();
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(query) || b.getAuthor().toLowerCase().contains(query)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) System.out.println("No matching books found.");
    }

    private static void deleteBook() {
        System.out.print("Enter ISBN of book to delete: ");
        String isbn = sc.nextLine();
        boolean removed = books.removeIf(b -> b.getIsbn().equals(isbn));
        if (removed) System.out.println("Book deleted successfully!");
        else System.out.println("Book not found!");
    }
}
