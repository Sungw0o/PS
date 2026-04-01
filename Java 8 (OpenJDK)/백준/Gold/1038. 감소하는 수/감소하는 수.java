import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	private static List<Long> list;
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();

		if (N <= 10) {
			System.out.println(N);
			return;
		}

		else if (N >= 1023) {
			System.out.println(-1);
			return;
		}

		for (long i = 0; i < 10; i++) {
			dfs(i, 1);
		}

		Collections.sort(list);
		System.out.println(list.get(N));
		br.close();

	}

	public static void dfs(Long num, int idx) {
		if (idx > 10)
			return;

		list.add(num);

		for (int i = 0; i < num % 10; i++) {
			dfs((num * 10) + i, idx + 1);
		}
	}
}
