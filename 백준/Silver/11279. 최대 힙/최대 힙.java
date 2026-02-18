import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    private static int N,x;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for(int i= 0; i < N ;i++){
            x = Integer.parseInt(br.readLine());
            if(x != 0){
                queue.add(x);
            }
            else{
                if(queue.isEmpty()){
                    sb.append(0).append("\n");
                }
                else{
                    sb.append(queue.poll()).append("\n");
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}
