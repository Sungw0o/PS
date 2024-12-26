class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (checkbill(wallet, bill)) {
            if (bill[0] >= bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }
        return answer;
    }

    public boolean checkbill(int[] wallet, int[] bill) {
        return Math.min(bill[0], bill[1]) > Math.min(wallet[0], wallet[1])
                || Math.max(bill[0], bill[1]) > Math.max(wallet[0], wallet[1]);
    }
}
