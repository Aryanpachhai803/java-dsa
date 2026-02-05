package Day_7;

import java.util.Scanner;

public class LinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // --------------------------------------Insert At Start-------------------------------------------------------------
    public void insertAtBeginning(int elementStart) {
        Node newNode = new Node(elementStart);
        newNode.next = head;
        head = newNode;
        System.out.println("Element inserted at the beginning.");
    }

    // --------------------------------------Insert At End-------------------------------------------------------------
    public void insertAtEnd(int elementEnd) {
        Node temp;
        Node newNode = new Node(elementEnd);
        newNode.next = null;
        if (head == null) {
            head = newNode;
            return;
        }
        temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        System.out.println("Element inserted at the end");
        return;
    }

    // ---------------------------------------Delete From Start----------------------------------------
    public void deleteFromStart() {
        if (head == null) {
            System.out.println("Underflow Error: List is empty");
            return;
        }
        head = head.next;
        return;
    }

    // ---------------------------------------Delete From End------------------------------------------------------------
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node secondLastNode = head;
        Node lastNode = head.next;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLastNode = secondLastNode.next;
        }
        secondLastNode.next = null;
    }

    // --------------------------------------Traverse/Display all Element------------------------------------------------
    public void traverse() {
        Node temp;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        temp = head;
        System.out.println("List of elements : ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // ------------------------------------Search------------------------------------------------------
    public void searchElement(int target) {
        Node temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.data == target) {
                System.out.println("Element found on index : " + pos);
                return;
            }
            temp = temp.next;
            pos = pos + 1;
        }
        System.out.println("Element not found in list.");
        return;
    }

    // ----------------------------------List Size---------------------------------------------------------------
    public void listSize() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count += 1;
            temp = temp.next;
        }
        System.out.println("List Size : " + count);
        return;
    }

    public static void main(String[] args) {
        LinkedList linkList = new LinkedList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=====List Menu=====");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Delete from start");
            System.out.println("4. Delete from end");
            System.out.println("5. Traverse");
            System.out.println("6. Search for an element");
            System.out.println("7. List Size");
            System.out.println("8. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the element: ");
                    int elementStart = sc.nextInt();
                    linkList.insertAtBeginning(elementStart);
                    break;

                case 2:
                    System.out.println("Enter the element");
                    int elementEnd = sc.nextInt();
                    linkList.insertAtEnd(elementEnd);
                    break;

                case 3:
                    linkList.deleteFromStart();
                    break;

                case 4:
                    linkList.deleteFromEnd();
                    break;

                case 5:
                    linkList.traverse();
                    break;

                case 6:
                    System.out.println("Enter the element to search:");
                    int target = sc.nextInt();
                    linkList.searchElement(target);
                    break;

                case 7:
                    linkList.listSize();
                    break;

                case 8:
                    System.out.println("Thank you. Exiting.....");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choose. Try again");
            }
        }
    }
}
