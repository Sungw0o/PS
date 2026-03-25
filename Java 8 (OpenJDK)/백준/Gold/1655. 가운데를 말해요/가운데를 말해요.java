import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	private static int N;

	private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (maxHeap.size() == minHeap.size()) {
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}


			if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
				int leftMax = maxHeap.poll();
				int rightMin = minHeap.poll();

				maxHeap.add(rightMin);
				minHeap.add(leftMax);
			}

			sb.append(maxHeap.peek()).append("\n");
		}

		System.out.print(sb);
		br.close();
	}
}