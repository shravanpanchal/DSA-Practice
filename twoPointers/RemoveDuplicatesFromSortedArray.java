/*
- LeetCode 26: Remove Duplicates from Sorted Array
- 
- Problem Statement:
- Given an integer array sorted in non-decreasing order, remove duplicates 
- such that each unique element appears only once, returning the result.
- 
- Example:
- Input:  [1, 1, 2, 3, 3, 3, 4, 5, 5, 6]
- Output: [1, 2, 3, 4, 5, 6, 0, 0, 0, 0]
 */

package twoPointers;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

	/**
- 	APPROACH 1: Two Pointers (Auxiliary Array)
	 * 
- 	Use a left pointer to track the position in the distinct array and a right 
- 	pointer to scan through the sorted array, skipping over duplicate elements.
	 * 
- 	Time Complexity:  O(n) - Single pass through the array
- 	Space Complexity: O(n) - Auxiliary array of size n to store distinct elements
	 */
	public static int[] remDuplicates(int[] array) {
		int[] distinct = new int[array.length];
		int right = 1;
		int left = 1;
		distinct[0] = array[0];
		
		while (right < array.length) {
			
			while (right < array.length && distinct[left - 1] == array[right]) {
				right++;
			}
			
			distinct[left] = array[right];
			left++;
			right++;
		}
		
		return distinct;
	}
	
	public static void main(String[] args) {
		int[] sortedNumbers = {1, 1, 2, 3, 3, 3, 4, 5, 5, 6};
		
		System.out.println("LeetCode 26: Remove Duplicates from Sorted Array");
		System.out.println("Input: [1, 1, 2, 3, 3, 3, 4, 5, 5, 6]");
		System.out.println("==================================================");
		
		System.out.println("   Two-Pointer Approach");
		System.out.println("   Time Complexity:  O(n)");
		System.out.println("   Space Complexity: O(n)");
		System.out.println("   Result:           " + Arrays.toString(remDuplicates(sortedNumbers)));
	}
}