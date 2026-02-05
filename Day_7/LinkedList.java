package Day_7;

import java.util.Scanner;

public class LinkedList {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

//--------------------------------------Insert At Start-------------------------------------------------------------    
    public void insertAtBeginning(int element){
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        System.out.println("Element inserted at the beginning.");
    }

//--------------------------------------Traverse/Display all Element------------------------------------------------    
    public void traverse(){
        Node temp;
        if(head == null){
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
                    int element = sc.nextInt();
                    linkList.insertAtBeginning(element);
                    break;

                case 2:    
                case 5:
                    linkList.traverse();
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
