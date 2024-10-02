import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


class Solution {
        public int solution(int[][] jobs) {
            Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

            PriorityQueue<int[]> scheduler = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

            int time = 0; 
            int idx = 0;
            int totalTime = 0;
            int count = 0;

            while (count < jobs.length) {
                while (idx < jobs.length && jobs[idx][0] <= time) {
                    scheduler.add(jobs[idx]);
                    idx++;
                }

                if (scheduler.isEmpty()) {
                    time = jobs[idx][0];
                } else {
                    int[] currentJob = scheduler.poll();
                    time += currentJob[1]; 
                    totalTime += time - currentJob[0]; 
                    count++;
                }
            }

            return totalTime / jobs.length; 
        }
    }