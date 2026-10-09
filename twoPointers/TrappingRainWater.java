/*
 * Trapping Rain Water - Prefix/Suffix Max Approach
 *
 * Given n non-negative integers representing an elevation map where the 
 * width of each bar is 1, compute how much water it can trap after raining.
 *
 * Example:
 * Input:  [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 * Output: 6
 *
 */

package twoPointers;

public class TrappingRainWater {

	/**
	 * APPROACH: Prefix & Suffix Maximum Arrays
	 *
	 * Precompute the maximum height to the left and right of every bar 
	 * to determine the water level it can hold.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	public static int totalWater_array(int[] array) {
		
		if (array == null || array.length == 0) {
			return 0;
		}

		int n = array.length - 1;
		int amt = 0;
		
		// Arrays to store the maximum height to the left and right of each element
		int[] right_max = new int[array.length];
		int[] left_max = new int[array.length];
		
		// Base cases for boundaries
		left_max[0] = array[0];
		right_max[array.length - 1] = array[array.length - 1];
		
		// Populate left_max and right_max arrays dynamically
		for (int i = 1; i < array.length; i++) {
			left_max[i] = Math.max(array[i], left_max[i - 1]);
			right_max[n - i] = Math.max(array[n - i], right_max[n + 1 - i]);			
		}
		
		// Calculate trapped water for each element (excluding boundary elements)
		for (int i = 1; i < array.length - 1; i++) {
			amt += Math.min(left_max[i], right_max[i]) - array[i];
		}
			
		return amt;
	}
	
	public static void main(String[] args) {
		
		int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		
		System.out.println("--- Input Array ---");
		System.out.println("[0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]");
		
		System.out.println("\n--- Prefix/Suffix Max Approach ---");
		System.out.println("Time Complexity: O(n)");
		System.out.println("Space Complexity: O(n)");
		System.out.println("Result: " + totalWater_array(array));
	}
}