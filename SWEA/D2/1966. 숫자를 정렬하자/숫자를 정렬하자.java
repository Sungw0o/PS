import java.util.Arrays;
import java.util.Scanner;

class Solution {
        public static void main(String args[]) throws Exception {

            Scanner sc = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();
            int T;
            T = sc.nextInt();
            for (int test_case = 1; test_case <= T; test_case++) {
                int N = sc.nextInt();
                int[] list = new int[N];

                for (int i = 0; i < N; i++) {
                    list[i] = sc.nextInt();
                }
                Arrays.sort(list);
                System.out.print("#" + test_case + " ");
                for (int num : list) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            sc.close();
        }
    }