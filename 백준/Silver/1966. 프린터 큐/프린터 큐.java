import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            StringTokenizer nm = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(nm.nextToken());
            int M = Integer.parseInt(nm.nextToken());

            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<int[]> deque = new ArrayDeque<>();
            for (int j = 0; j < N; j++) {
                deque.add(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            int cnt =0;
            while(true){
                int[] doc= deque.removeFirst();
                if(deque.stream().anyMatch(d -> d[1]> doc[1])){
                    deque.addLast(doc);
                }
                else{
                    cnt++;
                    if(doc[0] == M){
                        sb.append(cnt).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
