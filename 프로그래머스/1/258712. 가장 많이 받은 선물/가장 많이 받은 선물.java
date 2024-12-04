import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int friendsNum = friends.length;
        HashMap<String, Integer> friendMap = buildFriendMap(friends);
        
        int[][] giftCount = new int[friendsNum][friendsNum];
        int[] giftScore = new int[friendsNum];

        exchangeGifts(gifts, friendMap, giftCount, giftScore);

        return calculateMaxGifts(friendsNum, giftCount, giftScore);
    }

    private HashMap<String, Integer> buildFriendMap(String[] friends) {
        HashMap<String, Integer> friendMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendMap.put(friends[i], i);
        }
        return friendMap;
    }

    private void exchangeGifts(String[] gifts, HashMap<String, Integer> friendMap, int[][] giftCount, int[] giftScore) {
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String from = parts[0];
            String to = parts[1];
            int fromIdx = friendMap.get(from);
            int toIdx = friendMap.get(to);
            
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
