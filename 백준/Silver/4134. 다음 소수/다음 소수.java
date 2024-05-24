import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (long i = 0; i < n; i++) {
            long a = sc.nextLong();
            while (true) {
                long count = 0;
                for (long j = 2; j <= Math.sqrt(a); j++) {
                    if (a % j == 0) {
                        count++;
                        break;
                    }
                }
                if (count == 0) {
                    if (a == 0 || a == 1) {
                        a = 2;
                    }
                    System.out.println(a);
                    break;
                }
                a++;
            }
        }

        sc.close();
    }
}
