import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();  
            int sum = 0;
            for (int j = 1; j <= N; j++) {  
                if (j % 2 == 0) {
                    sum -= j; 
                } else {
                    sum += j;  
                }
            }
           
            sb.append("#").append(test_case).append(" ").append(sum).append("\n");
        }
        System.out.print(sb); 

    }
}
