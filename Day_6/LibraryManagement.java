package Day_6;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    Book next;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.next = null;
    }
}

class Library {
    Book head = null;

    public void addBook(int id, String title, String author) {
        Book newBook = new Book(id, title, author);
        if (head == null) {
            head = newBook;
        } else {
            Book temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newBook;
        }
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }

        Book temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.id +
                               ", Title: " + temp.title +
                               ", Author: " + temp.author);
            temp = temp.next;
        }
    }

    public void searchBook(int id) {
        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                System.out.println("Book found: " + temp.title + " by " + temp.author);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void deleteBook(int id) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        if (head.id == id) {
            head = head.next;
            System.out.println("Book deleted.");
            return;
        }
        Book temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Book not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Book deleted.");
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(id, title, author);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    library.searchBook(searchId);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    library.deleteBook(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
        sc.close();
    }
}