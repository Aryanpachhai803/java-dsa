package Day_9;

import java.util.Scanner;

class Node {
    String name;
    Node next;

    Node(String name) {
        this.name = name;
        this.next = null;
    }
}

class CustomerQueue {
    Node front, rear;

    void enqueue(String name) {
        Node newNode = new Node(name);
        if (rear == null) {
            front = rear = newNode;
            System.out.println(name + " added to queue.");
            return;
        }

        rear.next = newNode;
        rear = newNode;
        System.out.println(name + " added to queue.");
    }

    void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println(front.name + " is being served.");
        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

}

public class CustomerService {
    public static void main(String[] args) {
    }
}