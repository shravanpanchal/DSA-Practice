/*
 * Longest Consecutive Sequence - 128
 *
 * Given an unsorted integer array nums, return the length
 * of the longest consecutive elements sequence.
 */

package arrays;

import java.util.HashSet;
import java.util.Arrays;

public class Longest_Consecutive_Siquence {


    /*
     * APPROACH: Brute Force
     *
     * For every number, keep checking if the next consecutive
     * number exists in the array.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static int LCS_BruteForce(int[] array) {

        int length = 0;

        for (int i = 0; i < array.length; i++) {

            int current = array[i];
            int count = 1;

            // Check for next consecutive numbers.
            while (contains(array, current + 1)) {
                current++;
                count++;
            }

            // Store the longest sequence.
            length = Math.max(count, length);
        }

        return length;
    }


    /*
     * Checks if a number exists in the array.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static boolean contains(int[] array, int num) {

        for (int i = 0; i < array.length; i++) {

            if (array[i] == num) {
                return true;
            }
        }

        return false;
    }


    /*
     * APPROACH: Sorting
     *
     * Sort the array and compare adjacent elements.
     * Skip duplicates and reset when the sequence breaks.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(log n)
     */
    public static int LCS_Sort(int[] array) {

        if (array.length == 0) {
            return 0;
        }

        int longest = 1;
        int currentlength = 1;

        // Sort the array.
        Arrays.sort(array);

        for (int i = 1; i < array.length; i++) {

            // Skip duplicates.
            if (array[i] == array[i - 1]) {
                continue;
            }

            // Consecutive number.
            if (array[i] == array[i - 1] + 1) {
                currentlength++;
            }

            // Sequence break.
            else {
                currentlength = 1;
            }

            // Store the longest sequence.
            longest = Math.max(currentlength, longest);
        }

        return longest;
    }


    /*
     * APPROACH: HashSet
     *
     * Store all numbers in a HashSet.
     * Start a sequence only when num - 1 is not present.
     *
     * Time Complexity: O(n) average
     * Space Complexity: O(n)
     */
    public static int LCS_Set(int[] array) {

        int longest = 0;

        HashSet<Integer> set = new HashSet<>();

        // Add all numbers to the set.
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }

        for (int num : set) {

            /*
             * If num - 1 doesn't exist, num is the
             * start of a consecutive sequence.
             */
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 0;

                // Count consecutive numbers.
                while (set.contains(current)) {
                    length++;
                    current++;
                }

                // Store the longest sequence.
                longest = Math.max(length, longest);
            }
        }

        return longest;
    }


    public static void main(String[] args) {

        int[] nums = {
            110, 100, 5, 6, 20,
            2, 55, 3, 1, 4
        };


        System.out.println("Brute Force");
        System.out.println("Time Complexity: O(n^2)");
        System.out.println("Space Complexity: O(1)");
        System.out.println(LCS_BruteForce(nums));


        System.out.println("\nSorting");
        System.out.println("Time Complexity: O(n log n)");
        System.out.println("Space Complexity: O(log n)");
        System.out.println(LCS_Sort(nums));


        System.out.println("\nHashSet");
        System.out.println("Time Complexity: O(n) average");
        System.out.println("Space Complexity: O(n)");
        System.out.println(LCS_Set(nums));
    }
}
