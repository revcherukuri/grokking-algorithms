/*
    EASY
    Returns indices of values in array that add to given target sum
    Uses two approaches
 */

import java.util.HashMap;

public class PairWithTargetSum {
    public static void main (String [] args) {
        int [] arr = {2, 5, 9, 11};
        int target = 11;
        int [] sol1 = search1(arr, target);
        System.out.print("Two pointer:\n[");
        for (int i = 0; i < sol1.length; i++) {
            System.out.print(sol1[i]);
            if (i < sol1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\n\nHashMap:\n[");
        int [] sol2 = search2(arr, target);
        for (int i = 0; i < sol2.length; i++) {
            System.out.print(sol2[i]);
            if (i < sol2.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Two pointer approach
     * one goes from left to right, the other goes from right to left
     * each iteration, we check if the sum is less than or greater than target. If less, since the array is sorted we know one of the addends needs to be larger so we increment left, the smaller value. If greater, for the same reason we decrement right.
     * if neither are true, we know the sum is equal and we have the solution
     */
    public static int[] search1 (int [] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int [] sol = new int[2];
        while (left <= right) {
            if (arr[left] + arr[right] < target) {
                left++;
            }
            else if (arr[left] + arr[right] > target) {
                right--;
            }
            else {
                sol[0] = left;
                sol[1] = right;
                break;
            }
        }
        return sol;
    }

    /**
     * Using HashMap
     * Iterate through each index in array with one pointer normally
     * At each step we know the current value, and the target.
     * We also know that target - current value = value we need to find because current value + some other value = target
     * each iteration, if the value doesn't exist yet in the map, we add it and set the index as the value
     * After this, we check if the complement (value we need to find) exists in the map. If so, we have the solution.
     */
    public static int[] search2 (int [] arr, int target) {
        HashMap <Integer, Integer> dict = new HashMap<>();
        int [] sol = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (!dict.containsKey(arr[i])) {
                dict.put(arr[i], i);
            }
            if (dict.containsKey(target - arr[i])) {
                sol[0] = dict.get(target - arr[i]);
                sol[1] = i;
            }
        }
        return sol;
    }
}
