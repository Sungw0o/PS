

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "push_back":
                    deque.addLast(Integer.parseInt(command[1]));
                    break;
                case "push_front":
                    deque.addFirst(Integer.parseInt(command[1]));
                    break;
                case "pop_front":
                    if (deque.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(deque.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    if (deque.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(deque.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    sb.append(deque.isEmpty() ? "-1\n" : deque.peekFirst() + "\n");
                    break;
                case "back":
                    sb.append(deque.isEmpty() ? "-1\n" : deque.peekLast() + "\n");
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}
