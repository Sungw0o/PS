

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int ones = 0;
        int zeros = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) plus.add(num);
            else if (num == 1) ones++;
            else if (num == 0) zeros++;
            else minus.add(num);
        }

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        long sum = 0;

        for (int i = 0; i < plus.size(); i += 2) {
            if (i + 1 < plus.size()) sum += (long) plus.get(i) * plus.get(i + 1);
            else sum += plus.get(i); 
        }

        for (int i = 0; i < minus.size(); i += 2) {
            if (i + 1 < minus.size()) sum += (long) minus.get(i) * minus.get(i + 1);
            else {

                if (zeros == 0) sum += minus.get(i);
            }
        }

        sum += ones;

        System.out.println(sum);
    }
}