import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        String[] aInput = br.readLine().split(" ");
        for (String num : aInput) {
            A.add(Integer.parseInt(num));
        }
        String[] bInput = br.readLine().split(" ");
        for (String num : bInput) {
            B.add(Integer.parseInt(num));
        }

        System.out.println(multiArr(A,B));
        br.close();

    }

    public static int multiArr(ArrayList<Integer> A, ArrayList<Integer> B){
        int sum = 0;

        for(int i=0;i<N;i++){
            int min = Collections.min(A);
            int max=  Collections.max(B);

            sum += (min * max);

            A.remove(Integer.valueOf(min));
            B.remove(Integer.valueOf(max));
        }

        return sum;
    }
}
