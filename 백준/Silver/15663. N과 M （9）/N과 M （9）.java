import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static int[] sequence;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N]; 
        sequence = new int[M]; 
        visited = new boolean[N]; 

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers); 
        backTracking(0);
    }

    static void backTracking(int x) {
        if (x == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(sequence[i] + " "); 
            }
            System.out.println(); 
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                
                if (i > 0 && numbers[i] == numbers[i - 1] && !visited[i - 1]) continue;

                visited[i] = true;
                sequence[x] = numbers[i]; 
                backTracking(x + 1);
                visited[i] = false; 
            }
        }
    }
}
