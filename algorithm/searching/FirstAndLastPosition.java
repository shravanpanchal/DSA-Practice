
/*
 * FIRST AND LAST POSITION IN SORTED ARRAY
 *
 * Given a sorted integer array and a target,
 * return the first and last occurrence indices.
 * If the target is not found, return {-1, -1}.
 *
 * Example:
 *
 * array = {1, 2, 3, 3, 3, 4, 4, 5}
 * target = 3
 *
 * Output: [2, 4]
 *
 *
 * APPROACH:
 *
 * 1. Recursive Binary Search - First Occurrence
 *    Time Complexity: O(log n)
 *    Space Complexity: O(log n)
 *
 * 2. Recursive Binary Search - Last Occurrence
 *    Time Complexity: O(log n)
 *    Space Complexity: O(log n)
 *
 * Overall:
 * Time Complexity: O(log n)
 * Space Complexity: O(log n)
 */

package algorithm.searching;

import java.util.Arrays;

public class FirstAndLastPosition {


    // ============================================================
    // APPROACH 1: FIND FIRST OCCURRENCE
    //
    // 1. Calculate middle index.
    // 2. If target is found, store its index.
    // 3. Continue searching in the left half.
    // 4. Return the stored index when search ends.
    //
    // Time: O(log n)
    // Space: O(log n) - Recursive Stack
    // ============================================================

    public static int findFirst(int[] array, int target) {

        return findFirst(array, target, 0, array.length - 1, -1);
    }


    private static int findFirst(
            int[] array, int target, int left, int right, int result) {

        // Base condition
        if (left > right) {
            return result;
        }

        // Calculate middle index
        int mid = left + (right - left) / 2;

        // Target found: Search left half
        if (array[mid] == target) {
            result = mid;
            return findFirst(array, target, left, mid - 1, result);
        }

        // Search right half
        else if (array[mid] < target) {
            return findFirst(array, target, mid + 1, right, result);
        }

        // Search left half
        else {
            return findFirst(array, target, left, mid - 1, result);
        }
    }


    // ============================================================
    // APPROACH 2: FIND LAST OCCURRENCE
    //
    // 1. Calculate middle index.
    // 2. If target is found, store its index.
    // 3. Continue searching in the right half.
    // 4. Return the stored index when search ends.
    //
    // Time: O(log n)
    // Space: O(log n) - Recursive Stack
    // ============================================================

    public static int findLast(int[] array, int target) {

        return findLast(array, target, 0, array.length - 1, -1);
    }


    private static int findLast(
            int[] array, int target, int left, int right, int result) {

        // Base condition
        if (left > right) {
            return result;
        }

        // Calculate middle index
        int mid = left + (right - left) / 2;

        // Target found: Search right half
        if (array[mid] == target) {
            result = mid;
            return findLast(array, target, mid + 1, right, result);
        }

        // Search right half
        else if (array[mid] < target) {
            return findLast(array, target, mid + 1, right, result);
        }

        // Search left half
        else {
            return findLast(array, target, left, mid - 1, result);
        }
    }


    // ============================================================
    // SEARCH RANGE
    //
    // Find first and last occurrences using binary search.
    //
    // Time: O(log n)
    // Space: O(log n) - Recursive Stack
    // ============================================================

    public static int[] searchRange(int[] array, int target) {

        int first = findFirst(array, target);
        int last = findLast(array, target);

        return new int[] {first, last};
    }


    public static void main(String[] args) {

        int[] array = {
            1, 2, 3, 3, 3, 3, 3, 3, 3, 3,
            4, 4, 4, 4, 4, 5, 5, 6, 6, 6, 77
        };

        int target = 4;

        System.out.println(
            "First and Last Position\n" +
            "Time: O(log n)\n" +
            "Space: O(log n)\n" +
            Arrays.toString(searchRange(array, target))
        );
    }
}
