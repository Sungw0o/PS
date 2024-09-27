import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static class Lecture implements Comparable<Lecture>{
        private int startTime;
        private int endTime;

        public Lecture(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        @Override
        public int compareTo(Lecture other) {
            return Integer.compare(this.startTime, other.startTime);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N];
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int startTime = Integer.parseInt(input[0]);
            int endTime = Integer.parseInt(input[1]);
            lectures[i] = new Lecture(startTime, endTime);
        }

        Arrays.sort(lectures);

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(lectures[0].getEndTime());

        for (int i = 1; i < N; i++) {

            if (lectures[i].getStartTime() >= queue.peek()) {
                queue.poll();
            }
            queue.add(lectures[i].getEndTime());
        }
        
        System.out.println(queue.size());
    }
}
