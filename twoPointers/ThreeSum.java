/*
 * Three Sum - HashSet & Two Pointer Approach
 *
 * Find all unique triplets whose sum is equal to 0.
 *
 * Example:
 * Input:  [-1, 0, 1, 2, -1, -4]
 * Output: [[-1, -1, 2], [-1, 0, 1]]
 *
 */

package twoPointers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

public class ThreeSum {

	/**
	 * APPROACH: HashSet
	 *
	 * Fix the first number and use a HashSet to find the
	 * required third number for every second number.
	 *
	 * Time Complexity: O(n²)
	 * Space Complexity: O(n²) including the output
	 */
	public static ArrayList<ArrayList<Integer>> threeSum_Set(int[] array) {

		if (array == null || array.length < 3) {
			return new ArrayList<>();
		}

		int n = array.length;

		// Stores unique triplets
		HashSet<ArrayList<Integer>> unique = new HashSet<>();

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		// Fix the first number
		for (int i = 0; i < n - 2; i++) {

			int first_num = array[i];

			// Stores previously seen numbers
			HashSet<Integer> set = new HashSet<>();

			// Select the second number
			for (int j = i + 1; j < n; j++) {

				int second_num = array[j];

				// Find the number required to make sum = 0
				int required = -(first_num + second_num);

				// Check if required number was already seen
				if (set.contains(required)) {

					ArrayList<Integer> triplet =
							new ArrayList<>(
									List.of(first_num, second_num, required)
							);

					// Normalize order to handle duplicates
					triplet.sort(Integer::compareTo);

					unique.add(triplet);
				}

				// Add current number for future checks
				set.add(array[j]);
			}
		}

		result.addAll(unique);

		return result;
	}

	/**
	 * APPROACH: Two Pointer
	 *
	 * Sort the array first. Fix the first number and use
	 * two pointers to find the remaining two numbers.
	 *
	 * Time Complexity: O(n²)
	 * Space Complexity: O(1) excluding the output
	 */
	public static ArrayList<ArrayList<Integer>> threeSum_Pointer(int[] array) {

		if (array == null || array.length < 3) {
			return new ArrayList<>();
		}

		int n = array.length;

		// Sort the array to use the two pointer technique
		Arrays.sort(array);

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		// Fix the first number
		for (int i = 0; i < n - 2; i++) {

			// Skip duplicate first numbers
			if (i > 0 && array[i] == array[i - 1]) {
				continue;
			}

			int first_num = array[i];

			// Left pointer starts after the first number
			int left = i + 1;

			// Right pointer starts at the end
			int right = n - 1;

			while (left < right) {

				// Calculate the sum of the three numbers
				int sum = first_num + array[left] + array[right];

				// Found a valid triplet
				if (sum == 0) {

					ArrayList<Integer> triplet =
							new ArrayList<>(
									List.of(first_num, array[left], array[right])
							);

					result.add(triplet);

					// Skip duplicate left values
					while (left < right && array[left] == array[left + 1]) {
						left++;
					}

					// Skip duplicate right values
					while (left < right && array[right] == array[right - 1]) {
						right--;
					}

					// Move both pointers after finding a triplet
					left++;
					right--;
				}

				// Sum is too small, increase left pointer
				else if (sum < 0) {
					left++;
				}

				// Sum is too large, decrease right pointer
				else {
					right--;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {

		int[] array = {-1, 0, 1, 2, -1, -4};

		System.out.println("--- Input Array ---");
		System.out.println("[-1, 0, 1, 2, -1, -4]");

		System.out.println("\n--- HashSet Approach ---");
		System.out.println("Time Complexity: O(n²)");
		System.out.println("Space Complexity: O(n²) including output");
		System.out.println("Result: " + threeSum_Set(array));

		System.out.println("\n--- Two Pointer Approach ---");
		System.out.println("Time Complexity: O(n²)");
		System.out.println("Space Complexity: O(1) excluding output");
		System.out.println("Result: " + threeSum_Pointer(array));
	}
}
