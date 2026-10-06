/*
 * Container With Most Water - Brute Force & Two Pointer Approach
 *
 * Find two vertical lines that together with the x-axis
 * form a container that holds the maximum amount of water.
 *
 * Example:
 * Input:  [1, 8, 6, 2, 5, 4, 8, 3, 7]
 * Output: 49
 *
 */

package twoPointers;

public class ContainerWithMostWater {

	/**
	 * APPROACH: Brute Force
	 *
	 * Check every possible pair of lines and calculate
	 * the amount of water that can be stored between them.
	 *
	 * Time Complexity: O(n²)
	 * Space Complexity: O(1)
	 */
	public static int largestContainer_Brute(int[] array) {

		int maxSize = 0;

		for (int i = 0; i < array.length - 1; i++) {
			
			for (int j = i + 1; j < array.length; j++) {
				int size = Math.min(array[i], array[j]) * (j - i);
				
				maxSize = Math.max(maxSize, size);
			}
		}

		return maxSize;
	}

	/**
	 * APPROACH: Two Pointer
	 *
	 * Start with pointers at both ends of the array.
	 * Calculate the area and always move the pointer
	 * with the smaller height.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	public static int largestContainer_Pointer(int[] array) {

		if (array == null || array.length < 2) {
			return 0;
		}

		int left = 0;
		int right = array.length - 1;

		int maxSize = 0;

		// Continue until both pointers meet
		while (left < right) {

			// Calculate the current container area
			int size = Math.min(array[left], array[right])
					* (right - left);

			// Update maximum area
			if (size > maxSize) {
				maxSize = size;
			}

			// Move the pointer with the smaller height
			if (array[right] < array[left]) {
				right--;
			} else {
				left++;
			}
		}

		return maxSize;
	}

	public static void main(String[] args) {

		int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};

		System.out.println("--- Input Array ---");
		System.out.println("[1, 8, 6, 2, 5, 4, 8, 3, 7]");

		System.out.println("\n--- Brute Force Approach ---");
		System.out.println("Time Complexity: O(n²)");
		System.out.println("Space Complexity: O(1)");
		System.out.println("Maximum Container: " + largestContainer_Brute(array));

		System.out.println("\n--- Two Pointer Approach ---");
		System.out.println("Time Complexity: O(n)");
		System.out.println("Space Complexity: O(1)");
		System.out.println("Maximum Container: " + largestContainer_Pointer(array));
	}
}