import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        sc.nextLine(); 
        
        for (int test_case = 1; test_case <= T; test_case++) {
            String str = sc.nextLine().trim(); 
            String revStr = new StringBuilder(str).reverse().toString(); 
            
            if (str.equals(revStr)) {
                sb.append("#").append(test_case).append(" 1\n"); 
            } else {
                sb.append("#").append(test_case).append(" 0\n"); 
            }
        }
        
        System.out.println(sb); 
        sc.close();
    }
}
