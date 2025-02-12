import java.util.HashSet;

class Solution {
        public int solution(String numbers) {
            HashSet<Integer> arr = new HashSet<>();
            boolean[] visited = new boolean[numbers.length()];
            
            for (int i = 1; i <= numbers.length(); i++) {
                backtracking(numbers, "", visited, arr, i);
            }
            
            int count = 0;
            for (int num : arr) {
                if (isPrime(num)) {
                    count++;
                }
            }
            return count;
        }

        public void backtracking(String str, String temp, boolean[] visited, HashSet<Integer> arr, int m) {
            if (temp.length() == m) {
                int num = Integer.parseInt(temp);
                arr.add(num); 
                return;
            }

            for (int i = 0; i < str.length(); i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    backtracking(str, temp + str.charAt(i), visited, arr, m);
                    visited[i] = false;
                }
            }
        }

        public boolean isPrime(int n) {
            if (n <= 1) {
                return false;
            }
            if (n == 2) {
                return true;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

