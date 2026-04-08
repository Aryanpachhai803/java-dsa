package Practical;

public class Heap {
    static int[] heap = new int[10];
    static int size = 0;
    static void insert(int value) {
        heap[size] = value;
        int i = size;
        size++;
        while (i > 0 && heap[(i - 1) / 2] > heap[i]) {
            int temp = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
    }
    static int delete() {
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        int i = 0;
        while (2 * i + 1 < size) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = left;

            if (right < size && heap[right] < heap[left]) {
                smallest = right;
            }
            if (heap[i] > heap[smallest]) {
                int temp = heap[i];
                heap[i] = heap[smallest];
                heap[smallest] = temp;
                i = smallest;
            } else {
                break;
            }
        }
        return root;
    }
    static void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        insert(10);
        insert(5);
        insert(20);
        insert(2);
        System.out.print("Heap: ");
        display();
        System.out.println("Deleted: " + delete());
        System.out.print("After deletion: ");
        display();
    }
}
