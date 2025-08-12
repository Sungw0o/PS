class Solution {
        public int solution(int[][] sizes) {

            int maxLongSide = 0;
            int maxShortSide = 0;

            for (int i = 0; i < sizes.length; i++) {
                int longSide = Math.max(sizes[i][0], sizes[i][1]);
                int shortSide = Math.min(sizes[i][0], sizes[i][1]);

                maxLongSide = Math.max(maxLongSide, longSide);
                maxShortSide = Math.max(maxShortSide, shortSide);
            }

            return maxLongSide * maxShortSide;
        }
    }