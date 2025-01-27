
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();

        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i< M;i++){
            int element = Integer.parseInt(st.nextToken());
            ans += rotation(deque, element);
        }

        System.out.println(ans);
        br.close();
    }

    public static int rotation(Deque<Integer> deque, int target){

        int mvCnt = 0;

        for(int element : deque){
            if(element == target){
                break;
            }
            mvCnt++;
        }

        int left = mvCnt;
        int right = deque.size() - mvCnt;

        if (left <= right) { 
            for (int i = 0; i < left; i++) {
                deque.addLast(deque.removeFirst());
            }
            deque.removeFirst();
            return left;
        }

        else {
            for (int i = 0; i < right; i++) {
                deque.addFirst(deque.removeLast());
            }
            deque.removeFirst();
            return right;
        }

    }
}
