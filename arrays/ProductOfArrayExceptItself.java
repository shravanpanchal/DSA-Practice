/*
 * LeetCode 238. Product of Array Except Self
 *
 * Given an integer array nums, return an array answer such that:
 *
 *      answer[i] = product of all elements of nums except nums[i]
 *
 * Requirements:
 * 1. Run in O(n) time.
 * 2. Do NOT use the division operator.
 */

package arrays;

import java.util.Arrays;

public class ProductOfArrayExceptItself {

    // Taking the iterative product of elements to the left and right
    // of the current index, then multiplying them to get the answer.
    public int[] productExceptSelf(int[] arr) {

        int n = arr.length;
        int prod_r = 1, prod_l = 1;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = prod_l;
            prod_l *= arr[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            result[i] *= prod_r;
            prod_r *= arr[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] array = {4, 11, 5, 6, 100, 15};

        ProductOfArrayExceptItself obj = new ProductOfArrayExceptItself();

        String result = Arrays.toString(obj.productExceptSelf(array));

        System.out.println(result);
    }
}