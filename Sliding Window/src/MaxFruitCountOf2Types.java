/*
    MEDIUM
    Returns maximum number of fruits (characters) in two baskets, where each basket can hold one type of fruit
 */

import java.util.*;

class MaxFruitCountOf2Types {
    public static void main (String [] args) {
        int maxFruits = findLength(new char[] {'A', 'B', 'C', 'B', 'B', 'C'});
        System.out.println(maxFruits);
    }

    public static int findLength(char[] arr) {
        int maxCount = 0;
        int windowStart = 0;
        HashMap <Character, Integer> freq = new HashMap<>();                                     // keeps track of each fruit's frequency
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            freq.put(arr[windowEnd], freq.getOrDefault(arr[windowEnd], 0) + 1);      // adding fruit to map or incrementing its frequency if already exists
            if (freq.size() > 2) {                                                              // more than 2 distinct fruits have been added to the map
                freq.replace(arr[windowStart], freq.get(arr[windowStart]) - 1);                 // decrement frequency of fruit at left of window
                if (freq.get(arr[windowStart]) == 0) {                                          // if new decremented frequency is 0, remove fruit from map
                    freq.remove(arr[windowStart]);
                }
                windowStart++;                                                                  // increment start of window
            }
            maxCount = Math.max(maxCount, windowEnd - windowStart + 1);                         // after incrementing window size and accounting for more than 2 distinct fruits, update the value for max amount of 2 distinct fruits
        }
        return maxCount;
    }
}
