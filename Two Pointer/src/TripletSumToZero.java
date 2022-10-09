/*
    MEDIUM
    Returns list of unique triplets in non sorted array that add to 0. Avoids duplicates.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    public static void main (String [] args) {
        int [] arr  = {-3, 0, 1, 2, -1, 1, -2};
        Arrays.sort(arr);
        List<List<Integer>> sol = searchTriplets(arr);
        System.out.println(sol);
    }

    public static List<List<Integer>> searchTriplets (int [] sortedArr) {
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < sortedArr.length; i++) {
            if (i > 0 && sortedArr[i] == sortedArr[i - 1]) {
                continue;
            }
            searchPair(sortedArr, -sortedArr[i], i + 1, triplets);
        }
        return triplets;
    }

    public static void searchPair(int [] arr, int target, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(-target);
                temp.add(arr[left]);
                temp.add(arr[right]);
                triplets.add(temp);
                left++;
                right--;
                while (left < right &&  arr[left] == arr[left - 1]) {
                    left++;
                }
                while (left < right && arr[right] == arr[right] + 1) {
                    right++;
                }
            }
            else if (arr[left] + arr[right] > target) {
                right--;
            }
            else {
                left++;
            }
        }
    }
}
