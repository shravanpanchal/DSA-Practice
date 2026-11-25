
/*
 * BINARY SEARCH
 *
 * Given a sorted integer array and a target,
 * return the index of the target if found.
 * Otherwise, return -1.
 *
 * Example:
 *
 * array = {10, 20, 30, 40, 50, 60, 70}
 * target = 40
 *
 * Output: 3
 *
 *
 * APPROACHES:
 *
 * 1. Recursive Binary Search
 *    Time Complexity: O(log n)
 *    Space Complexity: O(log n) - Recursive Stack
 *
 * 2. Iterative Binary Search
 *    Time Complexity: O(log n)
 *    Space Complexity: O(1)
 */

package algorithm.searching;


public class BinarySearch {


    // ============================================================
    // APPROACH 1: RECURSIVE BINARY SEARCH
    //
    // 1. Calculate the middle index.
    // 2. Compare middle element with target.
    // 3. Search left or right half recursively.
    // 4. Stop when left > right.
    //
    // Time: O(log n)
    // Space: O(log n) - Recursive Stack
    // ============================================================

    public static int binarySearch(int[] array, int target) {

        return binarySearch(array, target, 0, array.length - 1);
    }


    private static int binarySearch(
            int[] array, int target, int left, int right) {

        // Base condition: Target not found
        if (left > right) {
            return -1;
        }

        // Calculate middle index
        int mid = left + (right - left) / 2;

        // Search right half
        if (array[mid] < target) {
            return binarySearch(array, target, mid + 1, right);
        }

        // Target found
        else if (array[mid] == target) {
            return mid;
        }

        // Search left half
        else {
            return binarySearch(array, target, left, mid - 1);
        }
    }


    // ============================================================
    // APPROACH 2: ITERATIVE BINARY SEARCH
    //
    // 1. Initialize left and right boundaries.
    // 2. Calculate the middle index.
    // 3. Update boundaries based on comparison.
    // 4. Repeat until target is found or range is exhausted.
    //
    // Time: O(log n)
    // Space: O(1)
    // ============================================================

    public static int binarySearchIterative(int[] array, int target) {

        int left = 0;
        int right = array.length - 1;
        
        //stop condition
        while (left <= right) {
        	
        	//calculate middle index
        	int mid = left + (right - left)/2;
        	
        	//search right half
        	if (target > array[mid]) {
        		left = mid + 1;
        	}
        	
        	//target found
        	else if (target == array[mid]) {
        		return mid;
        	}
        	
        	//search left half
        	else {
        		right = mid - 1;
        	}
        }
        return -1;
    }



    public static void main(String[] args) {

        int[] array = {10, 20, 30, 40, 50, 60, 70};

        int target = 40;

        // Recursive Approach
        System.out.println(
            "Recursive Binary Search\n" +
            "Time: O(log n)\n" +
            "Space: O(log n)\n" +
            binarySearch(array, target)
        );

        // Iterative Approach
        System.out.println(
            "\nIterative Binary Search\n" +
            "Time: O(log n)\n" +
            "Space: O(1)\n" +
            binarySearchIterative(array, target)
        );
    }
}
