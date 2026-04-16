
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

}

public class HistoryDemo {
    public static void main(String[] args) {
       
    }
}