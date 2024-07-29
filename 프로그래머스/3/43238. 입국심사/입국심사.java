import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 1, right = (long) n * times[times.length - 1];
        long answer =0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long total = 0;
            for (int t : times) total += mid / t;

            if (total >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}