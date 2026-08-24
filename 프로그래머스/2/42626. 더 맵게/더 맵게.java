import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int n : scoville) {
            pq.add(n);
        }
        
        int cnt = 0;
        
        // 1. 가장 작은 값이 K 이상이면 더 섞을 필요가 없음
        // 2. 큐에 데이터가 2개 이상 있을 때만 섞기 가능 (1개만 남았는데 K 미만이면 -1 반환해야 하므로)
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1; // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우
            }
            
            int a = pq.poll(); // 가장 안 매운 음식
            int b = pq.poll(); // 두 번째로 안 매운 음식
            
            // 섞은 음식의 스코빌 지수 계산 (가장 안 매운 음식 + (두 번째로 안 매운 음식 * 2))
            int mixed = a + (b * 2);
            pq.add(mixed);
            
            cnt++;
        }
        
        return cnt;
    }
}