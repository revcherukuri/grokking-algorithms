/*
    Returns length of longest subarray that contains only 1's after replacing r 0's with 1's.
 */

public class LongestSubstringWithOnesAfterReplacement {
    public static void main (String [] args) {
        int [] input = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int r = 3;
        int maxLength = findLength(input, r);
        System.out.println(maxLength);
    }

    public static int findLength (int [] input, int r) {
        int windowStart = 0;
        int maxLength = 0;
        int replacements = 0;                                                   // to keep track of the number of times we will swap 0 with 1
        for (int windowEnd = 0; windowEnd < input.length; windowEnd++) {
            if (input[windowEnd] == 0) {                                        // every time we see a 0, we "replace" it by just incrementing the replacements value
                replacements ++;
            }
            while (replacements > r) {                                          // when we replaced 0 with 1 more times than allowed we loop through the window from the left
                if (input[windowStart] == 0) {                                  // each iteration, if we see a 0 that means it has been replaced, since we increment the replacements value every time we see a 0
                    replacements --;                                            // decrement replacements
                }
                windowStart ++;                                                 // increment the window starting point
            }
            maxLength = Math.max (maxLength, windowEnd - windowStart + 1);      // every time we increase the window size, replace,  and account for doing more replacements than allowed, maxLength is updated
        }

        return maxLength;
    }
}
