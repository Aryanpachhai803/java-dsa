package Practical;

public class HeapDemo {
    static int[] priority = new int[10];   
    static String[] task = new String[10]; 
    static int size = 0;

    static void insert(int p, String t) {
        priority[size] = p;
        task[size] = t;

        int i = size;
        size++;

        while (i > 0 && priority[(i - 1) / 2] > priority[i]) {
            int tempP = priority[i];
            priority[i] = priority[(i - 1) / 2];
            priority[(i - 1) / 2] = tempP;

            String tempT = task[i];
            task[i] = task[(i - 1) / 2];
            task[(i - 1) / 2] = tempT;

            i = (i - 1) / 2;
        }
    }

    static String delete() {
        String rootTask = task[0];

        priority[0] = priority[size - 1];
        task[0] = task[size - 1];
        size--;

        int i = 0;

        while (2 * i + 1 < size) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = left;

            if (right < size && priority[right] < priority[left]) {
                smallest = right;
            }

            if (priority[i] > priority[smallest]) {
                int tempP = priority[i];
                priority[i] = priority[smallest];
                priority[smallest] = tempP;

                String tempT = task[i];
                task[i] = task[smallest];
                task[smallest] = tempT;

                i = smallest;
            } else {
                break;
            }
        }

        return rootTask;
    }

    static void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(task[i] + " (Priority: " + priority[i] + ")");
        }
    }

    public static void main(String[] args) {
        insert(3, "Do Homework");
        insert(1, "Emergency Fix");
        insert(4, "Watch Movie");
        insert(2, "Study Java");

        System.out.println("Tasks in Heap:");
        display();

        System.out.println("\nProcessing Task: " + delete());

        System.out.println("\nAfter processing:");
        display();
    }
}