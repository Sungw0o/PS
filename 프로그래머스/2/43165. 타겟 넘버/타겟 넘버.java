import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>(); 
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int depth = current[0];
            int value = current[1];

            
            if (depth == numbers.length) {
                if (value == target) {
                    answer++;
                }
            } else {
                q.offer(new int[]{depth + 1, value + numbers[depth]});
                q.offer(new int[]{depth + 1, value - numbers[depth]});
            }
        }
        return answer;
    }
}
