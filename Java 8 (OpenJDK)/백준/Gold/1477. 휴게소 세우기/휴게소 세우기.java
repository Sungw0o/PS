import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, L, ans;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		arr = new int[N + 2];

		if (N > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
		}

		arr[N + 1] = L;

		// 정렬되서 입력된다는 보장이 없음
		Arrays.sort(arr);

		System.out.println(find());
		br.close();
	}

	public static int find() {

		int left = 1;
		int right = L - 1;
		int ans = 0;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (isValid(mid)) {
				ans = mid;
				right = mid - 1;
			}

			else {
				left = mid + 1;
			}
		}

		return ans;
	}

	public static boolean isValid(int mid) {
		int count = 0;
		int lastInstalled = arr[0];

		for (int i = 1; i < arr.length; i++) {
			int dist = arr[i] - arr[i - 1];

			if (dist > mid) {
				count += (dist - 1) / mid;
			}
		}

		return count <= M;
	}
}
