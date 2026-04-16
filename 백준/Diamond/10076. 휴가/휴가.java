import java.io.*;
import java.util.*;

public class Main {
    static int n, d, S;
    static long[] a;
    static int[] rnk;
    static int SZ;
    static int[] tc;
    static long[] ts;
    static long ans;
    static int cL, cR;

    static void upd(int p, int v, long sv) {
        p += SZ;
        tc[p] += v;
        ts[p] += sv;
        for (p >>= 1; p >= 1; p >>= 1) {
            tc[p] = tc[2 * p] + tc[2 * p + 1];
            ts[p] = ts[2 * p] + ts[2 * p + 1];
        }
    }

    static long qry(int k) {
        if (k <= 0) return 0;
        if (k >= tc[1]) return ts[1];
        int nd = 1;
        long res = 0;
        int rem = k;
        while (nd < SZ) {
            int r = nd * 2 + 1;
            if (tc[r] <= rem) {
                res += ts[r];
                rem -= tc[r];
                nd = nd * 2;
            } else {
                nd = r;
            }
        }
        if (rem > 0 && tc[nd] > 0) {
            res += (ts[nd] / tc[nd]) * rem;
        }
        return res;
    }

    static void addCity(int i) {
        upd(rnk[i], 1, a[i]);
    }

    static void remCity(int i) {
        upd(rnk[i], -1, -a[i]);
    }

    static void expand(int L, int R) {
        while (cL > L) { cL--; addCity(cL); }
        while (cR < R) { cR++; addCity(cR); }
        while (cL < L) { remCity(cL); cL++; }
        while (cR > R) { remCity(cR); cR--; }
    }

    static void dnc1(int lo, int hi, int oL, int oH) {
        if (lo > hi) return;
        int mid = (lo + hi) / 2;
        long best = -1;
        int bo = oL;
        int upper = Math.min(oH, S);
        for (int L = oL; L <= upper; L++) {
            int travel = 2 * (S - L) + (mid - S);
            int rem = d - travel;
            if (rem < 0) continue;
            expand(L, mid);
            int k = Math.min(rem, mid - L + 1);
            long val = qry(k);
            if (val > best) {
                best = val;
                bo = L;
            }
        }
        if (best >= 0) ans = Math.max(ans, best);
        dnc1(mid + 1, hi, bo, oH);
        dnc1(lo, mid - 1, oL, bo);
    }

    static void dnc2(int lo, int hi, int oL, int oH) {
        if (lo > hi) return;
        int mid = (lo + hi) / 2;
        long best = -1;
        int bo = oH;
        int lower = Math.max(oL, S);
        for (int R = oH; R >= lower; R--) {
            int travel = 2 * (R - S) + (S - mid);
            int rem = d - travel;
            if (rem < 0) continue;
            expand(mid, R);
            int k = Math.min(rem, R - mid + 1);
            long val = qry(k);
            if (val > best) {
                best = val;
                bo = R;
            }
        }
        if (best >= 0) ans = Math.max(ans, best);
        dnc2(lo, mid - 1, oL, bo);
        dnc2(mid + 1, hi, bo, oH);
    }

    static void reset() {
        Arrays.fill(tc, 0);
        Arrays.fill(ts, 0);
        cL = S;
        cR = S - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        a = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());

        long[] sorted = a.clone();
        Arrays.sort(sorted);
        int un = 1;
        for (int i = 1; i < n; i++) {
            if (sorted[i] != sorted[i - 1]) sorted[un++] = sorted[i];
        }
        HashMap<Long, Integer> comp = new HashMap<>();
        for (int i = 0; i < un; i++) comp.put(sorted[i], i);
        rnk = new int[n];
        for (int i = 0; i < n; i++) rnk[i] = comp.get(a[i]);

        SZ = 1;
        while (SZ <= un) SZ <<= 1;
        tc = new int[2 * SZ];
        ts = new long[2 * SZ];

        ans = 0;

        reset();
        int rHi = Math.min(n - 1, S + d);
        if (rHi >= S) {
            dnc1(S, rHi, Math.max(0, S - d), S);
        }

        reset();
        int lLo = Math.max(0, S - d);
        if (lLo <= S) {
            dnc2(lLo, S, S, Math.min(n - 1, S + d));
        }

        System.out.println(ans);
    }
}