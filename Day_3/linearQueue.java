package Day_3;

// import java.util.Queue;
import java.util.Scanner;

public class linearQueue {
    

    static int N = 10; //Maximum size of a queue
    static int[] queue = new int[N];
    static int F = -1;
    static int R = -1;

    //Method to check if the queue is FULL
    public static boolean isFull(){
        if (R  == N-1){
            return true;
        }
        else{
            return false;
        }
    }

    //Method to check if the queue is EMPTY
    public static boolean isEmpty(){
        if(F == -1 || F>R){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * ENQUEUE Operation
     * Logical if(isFULL()) write Overflow
     */
    public static void enqueue(int ITEM){
        //Check if the queue is full
        if(isFull()){
            System.out.println("Overflow: Queue is full");
            return;
        }

        //Check if it is the first element
        if(F == -1){
            F=0;
            R=0;
        }
        else{
            //Increment rear
            R = R+1;
        }

        queue[R] = ITEM;
        System.out.println(ITEM + " is inserted successfully");
    }


    //DEQUEUE Operation
    public static void dequeue(){
        if(isEmpty()){
            System.out.println("Underflow: Queue is empty");
            return;
        }

        int ITEM = queue[F];

        //Reset pointers if the last element is removed
        if(F == R){
            F = -1;
            R = -1;
        }
        else{
            F = F+1;
        }

        System.out.println(ITEM + "is deleted");
    }

    //Display Operation
    public static void display(){
        if(isEmpty()){
            System.out.println("Underflow");
            return;
        }
        System.out.println("Element in queue:");
        for(int ITEM=F;ITEM<=R;ITEM++){
            System.out.println(queue[ITEM]);
        }
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("=====Queue Menu=====");
            System.out.println("1. Is queue empty");
            System.out.println("2. Is queue full");
            System.out.println("3. Enqueue (Add)");
            System.out.println("4. Dequeue (Remove)");
            System.out.println("5. Display elements in queue");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    isEmpty();
                    System.out.println("Is queue empty? " + isEmpty());
                    break;

                case 2:
                    isFull();
                    System.out.println("Is queue full? " + isFull());
                    break;
                    
                case 3:
                    System.out.println("Enter the element");
                    int element = sc.nextInt();
                    enqueue(element);
                    break;
                    
                case 4:
                    dequeue();
                    break;
                    
                case 5:
                    display();
                    break;
                    
                case 6:
                    System.out.println("Exiting");
                    System.exit(0);
                    sc.close();
                    
                default:
                    System.out.println("Invalid choice. Try again");    
            }
        }

    }
}


