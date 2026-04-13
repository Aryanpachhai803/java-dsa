package Day_7;

import java.util.Scanner;

public class DoublyLinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;
        Node prev; // new pointer

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // ---------------- Insert At Beginning ----------------
    public void insertAtBeginning(int elementStart) {
        Node newNode = new Node(elementStart);

        if (head != null) {
            head.prev = newNode;
        }

        newNode.next = head;
        head = newNode;

        System.out.println("Element inserted at the beginning.");
    }

    // ---------------- Insert At End ----------------
    public void insertAtEnd(int elementEnd) {
        Node newNode = new Node(elementEnd);

        if (head == null) {
            head = newNode;
            System.out.println("Element inserted at the end.");
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;

        System.out.println("Element inserted at the end.");
    }

    // ---------------- Delete From Start ----------------
    public void deleteFromStart() {
    if (head == null) {
        System.out.println("Underflow Error: List is empty");
        return;
    }
    int deleted = head.data;
    if (head.next == null) {
        head = null;
        System.out.println("Deleted item from start: " + deleted);
        return;
    }
    head = head.next;
    head.prev = null;
    System.out.println("Deleted item from start: " + deleted);
}

    // ---------------- Delete From End ----------------
    public void deleteFromEnd() {
    if (head == null) {
        System.out.println("List is empty");
        return;
    }
    int deleted;
    if (head.next == null) {
        deleted = head.data;
        head = null;
        System.out.println("Deleted item from end: " + deleted);
        return;
    }
    Node temp = head;
    while (temp.next != null) {
        temp = temp.next;
    }
    deleted = temp.data;  
    temp.prev.next = null;
    System.out.println("Deleted item from end: " + deleted); 
}

    // ---------------- Traverse Forward ----------------
    public void traverseForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.println("Forward Traversal:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // ---------------- Traverse Backward ----------------
    public void traverseBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        // go to last node
        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.println("Backward Traversal:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // ---------------- Search ----------------
    public void searchElement(int target) {
        Node temp = head;
        int pos = 0;

        while (temp != null) {
            if (temp.data == target) {
                System.out.println("Element found at index: " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }

        System.out.println("Element not found in list.");
    }

    // ---------------- List Size ----------------
    public void listSize() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("List Size: " + count);
    }

    // ---------------- Main Method ----------------
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Doubly Linked List Menu =====");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Delete from start");
            System.out.println("4. Delete from end");
            System.out.println("5. Traverse forward");
            System.out.println("6. Traverse backward");
            System.out.println("7. Search for an element");
            System.out.println("8. List Size");
            System.out.println("9. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    list.insertAtBeginning(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter element: ");
                    list.insertAtEnd(sc.nextInt());
                    break;

                case 3:
                    list.deleteFromStart();
                    break;

                case 4:
                    list.deleteFromEnd();
                    break;

                case 5:
                    list.traverseForward();
                    break;

                case 6:
                    list.traverseBackward();
                    break;

                case 7:
                    System.out.print("Enter element to search: ");
                    list.searchElement(sc.nextInt());
                    break;

                case 8:
                    list.listSize();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}