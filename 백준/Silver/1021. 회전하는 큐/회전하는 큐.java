import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        int answer = 0;

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            answer += rotate(deque, target);
        }

        System.out.println(answer);
        br.close();
    }

    private static int rotate(Deque<Integer> deque, int target) {

        int index = 0;
        for (int value : deque) {
            if (value == target) break;
            index++;
        }

        int leftMoves = index;
        int rightMoves = deque.size() - index;

        if (leftMoves <= rightMoves) {
            for (int i = 0; i < leftMoves; i++) {
                deque.addLast(deque.removeFirst());
            }
            deque.removeFirst();
            return leftMoves;
        } else {
            for (int i = 0; i < rightMoves; i++) {
                deque.addFirst(deque.removeLast());
            }
            deque.removeFirst();
            return rightMoves;
        }
    }
}
