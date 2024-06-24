class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder(); 
        char[] x = X.toCharArray();
        char[] y = Y.toCharArray();
        
        int[] xCheckCnt = new int[10];
        int[] yCheckCnt = new int[10];
        
        for(int i = 0; i < x.length; i++) {
            int tmp = x[i] - '0';
            xCheckCnt[tmp]++;
        }
        for(int i = 0; i < y.length; i++) {
            int tmp = y[i] - '0';
            yCheckCnt[tmp]++;
        }
        
        for(int i = 9; i >= 0; i--) {
            int cnt = Math.min(xCheckCnt[i], yCheckCnt[i]);
            for(int t = 0; t < cnt; t++) {
                sb.append(i); 
            }
        }
        
        answer = sb.toString();
        
        if(answer.length() == 0) {
            answer = "-1";
            return answer;
        }
        
        if(answer.charAt(0) == '0') {
            answer = "0";
        }

        return answer;
    }
}