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

                default:
                    System.out.println("Invalid choice. Try again");
            }
        }
    }
}