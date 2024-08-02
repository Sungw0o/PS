import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,S,M;
    static int[] volume;
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N =Integer.parseInt(st.nextToken());
        S =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());

        dp = new boolean[N+1][M+1];
        volume = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i< volume.length;i++){
            volume[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][S] = true;

        for(int i=0;i<N;i++){
            for(int j=0;j<=M;j++){
                if(dp[i][j]){
                    if (j + volume[i] <= M) {
                        dp[i+1][j + volume[i]] = true;
                    }
                    if (j - volume[i] >= 0) {
                        dp[i+1][j - volume[i]] = true;
                    }
                }
            }
        }

        int maxVolume = -1;
        for (int j = 0; j <= M; j++) {
            if (dp[N][j]) {
                maxVolume = j;
            }
        }

        System.out.println(maxVolume);

        br.close();
    }
}
