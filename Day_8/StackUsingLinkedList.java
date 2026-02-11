package Day_8;

import java.util.Scanner;

public class StackUsingLinkedList {
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

    Node top;

    public void Stack() {
        this.top = null;
    }

    // Push Operation

    public void push(int element) {
        if (size == MAX) {
            System.out.println("Stack Overflow");
            return;
        }

        Node newNode = new Node(element);
        newNode.data = element;
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("The pushed element in the stack is: " + element);
        return;
    }

    //Pop Operation

    public void pop(){
        if(top == null){
            System.out.println("Stack Underflow");
            return;
        }
        Node temp = top;
        int element = top.data;
        top = top.next;
        size--;
        System.out.println("The popped element in the stack is: " + element);
        return;
    }

    //Display Operation

    public void display(){
        if(top == null){
            System.out.println("Stack is empty");
            return;
        }

        Node temp = top;
        System.out.println("Stack Elements : ");
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;   
        }
    }
    public static void main(String[] args) {
        StackUsingLinkedList linkList = new StackUsingLinkedList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=====Stack Menu=====");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the element: ");
                    int element = sc.nextInt();
                    linkList.push(element);
                    break;

                case 2:
                    linkList.pop();
                    break;

                case 3:
                    linkList.display();
                    break;
                    
                case 4:
                    System.out.println("Thank you. Exiting.....");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choose. Try again");
            }
        }
    }
}
