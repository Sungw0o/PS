import java.util.Scanner;

class Solution {
        public static void main(String args[]) throws Exception {

            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt(); 
            for (int test_case = 1; test_case <= T; test_case++) {
                int money = sc.nextInt(); 
                System.out.println("#" + test_case);
                System.out.println(charge(money));
            }
            sc.close();
        }

        public static String charge(int money){
            int[] denominations = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
            int[] count = new int[denominations.length];

            for (int i = 0; i < denominations.length; i++) {
                count[i] = money / denominations[i];
                money %= denominations[i];
            }

            StringBuilder result = new StringBuilder();
            for (int num : count) {
                result.append(num).append(" ");
            }

            return result.toString().trim();
        }
    }