class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int stone : stones){
                pq.add(stone);
            }

            while(pq.size() > 1){
                int firstStone = pq.poll();
                int secondStone = pq.poll();
                int newStone = compareStone(firstStone,secondStone);
                if(newStone != 0)
                    pq.offer(newStone);

            }
            return pq.isEmpty() ? 0 : pq.peek();
        }
        public int compareStone(int firstStone, int secondStone){
            if(firstStone == secondStone){
                return 0;
            }
            else{
                return Math.max(firstStone,secondStone) - Math.min(firstStone,secondStone);
            }
        }
    }
