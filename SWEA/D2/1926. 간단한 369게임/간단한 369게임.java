import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            String num = String.valueOf(i);
            int clapCount = 0;

            for (int j = 0; j < num.length(); j++) {
                char digit = num.charAt(j);
                // 숫자가 '3', '6', '9' 중 하나를 포함하고 있다면 박수 횟수를 증가
                if (digit == '3' || digit == '6' || digit == '9') {
                    clapCount++;
                }
            }

            if (clapCount > 0) {
                // 박수 횟수에 따라 '-'를 연속적으로 출력
                while (clapCount-- > 0) {
                    sb.append('-');
                }
            } else {
               
                sb.append(i);
            }
            sb.append(' '); 
        }

        System.out.println(sb); 
        sc.close();
    }
}
