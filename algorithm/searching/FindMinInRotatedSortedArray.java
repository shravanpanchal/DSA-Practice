
/*
 * FIND MINIMUM IN ROTATED SORTED ARRAY
 *
 * Given a sorted array rotated at an unknown pivot,
 * find the minimum element.
 *
 * Example:
 *
 * array = {4, 5, 6, 7, 0, 1, 2}
 *
 * Output: 0
 *
 * APPROACH:
 *
 * 1. Binary Search
 *    Time: O(log n)
 *    Space: O(1)
 */

package algorithm.searching;

public class FindMinInRotatedSortedArray {


    // ============================================================
    // APPROACH 1: BINARY SEARCH
    //
    // 1. Check if the array is already sorted.
    // 2. Calculate mid and compare with array[low].
    // 3. If left half is sorted, search the right half.
    // 4. Otherwise, search the left half.
    //
    // Time: O(log n)
    // Space: O(1)
    // ============================================================

    public static int findMin(int[] array) {

        int low = 0;
        int high = array.length - 1;

        // Array is already sorted
        if (array[low] <= array[high]) {

            return array[low];
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            // Left half is sorted
            if (array[mid] > array[high]) {

                low = mid + 1;
            }

            // Minimum lies in the left half
            else {

                high = mid;
            }
        }

        return array[low];
    }


    public static void main(String[] args) {

        int[] array = {4, 5, 6, 7, 0, 1, 2};

        // Approach 1: Binary Search
        System.out.println(
            "Binary Search\n" +
            "Time: O(log n)\n" +
            "Space: O(1)\n" +
            "Minimum Element: " + findMin(array)
        );
    }
}
