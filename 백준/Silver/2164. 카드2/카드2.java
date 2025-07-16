import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> cards = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            cards.addLast(i);
        }

        while(cards.size() > 1) {
            cards.removeFirst();
            int temp = cards.removeFirst();
            cards.addLast(temp);
        }

        System.out.println(cards.removeFirst());
        br.close();
    }
}
