
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
       
    }
}