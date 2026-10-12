/*
- LeetCode 42: Trapping Rain Water
- 
- Problem Statement:
- Given n non-negative integers representing an elevation map where the width 
- of each bar is 1, compute how much water it can trap after raining.
- 
- Example:
- Input:  [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
- Output: 6
 */

package twoPointers;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {
	
	/**
	 * APPROACH 1: Brute Force
	 * 
	 * For every bar, scan left to find the tallest wall to its left,
	 * scan right to find the tallest wall to its right, and calculate
	 * trapped water as: min(leftMax, rightMax) - height[i].
	 * 
	 * Time Complexity:  O(n^2) - Nested loops for each index
	 * Space Complexity: O(1)   - Only scalar pointers used
	 */
	public static int totalWater_Brute(int[] array) {
		if (array == null || array.length < 3) {
			return 0;
		}

		int amt = 0;
		int n = array.length;
		
		for (int i = 0; i < n; i++) {
			int leftMax = 0, rightMax = 0;
			
			for (int j = 0; j <= i; j++) {
				leftMax = Math.max(leftMax, array[j]);
			}
			
			for (int j = i; j < n; j++) {
				rightMax = Math.max(rightMax, array[j]);
			}
			amt += Math.min(leftMax, rightMax) - array[i];
		}
		
		return amt;
	}

	/**
	 * APPROACH 2: Dynamic Programming (Prefix & Suffix Maximums)
	 * 
	 * Precompute the running maximum height from the left and right in two arrays.
	 * The water trapped above index i is determined directly in O(1) time
	 * via min(left_max[i], right_max[i]) - array[i].
	 * 
	 * Time Complexity:  O(n) - Two passes to populate arrays, one to sum
	 * Space Complexity: O(n) - Two auxiliary arrays of size n
	 */
	public static int totalWater_array(int[] array) {
		if (array == null || array.length < 3) {
			return 0;
		}

		int n = array.length;
		int amt = 0;
		
		int[] left_max = new int[n];
		int[] right_max = new int[n];
		
		left_max[0] = array[0];
		for (int i = 1; i < n; i++) {
			left_max[i] = Math.max(array[i], left_max[i - 1]);
		}

		right_max[n - 1] = array[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			right_max[i] = Math.max(array[i], right_max[i + 1]);
		}
		
		for (int i = 0; i < n; i++) {
			amt += Math.min(left_max[i], right_max[i]) - array[i];
		}
			
		return amt;
	}
	
	/**
	 * APPROACH 3: Two Pointers
	 * 
	 * Maintain left and right pointers moving inward. The bottleneck at any point
	 * is whichever boundary maximum is smaller:
	 * - If array[left] <= array[right], the left side bounds the water level.
	 * - Otherwise, the right side bounds the water level.
	 * 
	 * Time Complexity:  O(n) - Single pass inwards
	 * Space Complexity: O(1) - Constant auxiliary space
	 */
	public static int totalWater_TwoPointer(int[] array) {
		if (array == null || array.length < 3) {
			return 0;
		}
		
		int left = 0, leftMax = 0;
		int right = array.length - 1, rightMax = 0;
		int amt = 0;
		
		while (left < right) {
			if (array[left] <= array[right]) {
				if (array[left] >= leftMax) {
					leftMax = array[left];
				} else {
					amt += leftMax - array[left];
				}
				left++;
			} else {
				if (array[right] >= rightMax) {
					rightMax = array[right];
				} else {
					amt += rightMax - array[right];
				}
				right--;
			}
		}
		
		return amt;
	}
	
	/**
	 * APPROACH 4: Monotonic Decreasing Stack
	 * 
	 * Store indices of bars in decreasing order of height. When a taller bar is found:
	 * 1. Pop the bottom of the basin (`bottomIndex`).
	 * 2. The new stack peek becomes the left wall (`leftIndex`).
	 * 3. The current bar is the right wall (`current`).
	 * 4. Water is computed horizontally layer-by-layer: width * boundedHeight.
	 * 
	 * Time Complexity:  O(n) - Each bar is pushed and popped at most once
	 * Space Complexity: O(n) - Stack stores up to n indices
	 */
	public static int totalWater_Stack(int[] array) {
		if (array == null || array.length < 3) {
			return 0;
		}
		
		int n = array.length;
		int amt = 0;
		Deque<Integer> stack = new ArrayDeque<>();

		for (int current = 0; current < n; current++) {
			while (!stack.isEmpty() && array[current] > array[stack.peek()]) {
				int bottomIndex = stack.pop();
				
				if (stack.isEmpty()) {
					break;
				}
				
				int leftIndex = stack.peek();
				int width = current - leftIndex - 1;
				int boundedHeight = Math.min(array[current], array[leftIndex]) - array[bottomIndex];
				amt += width * boundedHeight;
			}
			stack.push(current);
		}

		return amt;
	}
	
	public static void main(String[] args) {
		int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		
		System.out.println("==================================================");
		System.out.println("LeetCode 42: Trapping Rain Water");
		System.out.println("Input: [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]");
		System.out.println("==================================================");
		
		System.out.println("\n1. Brute Force Approach");
		System.out.println("   Time Complexity:  O(n^2)");
		System.out.println("   Space Complexity: O(1)");
		System.out.println("   Result:           " + totalWater_Brute(array));

		System.out.println("\n2. Dynamic Programming (Prefix/Suffix Max)");
		System.out.println("   Time Complexity:  O(n)");
		System.out.println("   Space Complexity: O(n)");
		System.out.println("   Result:           " + totalWater_array(array));
		
		System.out.println("\n3. Two-Pointer Approach");
		System.out.println("   Time Complexity:  O(n)");
		System.out.println("   Space Complexity: O(1)");
		System.out.println("   Result:           " + totalWater_TwoPointer(array));

		System.out.println("\n4. Monotonic Stack Approach");
		System.out.println("   Time Complexity:  O(n)");
		System.out.println("   Space Complexity: O(n)");
		System.out.println("   Result:           " + totalWater_Stack(array));
		System.out.println("==================================================");
	}
}