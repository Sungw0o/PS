import java.util.Scanner;

class Solution
    {
        public static void main(String args[]) throws Exception
        {

            Scanner sc = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();
            int T;
            T=sc.nextInt();


            for(int test_case = 1; test_case <= T; test_case++)
            {
                int P = sc.nextInt();
                int Q = sc.nextInt();
                int R = sc.nextInt();
                int S = sc.nextInt();
                int W = sc.nextInt();
                sb.append("#"+test_case+" "+calcCharge(P,Q,R,S,W)+"\n");
            }
            sc.close();
            System.out.println(sb);

        }

        public static int calcCharge(int P, int Q, int R, int S, int W){
            int comA = W * P;
            int comB = Q + ((W > R) ? (W - R) * S : 0);

            return Math.min(comA, comB);
        }
    }