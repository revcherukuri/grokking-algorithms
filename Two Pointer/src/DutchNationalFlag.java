/*
    MEDIUM
    Sorts array containing 0,1,2 efficiently
 */

public class DutchNationalFlag {
    public static void main (String [] args) {
        int [] arr = {1, 0, 2, 1, 0};
        int [] sol = sort(arr);
        for (int i : sol) {
            System.out.println(i);
        }
    }

    public static int[] sort (int [] arr) {
        int left = 0;
        int right = arr.length - 1;
        int i = 0;
        while (i <= right) {
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[left];
                arr[left] = temp;
                left++;
                i++;
            }
            else if (arr[i] == 1) {
                i++;
            }
            else {
                int temp = arr[right];
                arr[right] = arr[i];
                arr[i] = temp;
                right--;
            }
        }
        return arr;
    }
}
