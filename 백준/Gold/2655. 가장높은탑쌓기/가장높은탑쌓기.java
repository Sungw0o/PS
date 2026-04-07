import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Brick[] bricks = new Brick[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            bricks[i] = new Brick(i + 1, a, h, w);
        }

        Arrays.sort(bricks);

        int[] dp = new int[n];
        int[] prev = new int[n];
        
        int maxHeight = 0;
        int maxIdx = -1;

        for (int i = 0; i < n; i++) {
            dp[i] = bricks[i].h;
            prev[i] = -1;
            
            for (int j = 0; j < i; j++) {
                if (bricks[i].w < bricks[j].w) {
                    if (dp[i] < dp[j] + bricks[i].h) {
                        dp[i] = dp[j] + bricks[i].h;
                        prev[i] = j;
                    }
                }
            }
            
            if (maxHeight < dp[i]) {
                maxHeight = dp[i];
                maxIdx = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int curr = maxIdx;
        
        while (curr != -1) {
            result.add(bricks[curr].id);
            curr = prev[curr];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        
        for (int id : result) {
            sb.append(id).append("\n");
        }
        
        System.out.print(sb);
    }

    static class Brick implements Comparable<Brick> {
        int id, a, h, w;

        public Brick(int id, int a, int h, int w) {
            this.id = id;
            this.a = a;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Brick o) {
            return Integer.compare(o.a, this.a);
        }
    }
}