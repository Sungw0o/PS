import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] treeLen;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        treeLen = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            treeLen[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(treeLen);
        int answer= binarySearch(treeLen);
        System.out.println(answer);

        br.close();


    }

    static int binarySearch(int[] tree) {
        int left = 0; 
        int right = tree[N - 1];
        int cutter = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long cutTree = 0;

            for (int i = 0; i < N; i++) {
                if (treeLen[i] > mid) {
                    cutTree += treeLen[i] - mid;
                }
            }

            if (cutTree >= M) {
                cutter = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return cutter;
    }
}
