package Day_3;

import java.util.*;

class Order {
    int orderId;
    String foodItem;

    Order(int orderId, String foodItem) {
        this.orderId = orderId;
        this.foodItem = foodItem;
    }

    public String toString() {
        return "Order ID: " + orderId + ", Item: " + foodItem;
    }
}

public class FoodOrderSystem {
    public static void main(String[] args) {
        Queue<Order> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int choice, orderId = 1;

        while (true) {
            System.out.println("\n--- Food Order System ---");
            System.out.println("1. Place Order");
            System.out.println("2. Prepare Order");
            System.out.println("3. Display Orders");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter food item: ");
                    String item = sc.nextLine();
                    queue.add(new Order(orderId++, item));
                    System.out.println("Order placed successfully!");
                    break;

                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("No orders to prepare.");
                    } else {
                        Order served = queue.poll();
                        System.out.println("Preparing: " + served);
                    }
                    break;

                case 3:
                    if (queue.isEmpty()) {
                        System.out.println("No pending orders.");
                    } else {
                        System.out.println("Pending Orders:");
                        for (Order o : queue) {
                            System.out.println(o);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}