import java.util.*;

class Solution {
    private int minTotalWaitTime = Integer.MAX_VALUE;

    public int solution(int k, int n, int[][] reqs) {
        List<Mentee> mentees = initializeMentees(reqs);

        Mentor[] mentors = new Mentor[k];
        for (int i = 0; i < k; i++) {
            mentors[i] = new Mentor(i, 1); 
        }

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

    private void backtrack(Mentor[] mentors, List<Mentee> mentees, int remaining, int index) {
        if (index == mentors.length) {
            if (remaining == 0) {
                int waitTime = calculateWaitTime(mentors, mentees);
                minTotalWaitTime = Math.min(minTotalWaitTime, waitTime);
            }
            return;
        }

        for (int i = 0; i <= remaining; i++) {
            mentors[index].addMentors(i);
            backtrack(mentors, mentees, remaining - i, index + 1);
            mentors[index].removeMentors(i);
        }
    }

    private int calculateWaitTime(Mentor[] mentors, List<Mentee> mentees) {
        for (Mentor mentor : mentors) {
            mentor.resetQueue();
        }

        int totalWaitTime = 0;

        for (Mentee mentee : mentees) {
            Mentor mentor = mentors[mentee.category];

            int waitTime = mentor.assignMentee(mentee.sTime, mentee.eTime);
            totalWaitTime += waitTime;
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

    static class Mentor {
        int category;
        int count;
        PriorityQueue<Integer> queue;

        public Mentor(int category, int count) {
            this.category = category;
            this.count = count;
            this.queue = new PriorityQueue<>();
            for (int i = 0; i < count; i++) {
                queue.add(0);
            }
        }

        public void addMentors(int additionalCount) {
            for (int i = 0; i < additionalCount; i++) {
                queue.add(0);
            }
            count += additionalCount;
        }

        public void removeMentors(int countToRemove) {
            count -= countToRemove;
            for (int i = 0; i < countToRemove; i++) {
                queue.poll();
            }
        }

        public void resetQueue() {
            queue.clear();
            for (int i = 0; i < count; i++) {
                queue.add(0);
            }
        }

        public int assignMentee(int sTime, int eTime) {
            int earliestEndTime = queue.poll();
            int waitTime = Math.max(0, earliestEndTime - sTime);
            queue.add(Math.max(earliestEndTime, sTime) + eTime);
            return waitTime;
        }
    }
}
