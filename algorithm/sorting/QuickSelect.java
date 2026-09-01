/*
 * QUICK SELECT
 *
 * Quick Select is a selection algorithm based on Quick Sort.
 * It finds the kth smallest element without fully sorting the array.
 *
 * Steps:
 * 1. Choose a pivot.
 * 2. Partition the array around the pivot.
 * 3. Check the pivot's position.
 * 4. Search only the side containing k.
 *
 * Time Complexity:
 * Best/Average: O(n)
 * Worst: O(n²)
 *
 * Space Complexity: O(1)
 */

package algorithm.sorting;

public class QuickSelect {

    public static int quickSelect(int[] array, int k) {

        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        if (k < 0 || k >= array.length) {
            throw new IllegalArgumentException("Invalid value of k");
        }

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {

            // Choose the last element as the pivot
            int pivot = array[high];

            int i = low - 1;

            // Partition the array around the pivot
            for (int j = low; j < high; j++) {

                if (array[j] <= pivot) {

                    i++;

                    // Swap array[i] and array[j]
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            // Place pivot in its correct position
            int temp = array[i + 1];
            array[i + 1] = array[high];
            array[high] = temp;

            int pivotIndex = i + 1;

            // Pivot is the kth smallest element
            if (pivotIndex == k) {
                return array[pivotIndex];
            }

            // Search the left sub-array
            if (k < pivotIndex) {
                high = pivotIndex - 1;
            }

            // Search the right sub-array
            else {
                low = pivotIndex + 1;
            }
        }

        throw new IllegalArgumentException("Element not found");
    }

    public static void main(String[] args) {

        int[] array = {
            10, 15, 2, 13, 6,
            8, 4, 3, 12, 66
        };

        int k = 3;

        int result = quickSelect(array, k);

        System.out.println(result);
    }
}
