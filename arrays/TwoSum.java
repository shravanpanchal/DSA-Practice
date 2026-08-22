/*
 * TWO SUM
 *
 * Given an array of integers nums and a target,
 * find the indices of two numbers whose sum is equal
 * to the target.
 *
 * We cannot use the same element twice.
 * There is exactly one valid answer.
 *
 * Example:
 * num = {2, 7, 11, 15}
 * target = 9
 *
 * 2 + 7 = 9
 * Answer = (0, 1)
 *
 * Constraints:
 * 2 <= nums.length <= 10^4
 * -10^9 <= num[i], target <= 10^9
 */


package arrays;

import java.util.HashMap;
import java.util.Arrays;



public class TwoSum {

	// APPROACH 1: Brute Force
	// Check every possible pair.
	// Time: O(n^2), Space: O(1)

	public int[] twoSumBrute(int[] nums, int target) {

		for (int i = 0; i < nums.length - 1; i++) {

			for (int j = i + 1; j < nums.length; j++) {

				int x = target - nums[i];

				if (nums[j] == x) {
					return new int[] {i, j};
				}
			}
		}
        return new int[] {-1, -1};

	}


	/*
	 * APPROACH 2: HashMap - Two Pass
	 *
	 * First pass: put all numbers and their indices into the map.
	 * Second pass: search for the required number.
	 *
	 * Time: O(n), Space: O(n)
	 */
	public int[] twoSumTwoPass(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();

		// Pass 1: Store all numbers and their indices.
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		// Pass 2: Search for the required number.
		for (int i = 0; i < nums.length - 1; i++) {

			int x = target - nums[i];

			if (map.containsKey(x) && map.get(x) > i) {
				return new int[] {i, map.get(x)};
			}
		}
		throw new IllegalArgumentException("No solution found");


	}

	/*
	 * APPROACH 3: HashMap - One Pass
	 *
	 * Unlike the previous approach, we don't build the
	 * complete map first.
	 *
	 * For each number:
	 * 1. Check if its required pair is already in the map.
	 * 2. If not, store the current number and its index.
	 *
	 * So lookup + storing happen in the SAME loop.
	 *
	 * Time: O(n), Space: O(n)
	 */
	public int[] twoSumOptimal(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			int x = target - nums[i];

			if (map.containsKey(x)) {
				return new int[] {map.get(x),i};
			}
			else {
				map.put(nums[i], i);
			}		

		}
		throw new IllegalArgumentException("No solution found");

	}
		public static void main(String args[]) {
			
			int[] nums = {15, 7, 2, 11};
			int target = 9;
			TwoSum obj = new TwoSum();
			int[] result1 = obj.twoSumBrute(nums, target);
			int[] result2 = obj.twoSumTwoPass(nums, target);
			int[] result3 = obj.twoSumOptimal(nums, target);
			
			System.out.println("Brute Force O(n^2)");
			System.out.println(Arrays.toString(result1));
			System.out.println("\nHashMap - Two Pass O(n)");
			System.out.println(Arrays.toString(result2));
			System.out.println("\nHashMap - One Pass O(n)");
			System.out.println(Arrays.toString(result3));
			
		}

		
	}