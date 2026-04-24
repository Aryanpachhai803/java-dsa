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
       
    }
}