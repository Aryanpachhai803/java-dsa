package Day_9;

import java.util.Scanner;

class Node {
    String message;
    Node next;

    Node(String message) {
        this.message = message;
        this.next = null;
    }
}

class ChatQueue {
    Node front, rear;
    void sendMessage(String msg) {
        Node newNode = new Node(msg);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Message Sent: " + msg);
    }

}

public class ChatMessage {
    public static void main(String[] args) {
      
    }
}