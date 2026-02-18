import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N,l,r,ans1,ans2;
    private static int minAbs = Integer.MAX_VALUE;
    private static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){

            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        l = 0;
        r = N - 1;
        
        while(l < r){
            
            int sum = arr[l] + arr[r];
            
            if(Math.abs(sum) < minAbs){
                minAbs = Math.abs(sum);
                ans1 = arr[l];
                ans2 = arr[r];
            }
            
            if(sum == 0){
                break;
            }
            if(sum < 0){
                l++;
            }
            else{
                r--;
            }
        }
        System.out.println(ans1+" "+ans2);
        br.close();
    }
}
