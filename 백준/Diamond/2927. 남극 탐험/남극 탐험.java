import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static int[] penguins;
    static List<Integer>[] adj;

    // HLD를 위한 배열들
    static int[] sz, depth, parent, top, in, heavy;
    static int timer = 0;

    // 세그먼트 트리 및 유니온-파인드
    static int[] tree;
    static int[] uf;

    // 쿼리를 미리 저장해둘 클래스
    static class Query {
        String type;
        int a, b;

        Query(String type, int a, int b) {
            this.type = type;
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        // 초기화
        penguins = new int[N + 1];
        adj = new ArrayList[N + 1];
        uf = new int[N + 1];
        sz = new int[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1];
        top = new int[N + 1];
        in = new int[N + 1];
        heavy = new int[N + 1];
        Arrays.fill(heavy, -1);
        tree = new int[4 * N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            penguins[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
            uf[i] = i;
        }

        Q = Integer.parseInt(br.readLine());
        Query[] queries = new Query[Q];
        
        // 1. 오프라인 쿼리 수집 및 최종 연결 숲(Forest) 구성
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            queries[i] = new Query(type, a, b);

            if (type.equals("bridge")) {
                // 실제로 연결될 간선들만 트리에 추가
                if (union(a, b)) {
                    adj[a].add(b);
                    adj[b].add(a);
                }
            }
        }

        // 2. 구성된 숲을 바탕으로 HLD 세팅
        for (int i = 1; i <= N; i++) {
            if (sz[i] == 0) { // 아직 방문하지 않은 루트 노드라면
                dfs1(i, 0);
                dfs2(i, 0, i);
            }
        }

        // 세그먼트 트리에 초기 펭귄 수 업데이트
        for (int i = 1; i <= N; i++) {
            update(1, 1, N, in[i], penguins[i]);
        }

        // 3. 실제 쿼리 처리를 위해 유니온-파인드 초기화
        for (int i = 1; i <= N; i++) {
            uf[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        
        for (Query q : queries) {
            if (q.type.equals("bridge")) {
                if (find(q.a) == find(q.b)) {
                    sb.append("no\n");
                } else {
                    union(q.a, q.b);
                    sb.append("yes\n");
                }
            } else if (q.type.equals("penguins")) {
                update(1, 1, N, in[q.a], q.b);
            } else if (q.type.equals("excursion")) {
                // 두 섬이 연결되어 있지 않으면 불가능
                if (find(q.a) != find(q.b)) {
                    sb.append("impossible\n");
                } else {
                    sb.append(queryPath(q.a, q.b)).append("\n");
                }
            }
        }
        
        System.out.print(sb.toString());
    }

    // 유니온-파인드 로직
    static int find(int a) {
        if (uf[a] == a) return a;
        return uf[a] = find(uf[a]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        uf[a] = b;
        return true;
    }

    // HLD 전처리 1단계: 서브트리 크기, 깊이, 부모 노드, 가장 무거운 자식 기록
    static void dfs1(int u, int p) {
        sz[u] = 1;
        depth[u] = depth[p] + 1;
        parent[u] = p;
        int maxSub = 0;

        for (int v : adj[u]) {
            if (v == p) continue;
            dfs1(v, u);
            sz[u] += sz[v];
            if (sz[v] > maxSub) {
                maxSub = sz[v];
                heavy[u] = v;
            }
        }
    }

    // HLD 전처리 2단계: 체인 연결 및 세그먼트 트리 인덱스(in) 부여
    static void dfs2(int u, int p, int topNode) {
        in[u] = ++timer;
        top[u] = topNode;

        if (heavy[u] != -1) {
            dfs2(heavy[u], u, topNode); // 가장 무거운 자식은 같은 체인으로 연결
        }

        for (int v : adj[u]) {
            if (v == p || v == heavy[u]) continue;
            dfs2(v, u, v); // 나머지는 새로운 체인의 헤더로 분리
        }
    }

    // 세그먼트 트리 점(Point) 갱신
    static void update(int node, int start, int end, int idx, int val) {
        if (idx < start || idx > end) return;
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        update(node * 2, start, mid, idx, val);
        update(node * 2 + 1, mid + 1, end, idx, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    // 세그먼트 트리 구간 합 쿼리
    static int segQuery(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return segQuery(node * 2, start, mid, left, right) +
               segQuery(node * 2 + 1, mid + 1, end, left, right);
    }

    // HLD를 활용한 트리 상의 두 노드 간 경로 합 쿼리
    static int queryPath(int u, int v) {
        int sum = 0;
        while (top[u] != top[v]) {
            // 더 깊이 있는 체인부터 거슬러 올라감
            if (depth[top[u]] < depth[top[v]]) {
                int temp = u; u = v; v = temp;
            }
            sum += segQuery(1, 1, N, in[top[u]], in[u]);
            u = parent[top[u]];
        }
        // 같은 체인에 도달하면 높이가 더 높은 노드를 u로 설정
        if (depth[u] > depth[v]) {
            int temp = u; u = v; v = temp;
        }
        sum += segQuery(1, 1, N, in[u], in[v]);
        return sum;
    }
}