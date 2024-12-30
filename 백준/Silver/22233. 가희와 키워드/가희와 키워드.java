import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> memoKeywords = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            memoKeywords.add(br.readLine());
        }
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()) {
                String word = st.nextToken();
                if(memoKeywords.contains(word)) memoKeywords.remove(word);
            }
            sb.append(memoKeywords.size()).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
