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



    public static void main(String[] args) {
        
    }
}