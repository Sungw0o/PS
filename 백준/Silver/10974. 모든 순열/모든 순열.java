import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] perm = new int[N];
        boolean[] visited = new boolean[N];

        for(int i = 0; i< N; i++){
            arr[i] = i +1;
        }

        backtracking(arr, perm, visited, 0, N, N);
    }

    public static void backtracking(int[] arr, int[] perm, boolean[] visited, int depth, int n, int r){
        if(depth == r){
            print(perm, r);
            return;
        }

        for(int i =0; i< n; i++){
            if(!visited[i]){
                visited[i] = true;
                perm[depth] = arr[i];
                backtracking(arr, perm, visited, depth+1, n, r);
                visited[i] = false;
            }
        }
    }

    public static void print(int[] arr, int r){
        for(int i = 0; i<r; i++)
            System.out.print(arr[i]+ " ");
        System.out.println();
    }
}
