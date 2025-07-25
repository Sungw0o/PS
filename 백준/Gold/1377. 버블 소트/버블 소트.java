import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static class Num implements Comparable<Num> {
        int value;
        int index;

        Num(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Num o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Num[] arr = new Num[N];

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = new Num(value, i);
        }

        Arrays.sort(arr);  
        
        int maxDiff = 0;
        for (int i = 0; i < N; i++) {
            int move = arr[i].index - i;
            if (move > maxDiff) {
                maxDiff = move;
            }
        }

        System.out.println(maxDiff + 1);
        br.close();
    }
}
