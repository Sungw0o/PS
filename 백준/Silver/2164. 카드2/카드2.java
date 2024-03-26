

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Deque<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            queue.add(i);
        }
        while(true){
            int count = queue.size();
            if(count==1){
                System.out.println(queue.getFirst());
                break;
            }
            queue.pollFirst();
            int k = queue.getFirst();
            queue.addLast(k);
            queue.removeFirst();

        }
    }
}
