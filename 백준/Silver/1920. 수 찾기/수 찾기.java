

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        
        Arrays.sort(arr); 
        
        int k = s.nextInt();
        for (int j = 0; j < k; j++) {
            int target = s.nextInt();
            boolean found = binarySearch(arr, target); 
            if (found)
                sb.append("1\n");
            else
                sb.append("0\n");
        }
        
        System.out.println(sb);
        s.close();
    }
    

    private static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        
        return false;
    }
}
