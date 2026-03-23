import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] arr;
	private static int[] diffArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		diffArr = new int[N + 2];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			diffArr[a] += k;
			diffArr[b + 1] -= k;
		}

		for (int i = 1; i <= N; i++) {
			diffArr[i] += diffArr[i - 1];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			arr[i] += diffArr[i];
			sb.append(arr[i]).append(" ");
		}

		System.out.println(sb.toString().trim());
	}
}