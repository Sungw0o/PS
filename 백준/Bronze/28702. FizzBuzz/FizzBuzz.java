import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            String s = sc.next();
            
            if (Character.isDigit(s.charAt(0))) {
                int nextNum = Integer.parseInt(s) + (3 - i);
                
                if (nextNum % 3 == 0 && nextNum % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (nextNum % 3 == 0) {
                    System.out.println("Fizz");
                } else if (nextNum % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(nextNum);
                }
                return;
            }
        }
    }
}