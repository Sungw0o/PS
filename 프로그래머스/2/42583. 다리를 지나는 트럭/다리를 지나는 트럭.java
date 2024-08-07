import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int totalWeight = 0;
        
        for (int truck : truck_weights) {
            while (true) {
                answer++;
                if (queue.size() == bridge_length) {
                    totalWeight -= queue.poll();
                }
                if (totalWeight + truck <= weight) {
                    queue.offer(truck);
                    totalWeight += truck;
                    break;
                } else {
                    queue.offer(0);
                }
            }
        }    
        
        return answer + bridge_length;
    }
}
