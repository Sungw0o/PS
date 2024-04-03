
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int x = sc.nextInt();
        int y = sc.nextInt();
        for(int i=x; i<=y; i++){
            if(isPrime(i)){
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean isPrime(int number){
        if(number < 2) return false;
        for(int j=2; j*j<=number; j++){
            if(number % j == 0) return false;
        }
        return true;
    }
}
