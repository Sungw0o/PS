

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        while(n>=5){
            sum += n / 5;
            n /=5;
        }
        System.out.println(sum);


    }
}
