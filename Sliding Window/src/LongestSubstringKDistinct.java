/*
    Returns maximum size of subarray in String with no more than k distinct characters
    ex. aabcd, 2 -> returns 3 because aab has 2 distinct characters and is the longest substring compared to other options ab, bc, cd.
 */

import java.util.*;

class LongestSubstringKDistinct {
    public static void main(String [] args) {
        String str = "araaci";
        int longestSubstr = findLength(str, 2);
        System.out.println(longestSubstr);
    }

    public static int findLength(String str, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();                                          // keeps track of characters' frequencies in string
        int windowStart = 0;
        int maxSize = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char current = str.charAt(windowEnd);
            freq.put(current, freq.getOrDefault(current, 0) + 1);                        // add character at end of window to map or update its frequency if already exists
            while (freq.size() > k) {                                                               // more than k distinct characters exists in map
                freq.replace(str.charAt(windowStart), freq.get(str.charAt(windowStart)) - 1);       // reduce frequency in map of leftmost character in window
                if (freq.get(str.charAt(windowStart)) == 0) {                                       // when reducing count, remove character from map if its frequency is 0
                    freq.remove(str.charAt(windowStart));
                }
                windowStart++;                                                                      // shrink window
            }
            maxSize = Math.max(maxSize, windowEnd - windowStart + 1);                               // after incrementing window size and accounting for more than k distinct characters if needed, update max subarray size
        }

        return maxSize;
    }
}
