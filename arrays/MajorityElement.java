
/*
 * MAJORITY ELEMENT
 *
 * Given an integer array, find the element that appears
 * more than n / 2 times.
 *
 * Example:
 *
 * nums = {2, 2, 1, 1, 1, 2, 2}
 *
 * Output: 2
 *
 * APPROACH:
 *
 * 1. HashMap
 *    Time: O(n)
 *    Space: O(n)
 *
 * 2. Boyer-Moore Voting Algorithm
 *    Time: O(n)
 *    Space: O(1)
 */

package arrays;

import java.util.Map;
import java.util.HashMap;

public class MajorityElement {


    // ============================================================
    // APPROACH 1: HASHMAP
    //
    // 1. Store each element and its frequency in a HashMap.
    // 2. Traverse the HashMap entries.
    // 3. Find the element with the highest frequency.
    //
    // Time: O(n)
    // Space: O(n)
    // ============================================================

    private static Map<Integer, Integer> count(int[] nums) {

        Map<Integer, Integer> count = new HashMap<>();

        // Count frequency of each element
        for (int num : nums) {

            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        return count;
    }


    public static int majorityElement(int[] nums) {

        Map<Integer, Integer> count = count(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;

        // Find the element with the highest frequency
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {

            if (majorityEntry == null ||
                entry.getValue() > majorityEntry.getValue()) {

                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }


    // ============================================================
    // APPROACH 2: BOYER-MOORE VOTING ALGORITHM
    //
    // 1. Maintain a candidate and a count.
    // 2. If count becomes 0, select the current element as candidate.
    // 3. If current element matches candidate, increment count.
    // 4. Otherwise, decrement count.
    //
    // Time: O(n)
    // Space: O(1)
    // ============================================================

    public static int majorityElementBoyerMoore(int[] nums) {

        int count = 0;
        int candidate = 0;

        for (int num : nums) {

            // Select a new candidate when count becomes 0
            if (count == 0) {

                candidate = num;
            }

            // Increment or decrement count
            if (num == candidate) {

                count++;
            }

            else {

                count--;
            }
        }

        return candidate;
    }


    public static void main(String[] args) {

        int[] nums1 = {2, 2, 1, 1, 1, 2, 2};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};

        // Approach 1: HashMap
        System.out.println(
            "HashMap\n" +
            "Time: O(n)\n" +
            "Space: O(n)\n" +
            "Majority Element: " + majorityElement(nums1)
        );

        // Approach 2: Boyer-Moore Voting Algorithm
        System.out.println(
            "\nBoyer-Moore Voting Algorithm\n" +
            "Time: O(n)\n" +
            "Space: O(1)\n" +
            "Majority Element: " + majorityElementBoyerMoore(nums2)
        );
    }
}
