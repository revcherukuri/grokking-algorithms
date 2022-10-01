/*
    Returns length of longest substring that will contain no more than one distinct character (all letters will be the same) after replacing r characters
 */

import java.util.HashMap;

public class LongestSubstringWithSameLettersAfterReplacement {
    public static void main (String [] args) {
        String str = "aabccbbacbcc";
        int r = 3;
        int maxLength = findLength (str, r);
        System.out.println(maxLength);
    }

    public static int findLength (String str, int r) {
        int windowStart = 0;
        int maxLength = 0;
        HashMap <Character, Integer> freq = new HashMap<>();                                               // to keep track of letter frequencies
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd ++) {
            int maxLetterFreq = 0;                                                                         // this value will keep track of the most common letter in the window
            freq.put(str.charAt(windowEnd), freq.getOrDefault(str.charAt(windowEnd), 0) + 1);  // add characters with frequencies to map
            for (int count : freq.values()) {                                                              // iterate through map to find the largest value, representing the most common character
                if (count > maxLetterFreq) {
                    maxLetterFreq = count;
                }
            }
            while ((windowEnd - windowStart + 1) - maxLetterFreq > r) {                                    // this will iterate while the number of characters in the window excluding the most common character is greater than the number of allowed replacements
                freq.replace(str.charAt(windowStart), freq.get(str.charAt(windowStart)) - 1);              // decrement character frequencies from beginning of window
                if (freq.get(str.charAt(windowStart)) == 0) {                                              // if character frequency drops to 0, remove it from the map
                    freq.remove(str.charAt(windowStart));
                }
                windowStart ++;                                                                            // increment beginning of window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);                                  // update max length value
        }
        return maxLength;
    }
}
