import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] lis = new int[N];
        int[] record = new int[N];
        int len = 0;
        
        for (int i = 0; i < N; i++) {
            int key = A[i];
            
            int left = 0;
            int right = len - 1;
            
            while (left <= right) {
                int mid = (left + right) / 2;
                if (lis[mid] < key) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            lis[left] = key;
            record[i] = left;
            
            if (left == len) {
                len++;
            }
        }
        
        System.out.println(len);
        
        int[] ans = new int[len];
        int idx = len - 1;
        
        for (int i = N - 1; i >= 0; i--) {
            if (record[i] == idx) {
                ans[idx] = A[i];
                idx--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}