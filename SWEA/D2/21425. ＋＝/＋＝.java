import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long N = sc.nextLong();
            
            int count = 0;
            while (x <= N && y <= N) {
                if (x < y) {
                    x += y;
                } else {
                    y += x;
                }
                count++;
            }
            
            System.out.println(count);
        }
        sc.close();
    }
}