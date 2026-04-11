package Day_4;

class CircularQueue {
    private String[] queue;
    private int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(String item) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    public String dequeue() {
        if (size == 0) {
            return null;
        }
        String item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public String peek() {
        if (size == 0) return null;
        return queue[front];
    }
}

public class TrafficControl {
    public static void main(String[] args) {
        }
    }
