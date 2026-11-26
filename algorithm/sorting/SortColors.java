
/*
 * SORT COLORS
 *
 * Given an integer array containing only 0, 1, and 2,
 * sort the array in-place in ascending order.
 *
 * Example:
 *
 * array = {2, 0, 2, 1, 1, 0}
 *
 * Output: [0, 0, 1, 1, 2, 2]
 *
 * APPROACH:
 *
 * 1. Dutch National Flag Algorithm
 *    Time: O(n)
 *    Space: O(1)
 *
 * 2. Counting Sort
 *    Time: O(n)
 *    Space: O(1)
 */

package algorithm.sorting;

import java.util.Arrays;

public class SortColors {


    // ============================================================
    // APPROACH 1: DUTCH NATIONAL FLAG ALGORITHM
    //
    // 1. Maintain low, current, and high pointers.
    // 2. If element is 0, swap with low and increment both.
    // 3. If element is 1, increment current.
    // 4. If element is 2, swap with high and decrement high.
    //
    // Time: O(n)
    // Space: O(1)
    // ============================================================

    public static void sortColors(int[] nums) {

        int low = 0;
        int current = 0;
        int high = nums.length - 1;

        while (current <= high) {

            // Move 0 to the left
            if (nums[current] == 0) {

                swap(nums, current, low);

                low++;
                current++;
            }

            // Move 2 to the right
            else if (nums[current] == 2) {

                swap(nums, current, high);

                high--;
            }

            // Element is 1
            else {

                current++;
            }
        }
    }


    // ============================================================
    // APPROACH 2: COUNTING SORT
    //
    // 1. Count occurrences of 0, 1, and 2.
    // 2. Reconstruct the sorted array using the counts.
    //
    // Time: O(n)
    // Space: O(1)
    // ============================================================

    public static void sortColorsCounting(int[] nums) {

        int[] count = new int[3];

        // Count occurrences
        for (int i = 0; i < nums.length; i++) {

            count[nums[i]]++;
        }

        int point = 0;

        // Reconstruct sorted array
        for (int i = 0; i < nums.length; i++) {

            // Skip exhausted counts
            while (point < 3 && count[point] == 0) {

                point++;
            }

            nums[i] = point;
            count[point]--;
        }
    }


    // ============================================================
    // SWAP TWO ELEMENTS
    //
    // Time: O(1)
    // Space: O(1)
    // ============================================================

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];

        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {

        int[] array1 = {2, 0, 2, 1, 1, 0};
        int[] array2 = {2, 0, 2, 1, 1, 0};

        // Approach 1: Dutch National Flag
        sortColors(array1);

        System.out.println(
            "Dutch National Flag Algorithm\n" +
            "Time: O(n)\n" +
            "Space: O(1)\n" +
            Arrays.toString(array1)
        );

        // Approach 2: Counting Sort
        sortColorsCounting(array2);

        System.out.println(
            "\nCounting Sort\n" +
            "Time: O(n)\n" +
            "Space: O(1)\n" +
            Arrays.toString(array2)
        );
    }
}
