/*
    Returns triplet sum closest to or equal to target
 */

import java.util.Arrays;

public class TripletSumCloseToTarget {
    public static void main (String [] args) {
        int [] arr = {-2, 0, 1, 2};
        int target = 2;
        Arrays.sort(arr);
        int closest = searchTripletSum(arr, target);
        System.out.println(closest);
    }

    public static int searchTripletSum(int [] arr, int target) {
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                if (target - currentSum == 0) {
                    return target;
                }
                minDiff = Math.min(Math.abs(minDiff), Math.abs(target - currentSum));
                if (minDiff > 0) {
                    left++;
                }
                else if (minDiff < 0) {
                    right--;
                }
            }
        }
        return target - minDiff;
    }
}
