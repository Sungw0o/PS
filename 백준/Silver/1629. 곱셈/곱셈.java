import java.io.*;
import java.util.*;

public class Main {

    static long A, B, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    static long pow(long a, long b) {
        if (b == 1) return a % C;

        long half = pow(a, b / 2);

        long result = (half * half) % C;

        if (b % 2 == 1) {
            result = (result * a) % C;
        }

        return result;
    }
}