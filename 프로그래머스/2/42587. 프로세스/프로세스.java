import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int priority : priorities) {
                pq.add(priority);
            }

            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < priorities.length; i++) {
                queue.add(new int[]{priorities[i], i});
            }

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                if (cur[0] == pq.peek()) {
                    pq.poll();
                    answer++;
                    if (cur[1] == location) {
                        return answer;
                    }
                }
                else {
                    queue.add(cur);
                }
            }
            return answer;
        }
    }