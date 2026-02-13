package Day_8;

import java.util.Scanner;

public class SimpleProject {
    int size = 0;
    int MAX = 100;

    static class Node{
        String task;
        Node next;

        Node(String task){
            this.task = task;
            this.next = null;
        }
    }

    Node top;

    public void Stack(){
        this.top = null;
    }

    //Add Action

    public void add(String element){
        if(size == MAX){
            System.out.println("Stack Overflow");
            return;
        }

        Node newNode = new Node(element);
        newNode.task  = element;
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("The added task in the stack is : " + element);
        return;
    }


    public static void main(String[] args) {
        SimpleProject linkList = new SimpleProject();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=====Stack Menu=====");
            System.out.println("1. Add Action");
            System.out.println("2. Undo Last Action");
            System.out.println("3. Display Current Stack");
            System.out.println("4. Exit Program");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the task: ");
                    String element = sc.nextLine();
                    linkList.add(element);
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
