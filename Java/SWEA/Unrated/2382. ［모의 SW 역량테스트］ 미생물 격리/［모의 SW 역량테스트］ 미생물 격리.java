import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static int T, N, M, K, cnt;

	private static final int UP = 1;
	private static final int DOWN = 2;
	private static final int LEFT = 3;
	private static final int RIGHT = 4;

	private static int[] mR;
	private static int[] mC;
	private static int[] mCnt;
	private static int[] mDir;
	private static int[] mAlive;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cnt = 0;

			mR = new int[K + 1];
			mC = new int[K + 1];
			mCnt = new int[K + 1];
			mDir = new int[K + 1];
			mAlive = new int[K + 1];

			for (int k = 1; k <= K; k++) {
				st = new StringTokenizer(br.readLine());

				mR[k] = Integer.parseInt(st.nextToken());
				mC[k] = Integer.parseInt(st.nextToken());
				mCnt[k] = Integer.parseInt(st.nextToken());
				mDir[k] = Integer.parseInt(st.nextToken());
				mAlive[k] = 1;

			}

			for (int m = 0; m < M; m++) {

				move();
				meetCheck();
			}

			for (int c = 0; c < mCnt.length; c++) {
				if (mAlive[c] == 0)
					continue;

				cnt += mCnt[c];
			}

			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	public static void move() {

		for (int i = 1; i <= K; i++) {
			if (mAlive[i] == 0)
				continue;
			int r = mR[i];
			int c = mC[i];
			int cnt = mCnt[i];
			int dir = mDir[i];
			int alive = mAlive[i];

			if (dir == UP) {
				mR[i]--;

			} else if (dir == DOWN) {
				mR[i]++;
			} else if (dir == LEFT) {
				mC[i]--;
			} else if (dir == RIGHT) {
				mC[i]++;
			}

			if (rangeCheck(mR[i], mC[i])) {
				inMedicine(r, c, i);
			}

		}
	}

	public static void meetCheck() {
		int[] originalCnt = new int[K + 1];
		for (int i = 1; i <= K; i++) {
			originalCnt[i] = mCnt[i];
		}

		for (int i = 1; i <= K; i++) {
			if (mAlive[i] == 0)
				continue;

			for (int j = i + 1; j <= K; j++) {
				if (mAlive[j] == 0)
					continue;

				if (mR[i] == mR[j] && mC[i] == mC[j]) {
					if (originalCnt[i] > originalCnt[j]) {
						mCnt[i] += mCnt[j];
						mAlive[j] = 0;
					} else {
						mCnt[j] += mCnt[i];
						mAlive[i] = 0;
						break;
					}
				}
			}
		}
	}

	public static boolean rangeCheck(int r, int c) {
		return r == 0 || r == N - 1 || c == 0 || c == N - 1;
	}

	public static void inMedicine(int r, int c, int idx) {

		mCnt[idx] /= 2;

		if (mCnt[idx] == 0)
			mAlive[idx] = 0;

		if (mDir[idx] < 3) {
			mDir[idx] = mDir[idx] == UP ? DOWN : UP;
		} else {
			mDir[idx] = mDir[idx] == LEFT ? RIGHT : LEFT;
		}

	}
}
