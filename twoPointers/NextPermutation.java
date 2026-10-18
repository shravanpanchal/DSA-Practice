/*
- Problem: Next Permutation
 *
- Given an array of integers, rearrange it into the lexicographically next greater permutation of numbers.
- If such an arrangement is not possible, it must be rearranged as the lowest possible order (sorted in ascending order).
 *
- Example:
- Input  : [2, 5, 4, 3, 1]
- Output : [3, 1, 2, 4, 5]
 *
- Approach:
- Find the pivot (first element from the right smaller than its next element),
- find its successor to swap, and reverse the remaining suffix to obtain the next permutation.
 */


package twoPointers;


import java.util.Arrays;

public class NextPermutation {

    public static int[] findNextPermutation(int[] nums) {
        int n = nums.length;
        int pivotIndex = -1;

        // Step 1: Find the pivot (first element from the right smaller than its next element)
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pivotIndex = i - 1;
                break;
            }
        }

        // If no pivot is found, the array is strictly descending; reverse it to the start
        if (pivotIndex == -1) {
            reverse(nums, 0, n - 1);
            return nums;
        }

        // Step 2: Find the successor to the pivot from the right and swap them
        for (int i = n - 1; i > pivotIndex; i--) {
            if (nums[i] > nums[pivotIndex]) {
                int temp = nums[i];
                nums[i] = nums[pivotIndex];
                nums[pivotIndex] = temp;
                break;
            }
        }

        // Step 3: Reverse the suffix starting from pivotIndex + 1
        reverse(nums, pivotIndex + 1, n - 1);

        return nums;
    }

    // Helper method to reverse a portion of the array in-place
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 4, 3, 1};

		System.out.println("Input  : " + Arrays.toString(nums));
		System.out.println("Output : " + Arrays.toString(findNextPermutation(nums)));
	}
}