/*
 * Sliding Window Maximum - LeetCode 239
 *
 * You are given an array of integers nums, there is a sliding window of size k 
 * which is moving from the very left of the array to the very right. You can only 
 * see the k numbers in the window. Each time the sliding window moves right by 
 * one position, return the max sliding window.
 *
 * Example:
 * Input: nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3
 * Output: [3, 3, 5, 5, 6, 7]
 */

package slidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class SlidingWindowMaximum {

	/**
	 * APPROACH: Brute Force
	 *
	 * Try every possible window of size k to find the maximum element 
	 * within each individual window by scanning all elements inside it.
	 *
	 * Time Complexity: O(n * k)
	 * Space Complexity: O(n - k + 1) for the result list (O(1) auxiliary)
	 */
	public static ArrayList<Integer> windowMaxBrute(int[] array, int k) {
		if (array == null || array.length == 0 || k <= 0) {
			return new ArrayList<>();
		}

		int n = array.length;
		ArrayList<Integer> windowMax = new ArrayList<>();
		
		// Iterate through every valid window starting position.
		for (int i = 0; i <= n - k; i++ ) {
			int max = array[i];
			
			// Scan elements within the current window of size k.
			for (int j = i; j < i + k; j++) {
				if (array[j] > max) {
					max = array[j];
				}
			}
			windowMax.add(max);
		}
		return windowMax;
	}
	
	/**
	 * APPROACH: Optimal Sliding Window Maximum using a Monotonic Deque
	 * 
	 * Instead of rechecking every element in every window, we maintain a deque 
	 * that stores the indices of elements in descending order of their values.
	 * 
	 * Time Complexity: O(n) - Each element is pushed and popped at most once.
	 * Space Complexity: O(k) for Deque + O(n - k + 1) for the result list.
	 */
	public static ArrayList<Integer> windowMaxOptimal(int[] array, int k) {
		// Edge case validation
		if (array == null || array.length == 0 || k <= 0) {
			return new ArrayList<>();
		}
		
		int n = array.length;
		ArrayList<Integer> windowMax = new ArrayList<>();
		// Deque stores the *indices* of the array elements, not the values directly
		Deque<Integer> que = new ArrayDeque<>();
		
		for (int i = 0; i < n; i++) {
			
			// Step 1: Remove indices that have fallen out of the current sliding window
			if (!que.isEmpty() && que.peekFirst() < i - k + 1) {
				que.pollFirst();
			}
			
			// Step 2: Remove elements from the back that are smaller than the current element
			while (!que.isEmpty() && array[que.peekLast()] < array[i]) {
				que.pollLast();
			}
			
			// Step 3: Add the current element's index to the back of the deque
			que.addLast(i);
			
			// Step 4: Record the maximum for the window once the window reaches size k
			if (i >= k - 1) {
				windowMax.add(array[que.peekFirst()]);
			}
		}
		
		return windowMax;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
		int k = 3;
		
		System.out.println("--- Input Array ---");
		System.out.println("[1, 3, -1, -3, 5, 3, 6, 7], Window Size: " + k);
		
		System.out.println("\n--- Brute Force Approach ---");
		System.out.println("Time Complexity: O(n * k)");
		System.out.println("Space Complexity: O(n - k + 1) for output list (O(1) auxiliary)");
		System.out.println("Result: " + windowMaxBrute(array, k));
		
		System.out.println("\n--- Optimal Approach (Deque) ---");
		System.out.println("Time Complexity: O(n)");
		System.out.println("Space Complexity: O(k) for Deque + O(n - k + 1) for output list");
		System.out.println("Result: " + windowMaxOptimal(array, k));
	}
}