
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N,M;

    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        makeset(N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd  = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(cmd==0){

                union(a,b);
            }

            else if(cmd==1){
                String str =  find(a) == find(b) ? "YES" : "NO";

                sb.append(str).append("\n");
            }

        }
        System.out.println(sb);
        br.close();
    }

    public static void makeset(int n){

        parents = new int[n+1];

        for(int i = 1; i <= n; i++){
            parents[i] = i;
        }

    }

    public static int find(int x){

        if(parents[x] == x){
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    public static boolean union(int a, int b){

        int rA = find(a);
        int rB = find(b);

        if(rA == rB){
            return false;
        }

        parents[rB] = rA;

        return true;



    }
}
