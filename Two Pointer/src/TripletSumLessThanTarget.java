/*
    MEDIUM
    Returns number of triplets whose sum is less than target
 */

import java.util.Arrays;

public class TripletSumLessThanTarget {
    public static void main (String [] args) {
        int [] arr = {-1, 4, 2, 1, 3};
        int target = 5;
        Arrays.sort(arr);
        int sol = searchTriplets(arr, target);
        System.out.println(sol);
    }

    public static int searchTriplets (int [] arr, int target) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            count += searchPair(arr, target-arr[i], i);
        }
        return count;
    }

    public static int searchPair (int [] arr, int target, int i) {
        int count = 0;
        int left = i + 1;
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum < target) {
                count += right - left;
                left++;
            }
            else {
                right--;
            }
        }
        return count;
    }
}
