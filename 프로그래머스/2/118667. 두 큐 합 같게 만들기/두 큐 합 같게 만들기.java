import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0, sum2 = 0;
        for (int num : queue1) {
            q1.offer(num);
            sum1 += num;
        }
        for (int num : queue2) {
            q2.offer(num);
            sum2 += num;
        }

        long totalSum = sum1 + sum2;
        if (totalSum % 2 != 0) return -1;

        long targetSum = totalSum / 2;
        int maxOperations = queue1.length * 3; 
        int operations = 0;

        while (operations < maxOperations) {
            if (targetReach(sum1, sum2, targetSum)) return operations;

            if (sum1 > targetSum) {
                int removed = q1.poll(); 
                sum1 -= removed;
                q2.offer(removed); 
                sum2 += removed;
            } else {
                int removed = q2.poll(); 
                sum2 -= removed;
                q1.offer(removed); 
                sum1 += removed; 
            }
            operations++;
        }

        return -1; 
    }
    
    private boolean targetReach(long sum1, long sum2, long targetSum) {
        return sum1 == targetSum && sum2 == targetSum;
    }
}
