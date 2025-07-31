import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.MAX_VALUE;	

        StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");

        while (subtraction.hasMoreTokens()) {
            int temp = 0;

            StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");
            while (addition.hasMoreTokens()) {
                temp += Integer.parseInt(addition.nextToken());
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp;  
            } else {
                sum -= temp; 
            }
        }

        System.out.println(sum);
        br.close();
    }
}
