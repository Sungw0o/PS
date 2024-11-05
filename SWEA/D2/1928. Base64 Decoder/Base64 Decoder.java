import java.util.Base64;
import java.util.Scanner; 


class Solution {
        public static void main(String args[]) throws Exception {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt(); 
            sc.nextLine(); 

            StringBuilder sb = new StringBuilder();

            for (int test_case = 1; test_case <= T; test_case++) {
                String encoded = sc.nextLine();
                
                byte[] decodedBytes = Base64.getDecoder().decode(encoded);
                String decodedString = new String(decodedBytes);
                
                sb.append("#").append(test_case).append(" ").append(decodedString).append("\n");
            }

            sc.close();
            System.out.println(sb);
        }
    }
