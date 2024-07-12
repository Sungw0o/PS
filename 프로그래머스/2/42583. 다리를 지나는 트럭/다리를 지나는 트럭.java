import java.util.LinkedList;
import java.util.Queue;



class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for (int truck : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.offer(truck);
                    totalWeight += truck;
                    answer++;
                    break;
                } else if (queue.size() == bridge_length) {
                    totalWeight -= queue.poll();
                } else {
                    if (totalWeight + truck <= weight) {
                        queue.offer(truck);
                        totalWeight += truck;
                        answer++;
                        break;
                    } else {
                        queue.offer(0);
                        answer++;
                    }
                }
            }
        }
        
        return answer + bridge_length;
    }
}
