/*
    EASY
    Squares all elements of given sorted array (including negative values) and returns as sorted array
 */

public class SquareSortedArray {
    public static void main (String [] args) {
        int [] arr = {-3, -1, 0, 1, 2};
        int [] sol = makeSquares(arr);
        System.out.print("[");
        for (int i = 0; i < sol.length; i++) {
            System.out.print(sol[i]);
            if (i < sol.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] makeSquares (int[] arr) {                       // two pointer approach
        int left = 0;
        int right = arr.length - 1;
        int highestIndex = arr.length - 1;                              // keeps track of current index to plug values in for sol array
        int [] sol = new int[arr.length];
        while (left < right) {
            if (Math.pow(arr[right], 2) >= Math.pow(arr[left], 2)) {    // if square of right val is greater than left, put in sol array and decrement right index
                sol[highestIndex--] = (int) Math.pow(arr[right], 2);    // decrement index to add value at
                right--;
            }
            else {
                sol[highestIndex--] = (int) Math.pow(arr[left], 2);     // otherwise put square of left val and increment left index. Decrement index to add value at
                left++;
            }
        }
        return sol;
    }
}
