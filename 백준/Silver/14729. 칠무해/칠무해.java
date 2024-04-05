

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        for(int i=0;i<n;i++){
            arr[i] = Double.parseDouble(br.readLine());
        }
        Arrays.sort(arr);

        DecimalFormat df = new DecimalFormat("0.000"); // 출력 형식 지정

        for(int i=0;i<7;i++){
            System.out.println(df.format(arr[i])); // 형식에 맞게 출력
        }
    }
}
