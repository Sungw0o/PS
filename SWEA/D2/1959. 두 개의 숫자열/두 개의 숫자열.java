import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int T = Integer.parseInt(br.readLine());

            for (int test_case = 1; test_case <= T; test_case++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());
                int[] aList = new int[N];
                int[] bList = new int[M];

                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < N; i++) {
                    aList[i] = Integer.parseInt(st.nextToken());
                }

                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    bList[j] = Integer.parseInt(st.nextToken());
                }

                int maxSum = calcList(aList, bList);
                sb.append("#").append(test_case).append(" ").append(maxSum).append("\n");
            }
            System.out.print(sb.toString());
            br.close();
        }

        private static int calcList(int[] a, int[] b) {
            int maxSum = 0;
            if (a.length <= b.length) {
                maxSum = getMaxSum(a, b);
            } else {
                maxSum = getMaxSum(b, a);
            }
            return maxSum;
        }

        private static int getMaxSum(int[] shorter, int[] longer) {
            int maxSum = Integer.MIN_VALUE;
            for (int start = 0; start <= longer.length - shorter.length; start++) {
                int currentSum = 0;
                for (int i = 0; i < shorter.length; i++) {
                    currentSum += shorter[i] * longer[i + start];
                }
                maxSum = Math.max(maxSum, currentSum);
            }
            return maxSum;
        }
    }