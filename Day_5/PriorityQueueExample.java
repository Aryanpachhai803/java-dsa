package Day_5;
 
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        
        //Default: Min-Priority Queue
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        //Max Priority
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        pq.add(10);
        pq.add(5);
        pq.add(20);

        //Peek: See the top element
        System.out.println("Top element: " + pq.peek());  //Output: 5

        //Poll: Remove and return the top element
        while(!pq.isEmpty()){
            System.out.println("Processing: " + pq.poll());
        }
    }
}
