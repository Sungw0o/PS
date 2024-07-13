import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
        public int[] solution(int[] prices) {
            int n = prices.length;
            int[] answer = new int[n];
            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                while (!deque.isEmpty() && prices[deque.peekLast()] > prices[i]) {
                    int index = deque.pollLast();
                    answer[index] = i - index;
                }
                deque.offerLast(i);
            }

            while (!deque.isEmpty()) {
                int index = deque.pollLast();
                answer[index] = n - index - 1;
            }

            return answer;
        }
    }