import java.util.PriorityQueue;

class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int foods : scoville){
                pq.offer(foods);
            }
            while(pq.size()> 1 && pq.peek()< K){
                int first = pq.poll();
                int second = pq.poll();

                int newScoville = first + (second * 2);
                pq.offer(newScoville);

                answer++;
            }
            return pq.peek() < K ? -1 : answer;
        }
    }