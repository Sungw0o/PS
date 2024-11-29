import java.util.*;

class Solution {
    private int minTotalWaitTime = Integer.MAX_VALUE;

    public int solution(int k, int n, int[][] reqs) {
        List<Mentee> mentees = initializeMentees(reqs);

        int[] mentors = new int[k];
        Arrays.fill(mentors, 1); 
        n -= k; 
        backtrack(mentors, mentees, n, 0);

        return minTotalWaitTime;
    }

    private List<Mentee> initializeMentees(int[][] reqs) {
        List<Mentee> mentees = new ArrayList<>();
        for (int[] req : reqs) {
            mentees.add(new Mentee(req[0], req[1], req[2] - 1));
        }
        return mentees;
    }

    private void backtrack(int[] mentors, List<Mentee> mentees, int remaining, int index) {
        if (index == mentors.length) {
            if (remaining == 0) {
                int waitTime = calculateWaitTime(mentors, mentees);
                minTotalWaitTime = Math.min(minTotalWaitTime, waitTime);
            }
            return;
        }

        for (int i = 0; i <= remaining; i++) {
            mentors[index] += i;
            backtrack(mentors, mentees, remaining - i, index + 1);
            mentors[index] -= i;
        }
    }

    private int calculateWaitTime(int[] mentors, List<Mentee> mentees) {
        PriorityQueue<Integer>[] mentorQueues = new PriorityQueue[mentors.length];
        for (int i = 0; i < mentors.length; i++) {
            mentorQueues[i] = new PriorityQueue<>();
            for (int j = 0; j < mentors[i]; j++) {
                mentorQueues[i].add(0);
            }
        }

        int totalWaitTime = 0;

        for (Mentee mentee : mentees) {
            int category = mentee.category;
            PriorityQueue<Integer> queue = mentorQueues[category];

            int earliestEndTime = queue.poll();
            int waitTime = Math.max(0, earliestEndTime - mentee.sTime);
            totalWaitTime += waitTime;

            queue.add(Math.max(earliestEndTime, mentee.sTime) + mentee.eTime);
        }

        return totalWaitTime;
    }

    static class Mentee {
        int sTime;
        int eTime;
        int category;

        public Mentee(int sTime, int eTime, int category) {
            this.sTime = sTime;
            this.eTime = eTime;
            this.category = category;
        }
    }
}
