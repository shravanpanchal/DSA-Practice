/*
 * Sliding Window Maximum - 239
 *
 * You are given an array of integers nums, there is a sliding window of size k 
 * which is moving from the very left of the array to the very right. You can only 
 * see the k numbers in the window. Each time the sliding window moves right by 
 * one position, return the max sliding window.
 *
 * Example:
 * Input: nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3
 * Output: [3, 3, 5, 5, 6, 7]
 * Explanation: 
 * Window position                 Max
 * ---------------                 ---
 * [1  3 -1] -3  5  3  6  7        3
 *  1 [3 -1 -3]  5  3  6  7        3
 *  1  3 [-1 -3  5] 3  6  7        5
 *  1  3 -1 [-3  5  3] 6  7        5
 *  1  3 -1 -3 [ 5  3  6] 7        6
 *  1  3 -1 -3  5 [ 3  6  7]       7
 */

package slidingWindow;
import java.util.ArrayList;

public class SlidingWindowMaximum {

	/*
	 * APPROACH: Brute Force
	 *
	 * Try every possible window of size k to find 
	 * the maximum element within each window.
	 *
	 * Time Complexity: O(n * k)
	 * Space Complexity: O(n - k + 1) for the result list
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
	
	public static void main(String[] args) {
		int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
		int k = 3;
		
		System.out.println("Brute Force");
		System.out.println("Time Complexity: O(n * k)");
		System.out.println("Space Complexity: O(n - k + 1)");
		System.out.println(windowMaxBrute(array, k));
	}
}