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

    void deliverMessage() {
        if (front == null) {
            System.out.println("No messages to deliver.");
            return;
        }

        System.out.println("Delivered: " + front.message);
        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    void nextMessage() {
        if (front == null) {
            System.out.println("No messages in queue.");
        } else {
            System.out.println("Next Message: " + front.message);
        }
    }

    void displayQueue() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }
        Node temp = front;
        System.out.println("Pending Messages:");
        while (temp != null) {
            System.out.println("- " + temp.message);
            temp = temp.next;
        }
    }
}

public class ChatMessage {
    public static void main(String[] args) {
      
    }
}