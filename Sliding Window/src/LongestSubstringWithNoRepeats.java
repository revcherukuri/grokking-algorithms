/*
    Returns length of longest substring in a string with no repeating characters
 */

import java.util.HashMap;

public class LongestSubstringWithNoRepeats {
    public static void main (String [] args) {
        String str = "abccde";
        int length = findLength (str);
        System.out.println(length);
    }

    public static int findLength (String str) {
        int windowStart = 0;
        int maxLength = 0;
        HashMap <Character, Integer> freq = new HashMap<>();                                                    // to keep track of character frequencies
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {                                        // loops through entire string
            freq.put(str.charAt(windowEnd), freq.getOrDefault(str.charAt(windowEnd), 0) + 1);       // add character to map with 1 as frequency, if already present increment frequency value
            while (freq.get(str.charAt(windowEnd)) > 1) {                                                       // the current character at the end of the window exists somewhere else in the window
                freq.replace(str.charAt(windowStart), freq.get(str.charAt(windowStart)) - 1);                   // loops through and decrements frequencies of characters from beginning of window until there are no repeats
                windowStart ++;         // increment start of window
            }
            maxLength = Math.max (maxLength, windowEnd - windowStart + 1);                                      // after incrementing the window and accounting for any character repeats update the max window length value
        }

        return maxLength;
    }
}
