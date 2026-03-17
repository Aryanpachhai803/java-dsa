package Day_12;
import java.util.Scanner;

public class PalindromeChecker {
    static boolean Palindrome(String s,int start,int end){
        if(start>=end){
            return true;
        }
        if(s.charAt(start) != s.charAt(end)){
            return false;
        }
        return Palindrome(s, start +1, end-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word:");
        String input = sc.nextLine();

        boolean result = Palindrome(input,0,input.length()-1);
        if(result){
            System.out.println("It is a Palindrome");
        }
        else{
            System.out.println("It isnot a Palindrome");
        }
        sc.close();
    }   
}
