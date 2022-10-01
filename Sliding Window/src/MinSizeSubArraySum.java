/*
    EASY
    Returns smallest subarray size with sum less than S
 */

public class MinSizeSubarraySum {
    public static void main (String [] args) {
        int minSize = findMinSubArray(8, new int[] {2, 1, 5, 1, 3, 2});
        System.out.println(minSize);
    }

    public static int findMinSubArray(int S, int[] arr) {
        int windowStart = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum += arr[windowEnd];                                          // current sum of window
            while (sum >= S) {                                              // loops while the current sum is not less than S
                minSize = Math.min(minSize, windowEnd - windowStart + 1);   // update min window size
                sum -= arr[windowStart];                                    // remove value at start of window from window sum
                windowStart++;                                              // shrink window
            }
        }
        return minSize;
    }
}
