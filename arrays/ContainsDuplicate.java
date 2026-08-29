/*Contains Duplicate - 217
 * Given an integer array nums, return true if any vale appears at least twice in the array, 
 * and return false if every element is distinct
 */

package arrays;
import java.util.HashSet;



public class ContainsDuplicate {
	
	/*
	 * APPROACH: HashSet
	 *
	 * Store each number in a HashSet.
	 * If add() returns false, the number already exists,
	 *
	 * Time Complexity: O(n) average
	 *
	 * Space Complexity: O(n)
	 */

	
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			else {
				set.add(nums[i]);
			}

		}
		return false;
	}
	public static void main(String args[]) {
		int[] nums = {1, 4, 3, 5};
		ContainsDuplicate obj = new ContainsDuplicate();
		System.out.println(obj.containsDuplicate(nums));

	}
}

