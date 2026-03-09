package Day_10;

public class RecursionFactorial {
    static int Factorial(int n){
        if(n == 1 || n == 0){
            return 1;
        }
        return n * Factorial(n -1);
    }
    public static void main(String[] args) {
        int num = 5;
        int result = Factorial(num);
        System.out.println("Factorial: " + result);
    }
}
