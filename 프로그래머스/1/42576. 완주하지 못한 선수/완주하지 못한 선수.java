import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> count = new HashMap<>();
        for(String name : participant){
            count.put(name, count.getOrDefault(name,0) +1);
        }
        
        for(String name : completion){
            count.put(name, count.get(name)-1);
        }
        
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() > 0) return entry.getKey();
        }
        return ""; 
    }
}