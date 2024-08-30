class Solution {
    public int solution(String arr[]) {
         int n = (arr.length / 2) + 1;  
        int[][] dpMax = new int[n][n];
        int[][] dpMin = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dpMax[i][j] = Integer.MIN_VALUE;
                dpMin[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            dpMax[i][i] = dpMin[i][i] = Integer.parseInt(arr[2 * i]);
        }

        for (int length = 2; length <= n; length++) {  
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                for (int k = i; k < j; k++) {
                    String op = arr[2 * k + 1];
                    if (op.equals("+")) {
                        dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i][k] + dpMax[k + 1][j]);
                        dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i][k] + dpMin[k + 1][j]);
                    } else if (op.equals("-")) {
                        dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i][k] - dpMin[k + 1][j]);
                        dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i][k] - dpMax[k + 1][j]);
                    }
                }
            }
        }
        return dpMax[0][n - 1];
    }
}