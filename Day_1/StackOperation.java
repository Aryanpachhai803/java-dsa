package Day_1;

import java.util.Scanner;

public class StackOperation {   
        static final int MAX =100; // Maximum size of the stack
        static int[] stack = new int[MAX];
        static int top =-1;

        //Check if stack is empty
        static boolean isEmpty(){
            return top<0;
        }

        //Check if stack is full
        static boolean isFull(){
            return top>=MAX-1;
        }

        //Check the size of the stack 
        static int stackSize(){
            return top+1;
        }


        //PUSH Operation
        static void push(int element){
            if(isFull()){
                System.out.println("Stack is full");
                return;
            }

            stack[++top] = element;
            System.out.println("The pushed element in the stack is: " + element);
        }

        //POP Operation
        static int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int element = stack[top--];
            System.out.println("The popped element is: " + element);
            return element;
        }

        //PEEK Operation
        static int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int element = stack[top];
            return element;
        }

        //Display Operation
        static void display(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return;
            }
            System.out.println("Elements in stack:");
            for (int element=top;element>=0;element--){
                System.out.println(stack[element]);
                
            }
        }  

        
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);

            while(true){
                System.out.println("=====Stack Menu=====");
                System.out.println("1. Is stack empty");
                System.out.println("2. Is stack full");
                System.out.println("3. Stack Size");
                System.out.println("4. Push");
                System.out.println("5. Pop");
                System.out.println("6. Peek");
                System.out.println("7. Display all element");
                System.out.println("8. Exit");

                int choice = sc.nextInt();
                
                switch(choice){
                    case 1:
                        isEmpty();
                        System.out.println("Is stack empty? " + isEmpty());
                        break;
                    
                    case 2:
                        isFull();
                        System.out.println("Is stack full? " + isFull());
                        break;

                    case 3:
                        stackSize();
                        System.out.println("Stack size: " + stackSize());
                        break;
                        
                    case 4:
                        System.out.println("Enter the element: ");
                        int element = sc.nextInt();
                        push(element);
                        break;
                    
                    case 5:
                        pop();
                        break;
                    
                    case 6:
                        peek();
                        System.out.println("Peek element: " + peek() );
                        break;
                    
                    case 7:
                        display();
                        break;
                    
                    case 8:
                        System.out.println("Thank you. Exiting.....");
                        sc.close();
                        return;
   

                    default:
                        System.out.println("Invalid choose. Try again");    
                }
            }
        }
}
