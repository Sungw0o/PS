class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        boolean[] visited = new boolean[dungeons.length];
        answer = dfs(k, dungeons, visited, 0);
        return answer;
    }

    private int dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        int max = count;

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true; 
                max = Math.max(max, dfs(k - dungeons[i][1], dungeons, visited, count + 1));
                visited[i] = false; 
            }
        }

        return max;
    }
}
