/*
    EASY
    Returns size of array after removing all duplicate values
 */

public class RemoveDuplicatesFromSortedArray {
    public static void main (String [] args) {
        int [] arr = {2, 3, 3, 3, 6, 9, 9};
        int count = removeDuplicates(arr);
        System.out.println(count);
    }

    public static int removeDuplicates (int [] arr) {
        int slow = 0;                                           // two pointer approach
        int fast = slow + 1;
        while (slow < arr.length && fast < arr.length) {        // both pointers increment throughout array. Fast goes ahead of slow
            if (arr[slow] == arr[fast]) {                       // if fast element is equal to slow element, increment fast again
                fast ++;
            }
            else {                                              // if fast element is not equal to slow element, we found a first instance of a unique value.
                slow ++;                                        // so we move slow forward because its current value is a unique instance, and set that next value to this element at fast
                arr[slow] = arr[fast];
            }
        }                                                       // basically fast keeps incrementing whenever it is the same value as slow. When it finds a new value, slow increments to avoid overwriting its current value, and fast is set there. Then fast will increment and if it sees more of this new value, it wont update the array because the new slow is the value we just added.
        return slow + 1;
    }
}
