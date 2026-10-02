/*
 * Two Sum II - Input Array Is Sorted - 167
 *
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, 
 * find two numbers such that they add up to a specific target number.
 */

package twoPointers;

public class TwoSum_II {

	/*
	 * APPROACH: Two-Pointer Approach (Optimized)
	 *
	 * Time Complexity: O(N) where N is the length of the array
	 * Space Complexity: O(1)
	 */
	
	public static int[] twoSumII(int[] array, int target) {
        int left = 0;
        int right = array.length - 1; // Fixed: starts at the last valid index
        
        while (left < right) { // Fixed: loop while pointers haven't crossed
            int sum = array[left] + array[right];
            
            if (sum == target) {
                return new int[] { left + 1, right + 1 }; // Return 1-indexed positions
            } else if (sum < target) {
                left++;  // Need a bigger sum, move left pointer right
            } else {
                right--; // Need a smaller sum, move right pointer left
            }
        }
        
        return new int[] {}; // Return empty array if no solution is found
    }
    
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        
        int[] result = twoSumII(numbers, target);
        
        // Prints: [1, 2]
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}