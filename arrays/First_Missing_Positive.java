/*
 * First Missing Positive - 41
 *
 * Given an unsorted integer array nums, return the
 * smallest missing positive integer.
 */

package arrays;

import java.util.HashSet;

public class First_Missing_Positive {

    /*
     * APPROACH: Brute Force
     *
     * Check for every positive integer starting from 1 
     * if it exists in the array.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static int firstMissingPositiveBrute(int[] array) {
        int missingpositive = 1;

        // Keep checking if the current positive integer exists in the array.
        while (missingpositive <= array.length) {
            boolean found = false;
            
            // Search through the array for the missing positive.
            for (int i = 0; i < array.length; i++) {
                if (array[i] == missingpositive) {
                    found = true;
                    break;
                }
            }

            // If not found, this is our first missing positive.
            if (!found) {
                return missingpositive;
            }
            missingpositive++;
        }
        
        return missingpositive;
    }
    
    
    /*
     * APPROACH: HashSet
     *
     * Store all numbers in a HashSet and check for 
     * each integer starting from 1 if it is present.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int firstMissingPositiveHash(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        
        // Add all numbers to the set.
        for (int num : array) {
            set.add(num);
        }
        
        // Check for the first missing positive starting from 1.
        for (int i = 1; i <= array.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        
        return array.length + 1;
    }
    
    
    /*
     * APPROACH: Optimal (Cyclic Sort)
     *
     * Place each number at its correct index (nums[i] should be at nums[i] - 1).
     * Then find the first index where the value doesn't match the expected position.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int firstMissingPositiveOptimal(int[] array) {
        
        // Place each positive number at its correct index.
        for (int i = 0; i < array.length; i++) {
            while (array[i] > 0 && array[i] <= array.length && array[array[i] - 1] != array[i]) {
                int correctIndex = array[i] - 1;

                // Swap elements to their correct position.
                int temp = array[i];
                array[i] = array[correctIndex];
                array[correctIndex] = temp;
            }
        }
    
        // Find the first index where the value does not match.
        for (int i = 0; i < array.length; i++) {
            if (array[i] != i + 1) {
                return i + 1;
            }
        }

        return array.length + 1;
    }
    
    
    public static void main(String[] args) {
        int[] nums = {5, 1, -1, 2, 6, 5, 3};

        System.out.println("Brute Force");
        System.out.println("Time Complexity: O(n^2)");
        System.out.println("Space Complexity: O(1)");
        System.out.println(firstMissingPositiveBrute(nums));

        System.out.println("\nHashSet");
        System.out.println("Time Complexity: O(n)");
        System.out.println("Space Complexity: O(n)");
        System.out.println(firstMissingPositiveHash(nums));

        System.out.println("\nOptimal");
        System.out.println("Time Complexity: O(n)");
        System.out.println("Space Complexity: O(1)");
        System.out.println(firstMissingPositiveOptimal(nums));
    }
}