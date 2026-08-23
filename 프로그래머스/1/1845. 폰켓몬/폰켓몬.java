import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int maxPick = nums.length / 2;
        
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums){
            set.add(num);
        }
        
        
        return Math.min(set.size(), maxPick);
    }
}