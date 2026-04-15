package Day_9;

import java.util.Scanner;
public class ChatMessage {
    int size = 0;
    int MAX = 10;

    static class Node {
        String message;
        Node next;

        Node(String message) {
            this.message = message;
            this.next = null;
        }
    }
    Node front;
    Node rear;

    public ChatMessage() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(String message) {
        if (size == MAX) {
            System.out.println("Message Queue Overflow");
            return;
        }
        Node newNode = new Node(message);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
        System.out.println("Message Sent: " + message);
    }

    public void dequeue() {
        if (front == null) {
            System.out.println("No messages to deliver (Underflow)");
            return;
        }
        String msg = front.message;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        size--;
        System.out.println("Delivered Message: " + msg);
    }

    public void peek() {
        if (front == null) {
            System.out.println("No messages in queue");
            return;
        }
        System.out.println("Next Message: " + front.message);
    }

    public void display() {
        if (front == null) {
            System.out.println("No messages in queue");
            return;
        }
        Node temp = front;
        System.out.println("Pending Messages:");
        while (temp != null) {
            System.out.println(temp.message);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ChatMessage queue = new ChatMessage();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== Chat Queue Menu =====");
            System.out.println("1. Send Message");
            System.out.println("2. Deliver Message");
            System.out.println("3. View Next Message");
            System.out.println("4. Display Messages");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter message: ");
                    String msg = sc.nextLine();
                    queue.enqueue(msg);
                    break;

                case 2:
                    queue.dequeue();
                    break;

                case 3:
                    queue.peek();
                    break;

                case 4:
                    queue.display();
                    break;

                case 5:
                    System.out.println("Thank you. Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again");
            }
        }
    }
}