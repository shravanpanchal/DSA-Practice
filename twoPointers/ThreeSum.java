/*
 * Three Sum - HashSet Approach
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

public class ThreeSum {

	/**
	 * APPROACH: HashSet
	 *
	 * Fix the first number and use a HashSet to find the
	 * required third number for every second number.
	 *
	 * Time Complexity: O(n²)
	 * Space Complexity: O(n²)
	 */
	public static ArrayList<ArrayList<Integer>> threeSum(int[] array) {

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

	public static void main(String[] args) {

		int[] array = {-1, 0, 1, 2, -1, -4};

		System.out.println("--- Input Array ---");
		System.out.println("[-1, 0, 1, 2, -1, -4]");

		System.out.println("\n--- HashSet Approach ---");
		System.out.println("Time Complexity: O(n²)");
		System.out.println("Space Complexity: O(n²)");
		System.out.println("Result: " + threeSum(array));
	}
}