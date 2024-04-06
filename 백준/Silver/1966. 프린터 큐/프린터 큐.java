import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 수
            int M = Integer.parseInt(st.nextToken()); // 궁금한 문서의 인덱스

            st = new StringTokenizer(br.readLine());
            Deque<Document> queue = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Document(i, priority));
            }

            int count = 0;
            while (!queue.isEmpty()) {
                Document doc = queue.poll();
                boolean isPrinted = true;
                for (Document d : queue) {
                    if (d.priority > doc.priority) {
                        isPrinted = false;
                        break;
                    }
                }
                if (!isPrinted) {
                    queue.offer(doc);
                } else {
                    count++;
                    if (doc.index == M) {
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }

    static class Document {
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
