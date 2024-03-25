

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "push":
                    queue.add(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    if (!queue.isEmpty()) System.out.println(queue.poll());
                    else System.out.println("-1");
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? "1" : "0");
                    break;
                case "front":
                    if (!queue.isEmpty()) System.out.println(queue.element());
                    else System.out.println("-1");
                    break;
                case "back":
                    if (!queue.isEmpty()) {
                        Integer last = null;
                        for (Integer element : queue) {
                            last = element;
                        }
                        System.out.println(last);
                    } else {
                        System.out.println("-1");
                    }
                    break;
            }
        }
        br.close();
    }
}
