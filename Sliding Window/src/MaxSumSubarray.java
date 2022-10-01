/*
    EASY
    Returns the maximum sum of all subarrays with size k
 */

public class MaxSumSubarray {
    public static void main (String [] args) {
        int maxSum = maxSumSubarray(3, new int[] {2, 1, 5, 1, 3, 2});
        System.out.println(maxSum);
    }

    public static int maxSumSubarray(int k, int [] arr) {
        int sum = 0;
        int maxSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum += arr[windowEnd];                          // keeps track of current sum of window
            if ((windowEnd - windowStart) + 1 == k) {       // checks if size of window is equal to k
                maxSum = Math.max(maxSum, sum);             // if so, update the maximum window sum value because we have the desired subarray size
                sum -= arr[windowStart];                    // remove value at start of window from the window sum
                windowStart++;                              // shrink window
            }
        }
        return maxSum;
    }
}
