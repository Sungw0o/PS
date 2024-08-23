import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        int left = 1;
        int right = distance;
        
        Arrays.sort(rocks);
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int prev = 0;
            int remove = 0;
            
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    remove++; 
                } else {
                    prev = rocks[i];
                }
            }
            
            if (distance - prev < mid) {
                remove++; 
            }
              
            if (remove > n) {
                right = mid - 1; 
            } else {
                answer = mid; 
                left = mid + 1; 
            }
        }
        return answer;
    }
}
