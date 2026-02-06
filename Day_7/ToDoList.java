package Day_7;

import java.util.Scanner;

public class ToDoList {
    static Node head;

    static class Node {
        String task;
        Node next;

        Node(String task) {
            this.task = task;
            this.next = null;
        }
    }

    // -----------------Add Task---------------------------------

    public void addTask(String taskAdd) {
        Node temp;
        Node newNode = new Node(taskAdd);
        newNode.next = null;

        if (head == null) {
            head = newNode;
            System.out.println("Task Added : ");
            return;
        }
        temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return;
    }

    // --------------Delete Task----------------------------------------

    public void deleteTask(String taskDelete) {
        if (head == null) {
            System.out.println("Task list is empty!");
            return;
        }

        // If task is at head
        if (head.task.equals(taskDelete)) {
            head = head.next;
            System.out.println("Task deleted successfully!");
            return;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.task.equals(taskDelete)) {
                prev.next = curr.next;
                System.out.println("Task deleted successfully!");
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Task not found!");
    }

    //--------------------Display Tasks---------------------

    public void displayTasks() {
        Node temp;

        if (head == null) {
            System.out.println("Task List is empty");
            return;
        }

        temp = head;
        System.out.println("List of tasks : ");

        while (temp != null) {
            System.out.print(temp.task + " ");
            temp = temp.next;
        }
    }
    

    public static void main(String[] args) {
        ToDoList linkList = new ToDoList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=====To Do List Menu=====");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter task to add: ");
                    String taskAdd = sc.nextLine();
                    linkList.addTask(taskAdd);
                    break;

                case 2:
                    System.out.print("Enter task to delete: ");
                    String taskDelete = sc.nextLine();
                    linkList.deleteTask(taskDelete);
                    break;    

                case 3:
                    linkList.displayTasks();
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