import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, S;
    private static int[] arr, tree;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        
        arr[0] = Integer.MAX_VALUE; 
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        init(N);
        
        M = Integer.parseInt(br.readLine()); 
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            
            if(cmd == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                
                arr[idx] = val;
                update(idx);
                
            } else if (cmd == 2) {
                sb.append(tree[1]).append("\n");
            }
        }
        
        System.out.print(sb);
    }
    
    public static void init(int N) {
        S = 1;
        while(S < N) {
            S *= 2;
        }
        
        tree = new int[S * 2];
        
        for (int i = 1; i <= N; i++) {
            tree[S + i - 1] = i; 
        }

        for (int i = S - 1; i >= 1; i--) {
            tree[i] = getWinner(tree[i * 2], tree[i * 2 + 1]);
        }
    }
    
    public static void update(int idx) {
        int node = (S + idx - 1) / 2; 
        
        while(node > 0) {
            tree[node] = getWinner(tree[node * 2], tree[node * 2 + 1]);
            node /= 2; // 조부모로 이동
        }
    }
    
    private static int getWinner(int idx1, int idx2) {
        if (arr[idx1] < arr[idx2]) return idx1;
        else if (arr[idx1] > arr[idx2]) return idx2;
        else return Math.min(idx1, idx2); 
    }
}