import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int friendsNum = friends.length;
        HashMap<String, Integer> friendIndexMap = buildFriendIndexMap(friends);
        int[][] giftCount = new int[friendsNum][friendsNum];
        int[] giftScore = new int[friendsNum];

        processGifts(gifts, friendIndexMap, giftCount, giftScore);

        return calculateMaxGifts(friendsNum, giftCount, giftScore);
    }

    private HashMap<String, Integer> buildFriendIndexMap(String[] friends) {
        HashMap<String, Integer> friendIndexMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendIndexMap.put(friends[i], i);
        }
        return friendIndexMap;
    }

    private void processGifts(String[] gifts, HashMap<String, Integer> friendIndexMap, int[][] giftCount, int[] giftScore) {
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String from = parts[0];
            String to = parts[1];
            int fromIdx = friendIndexMap.get(from);
            int toIdx = friendIndexMap.get(to);
            
            giftCount[fromIdx][toIdx]++;
            giftScore[fromIdx]++;
            giftScore[toIdx]--;
        }
    }

    private int calculateMaxGifts(int friendsNum, int[][] giftCount, int[] giftScore) {
        int maxGifts = 0;
        for (int i = 0; i < friendsNum; i++) {
            int count = 0;
            for (int j = 0; j < friendsNum; j++) {
                if (i != j) {
                    if (giftCount[i][j] > giftCount[j][i]) {
                        count++;
                    } else if (giftCount[i][j] == giftCount[j][i] && giftScore[i] > giftScore[j]) {
                        count++;
                    }
                }
            }
            maxGifts = Math.max(maxGifts, count);
        }
        return maxGifts;
    }
}
