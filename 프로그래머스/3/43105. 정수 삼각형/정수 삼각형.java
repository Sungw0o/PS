class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int fromLeftUp = (j - 1 >= 0) ? dp[i-1][j-1] : 0;
                int fromUp = (j <= i-1) ? dp[i-1][j] : 0;
                dp[i][j] = Math.max(fromLeftUp, fromUp) + triangle[i][j];
            }
        }
        
        int answer = 0;
        for (int j = 0; j < n; j++) {
            answer = Math.max(answer, dp[n-1][j]);
        }
        return answer;
    }
}
