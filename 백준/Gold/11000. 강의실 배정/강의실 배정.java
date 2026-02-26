import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0].endTime);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lectures[i].startTime) {
                pq.poll();
            }
            pq.offer(lectures[i].endTime);
        }

        System.out.println(pq.size());
        br.close();
    }

    static class Lecture implements Comparable<Lecture> {
        int startTime;
        int endTime;

        public Lecture(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.startTime == o.startTime) {
                return Integer.compare(this.endTime, o.endTime);
            }
            return Integer.compare(this.startTime, o.startTime);
        }
    }
}