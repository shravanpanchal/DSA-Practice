
/*
 * MERGE SORTED ARRAY
 *
 * Given two sorted integer arrays, merge array2 into array1
 * in non-decreasing order.
 *
 * array1 has enough extra space to accommodate array2.
 * Modify array1 in-place.
 *
 * Example:
 *
 * array1 = {1, 2, 3, 0, 0, 0}
 * n = 3
 *
 * array2 = {2, 5, 6}
 * m = 3
 *
 * Output: [1, 2, 2, 3, 5, 6]
 *
 *    Time Complexity: O(n + m)
 *    Space Complexity: O(1)
 */

package twoPointers;

import java.util.Arrays;

public class MergeSortedArray {


    // ============================================================
    // APPROACH: THREE POINTERS (MERGE FROM END)
    //
    // 1. Initialize pointers at the end of both arrays.
    // 2. Compare elements from array1 and array2.
    // 3. Place the larger element at the end of array1.
    // 4. Copy remaining elements from array2.
    //
    // Time: O(n + m)
    // Space: O(1)
    // ============================================================

    public static void mergeSorted(int[] array1, int n, int[] array2, int m) {

        // Initialize pointers
        int i = n - 1;
        int j = m - 1;
        int k = m + n - 1;

        // Merge from the end
        while (i >= 0 && j >= 0) {

            // Place larger element at the end
            if (array1[i] > array2[j]) {
                array1[k] = array1[i];
                i--;
            }

            else {
                array1[k] = array2[j];
                j--;
            }

            k--;
        }

        // Copy remaining array2 elements
        while (j >= 0) {
            array1[k] = array2[j];
            j--;
            k--;
        }
    }


    public static void main(String[] args) {

        int[] array1 = {1, 2, 3, 0, 0, 0};
        int[] array2 = {2, 5, 6};

        int n = 3;
        int m = 3;

        mergeSorted(array1, n, array2, m);

        System.out.println(
            "Merge Sorted Array\n" +
            "Time: O(n + m)\n" +
            "Space: O(1)\n" +
            Arrays.toString(array1)
        );
    }
}
