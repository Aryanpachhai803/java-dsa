package Day_5;

import java.util.Scanner;

public class TicketBooking {
    Node front;
    Node rear;
    int availableSeats;

    class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public void ticketQueue(int seats) {
        front = rear = null;
        availableSeats = seats;
        System.out.println("Ticket System with " + seats + "seats.");
    }

    //Enqueue Operation
    public void addSeats(String name, int tickets){
        if(tickets > availableSeats){
            System.out.println("Seats not available");
            return;
        }

        Node newNode = new Node(name + " ( " + tickets + " tickets) ");
        if(rear == null){
            front = rear = newNode;
        }
        else{
            rear.next = newNode;
            rear = newNode;
        }

        availableSeats -= tickets;
        System.out.println(name + " added to queue.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketBooking queue = new TicketBooking();
        queue.ticketQueue(100);

        while (true) {
            System.out.println("===Ticket Booking System===");
            System.out.println("1. Add Customer");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.println("Enter customer name : ");
                    String name = sc.nextLine();
                    System.out.println("Enter number of tickets : ");
                    int tickets = sc.nextInt();
                    queue.addSeats(name,tickets);
                    break;
            
                default:
                    break;
            }
        }
    }
}
