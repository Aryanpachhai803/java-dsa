package Day_9;

import java.util.Scanner;

public class QueueUsingLinkedList {
    int size = 0;
    int MAX = 10;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front;
    Node rear;

    // Constructor
    public QueueUsingLinkedList() {
        this.front = null;
        this.rear = null;
    }

    // Enqueue Operation
    public void enqueue(int element) {
        if (size == MAX) {
            System.out.println("Queue Overflow");
            return;
        }

        Node newNode = new Node(element);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
        System.out.println("The enqueued element in the queue is: " + element);
    }

    // Dequeue Operation
    public void dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow");
            return;
        }

        int element = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;
        System.out.println("The dequeued element from the queue is: " + element);
    }

 

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== Queue Menu =====");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the element: ");
                    int element = sc.nextInt();
                    queue.enqueue(element);
                    break;

                case 2:
                    queue.dequeue();
                    break;

                default:
                    System.out.println("Invalid choice. Try again");
            }
        }
    }
}