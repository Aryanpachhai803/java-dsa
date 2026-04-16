
import java.util.Scanner;

class Node {
    String url;
    Node prev;
    Node next;

    Node(String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
    }
}

class BrowserHistory {
    private Node current;

    public void visit(String url) {
        Node newNode = new Node(url);

        if (current != null) {
            current.next = null; 
            newNode.prev = current;
        }

        current = newNode;
        System.out.println("Visited: " + current.url);
    }

    public void back() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Back to: " + current.url);
        } else {
            System.out.println("No previous page.");
        }
    }

    public void forward() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Forward to: " + current.url);
        } else {
            System.out.println("No next page.");
        }
    }

    public void currentPage() {
        if (current != null) {
            System.out.println("Current page: " + current.url);
        } else {
            System.out.println("No page opened.");
        }
    }
}

public class HistoryDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BrowserHistory browser = new BrowserHistory();

        int choice;
        String url;

        do {
            System.out.println("\n--- Browser History Menu ---");
            System.out.println("1. Visit Page");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Current Page");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter URL: ");
                    url = sc.nextLine();
                    browser.visit(url);
                    break;

                case 2:
                    browser.back();
                    break;

                case 3:
                    browser.forward();
                    break;

                case 4:
                    browser.currentPage();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}