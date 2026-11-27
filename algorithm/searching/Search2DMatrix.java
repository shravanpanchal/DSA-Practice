
/*
 * SEARCH A 2D MATRIX
 *
 * Given an m x n matrix where:
 *
 * 1. Integers in each row are sorted in ascending order.
 * 2. The first integer of each row is greater than the last
 *    integer of the previous row.
 *
 * Find whether a target value exists in the matrix.
 *
 * Example:
 *
 * matrix = {
 *     {1,  3,  5,  7},
 *     {10, 11, 16, 20},
 *     {23, 30, 34, 60}
 * }
 *
 * target = 16
 *
 * Output: true
 *
 */

package algorithm.searching;

public class Search2DMatrix {


    // ============================================================
    // APPROACH 1: BINARY SEARCH
    //
    // 1. Treat the 2D matrix as a sorted 1D array.
    // 2. Calculate the middle index using binary search.
    // 3. Convert the 1D index into 2D row and column indices.
    // 4. Compare the middle element with the target.
    // 5. Adjust left and right pointers accordingly.
    //
    // Row    = mid / n
    // Column = mid % n
    //
    // Time: O(log(m * n))
    // Space: O(1)
    // ============================================================

    public static boolean searchMatrix(int[][] matrix, int target) {

        // Handle empty matrix
        if (matrix == null || matrix.length == 0 ||
            matrix[0].length == 0) {

            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // Initialize binary search boundaries
        int left = 0;
        int right = m * n - 1;

        while (left <= right) {

            // Calculate middle index
            int mid = left + (right - left) / 2;

            // Convert 1D index into 2D indices
            int row = mid / n;
            int column = mid % n;

            // Get middle element
            int midValue = matrix[row][column];

            // Target found
            if (midValue == target) {

                return true;
            }

            // Search in the right half
            else if (midValue < target) {

                left = mid + 1;
            }

            // Search in the left half
            else {

                right = mid - 1;
            }
        }

        // Target not found
        return false;
    }


    public static void main(String[] args) {

        int[][] matrix = {
            {1,  3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target1 = 16;
        int target2 = 25;

        // Search for target 1
        System.out.println(
            "Binary Search\n" +
            "Time: O(log(m * n))\n" +
            "Space: O(1)\n" +
            "Target " + target1 + ": " +
            searchMatrix(matrix, target1)
        );

        // Search for target 2
        System.out.println(
            "\nBinary Search\n" +
            "Time: O(log(m * n))\n" +
            "Space: O(1)\n" +
            "Target " + target2 + ": " +
            searchMatrix(matrix, target2)
        );
    }
}
