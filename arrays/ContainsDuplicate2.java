/*
 * Contains Duplicate II - 219
 *
 * Given an integer array nums and an integer k, return true if there are
 * two distinct indices i and j in the array such that:
 *
 * nums[i] == nums[j]
 * and
 * abs(i - j) <= k.
 */

package arrays;

import java.util.HashSet;
import java.util.HashMap;

public class ContainsDuplicate2 {

    /*
     * APPROACH: Brute Force
     *
     * For every element, check the next k elements.
     * If any element matches, return true.
     *
     * Time Complexity: O(n * k)
     * - For every element, we can check up to k elements.
     * - In the worst case, when k is close to n, it becomes O(n^2).
     *
     * Space Complexity: O(1)
     */
    public boolean ContainsDuplicateBrute(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1;
                 j <= i + k && j < nums.length;
                 j++) {

                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }


    /*
     * APPROACH: HashSet + Sliding Window
     *
     * Maintain a HashSet containing the previous k elements.
     *
     * Time Complexity: O(n) average
     * Space Complexity: O(k)
     * - The HashSet stores at most k elements in the sliding window.
     */
    public boolean ContainsDuplicateSlidingWindow(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (i > k) {
                set.remove(nums[i - k - 1]);
            }

            if (!set.add(nums[i])) {

                // set.add() returns true if the value is not
                // already present and adds it to the set.
                //
                // It returns false if the value is already
                // present, meaning we found a duplicate.

                return true;
            }
        }

        return false;
    }


    /*
     * APPROACH: HashMap + Last Index
     *
     * Store each number along with its most recent index.
     * If the number already exists, calculate the distance
     * between the current index and its previous index.
     *
     * Time Complexity: O(n) average
     * Space Complexity: O(n)
     * - The HashMap can store up to n distinct elements.
     */
    public boolean ContainsDuplicateHashMap(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            Integer prevIndex = map.get(nums[i]);

            // Integer is used instead of int because Integer
            // can store null when the key is not present.
            //
            // If the key exists and the distance between the
            // current and previous index is <= k, we found a match.
            if (prevIndex != null && i - prevIndex <= k) {
                return true;
            }

            // Store the current index as the most recent index
            // for this number.
            map.put(nums[i], i);
        }

        return false;
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 1, 4};
        int k = 4;

        ContainsDuplicate2 obj = new ContainsDuplicate2();

        System.out.println("Brute Force");
        System.out.println("Time Complexity: O(n * k)");
        System.out.println(obj.ContainsDuplicateBrute(nums, k));

        System.out.println("\nHashSet + Sliding Window");
        System.out.println("Time Complexity: O(n) average");
        System.out.println("Space Complexity: O(k)");
        System.out.println(obj.ContainsDuplicateSlidingWindow(nums, k));

        System.out.println("\nHashMap + Last Index");
        System.out.println("Time Complexity: O(n) average");
        System.out.println("Space Complexity: O(n)");
        System.out.println(obj.ContainsDuplicateHashMap(nums, k));
    }
}
