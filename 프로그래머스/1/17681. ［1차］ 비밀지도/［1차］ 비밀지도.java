import java.io.IOException;

class Solution {

        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];

            for (int i = 0; i < n; i++) {
                String binaryA = intToBinary(arr1[i], n);
                String binaryB = intToBinary(arr2[i], n);
                answer[i] = decoding(binaryA, binaryB);
            }

            return answer;
        }

        public String intToBinary(int num, int length) {
            String binary = Integer.toBinaryString(num);

            while (binary.length() < length) {
                binary = "0" + binary;
            }

            return binary;
        }

        public String decoding(String binaryA, String binaryB) {
            StringBuilder decodedMap = new StringBuilder();

            for (int i = 0; i < binaryA.length(); i++) {
                decodedMap.append(
                        Math.max(binaryA.charAt(i) - '0', binaryB.charAt(i) - '0') == 1 ? "#" : " "
                );
            }

            return decodedMap.toString();
        }
    }