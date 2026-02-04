import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static final int noc = 9;

    private static int[] kyuCards = new int[noc];
    private static int[] inCards = new int[noc];
    private static boolean[] visited;
    
    private static int winCount, loseCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean[] isKyu = new boolean[19];
            
            for (int i = 0; i < 9; i++) {
                kyuCards[i] = Integer.parseInt(st.nextToken());
                isKyu[kyuCards[i]] = true;
            }

            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!isKyu[i]) {
                    inCards[idx++] = i;
                }
            }

            winCount = 0;
            loseCount = 0;
            visited = new boolean[noc];

            dfs(0, 0, 0);

            sb.append("#").append(t).append(" ")
              .append(winCount).append(" ").append(loseCount).append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }

    public static void dfs(int round, int kyuSum, int inSum) {
        if (round == noc) {
            if (kyuSum > inSum) winCount++;
            else if (kyuSum < inSum) loseCount++;
            return;
        }

        for (int i = 0; i < noc; i++) {
            if (!visited[i]) {
                visited[i] = true;
                
                int kyu = kyuCards[round];
                int in = inCards[i];
                
                if (kyu > in) {
                    dfs(round + 1, kyuSum + kyu + in, inSum);
                } else {
                    dfs(round + 1, kyuSum, inSum + kyu + in);
                }
                
                visited[i] = false;
            }
        }
    }
}