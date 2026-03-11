package Day_11;

public class FibonacciSeries {
    static int fib(int n){
        if(n <= 1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {
        int num = 5;
        for(int i=0;i<num;i++){
            System.out.println(fib(i));
        }
    }
}
