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

    void peek() {
        if (front == null) {
            System.out.println("No customers in queue.");
        } else {
            System.out.println("Next customer: " + front.name);
        }
    }

    void display() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }
        Node temp = front;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.name + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class CustomerService {
    public static void main(String[] args) {
    }
}