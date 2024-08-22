import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] homeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        homeList = new int[N];
        for(int i=0;i<N;i++){
            homeList[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homeList);

        System.out.println(binarySearch());
    }

    static int binarySearch(){
        int left = 1;
        int right = homeList[N-1] - homeList[0];
        int d,ans = 0;

        while(left<=right){
            int mid = (left+right)/2;
            int start = homeList[0];
            int count =1;
            for(int i=1;i<N;i++){
                d = homeList[i] - start;
                if(d>=mid){
                    count++;
                    start = homeList[i];
                }
            }
            if (count >= M) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1; 
            }
        }
        return ans;
    }

}