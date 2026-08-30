/*
 * LeetCode 347. Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most
 * frequent elements.
 *
 * You may return the answer in any order.
 *
 * Example:
 *
 * Input:
 * nums = [1, 1, 1, 2, 2, 3]
 * k = 2
 *
 * Output:
 * [1, 2]
 *
 * Explanation:
 * 1 appears 3 times, 2 appears 2 times, and 3 appears 1 time.
 * Therefore, the 2 most frequent elements are [1, 2].
 *
 * Requirements:
 * 1. The answer must contain exactly k elements.
 * 2. The order of the elements does not matter.
 * 3. Try to solve it in better than O(n log n) time.
 */

package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Top_K_Elements {

    /*
     * APPROACH 1: SORTING
     *
     * Steps:
     * 1. Count the frequency of each element.
     * 2. Sort elements based on their frequency.
     * 3. Take the first k elements.
     *
     * Time:
     * O(n + m log m + k)
     *
     * Space:
     * O(m)
     *
     * where:
     * n = total number of elements
     * m = number of distinct elements
     */
    public int[] topK_UsingSorting(int[] arr, int k) {
    	//Handle invalid or empty input
    	if (arr == null || arr.length == 0 || k <= 0) {
    		return new int[0];
    	}
    	//Count frequency of each element
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : arr) {
        		map.put(num, map.getOrDefault(num, 0) + 1);
        	}
        //K cannot be greater than number of Distinct Elements
        if (k > map.size()) {
        	throw new IllegalArgumentException("k cannot be greater than number of distinct elements");
        }
        
        //Convert Map entries to list then sort
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a, b) -> Integer.compare(b.getValue() , a.getValue()));
        
        //Store first k keys
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
       		result[i] = entries.get(i).getKey();
        }
    	
    	
    	return result;
    }


    /*
     * APPROACH 2: MIN HEAP
     *
     * Steps:
     * 1. Count the frequency of each element.
     * 2. Put elements into a Min Heap based on frequency.
     * 3. Keep the heap size limited to k.
     * 4. Extract the k elements.
     *
     * Time:
     * O(n + m log k + k)
     *
     * Space:
     * O(m + k)
     */
    public int[] topK_UsingMinHeap(int[] arr, int k) {
        return null;
    }


    /*
     * APPROACH 3: MAX HEAP
     *
     * Steps:
     * 1. Count the frequency of each element.
     * 2. Put all elements into a Max Heap based on frequency.
     * 3. Extract the maximum k times.
     *
     * Time:
     * O(n + m + k log m)
     *
     * Space:
     * O(m)
     */
    public int[] topK_UsingMaxHeap(int[] arr, int k) {
        return null;
    }


    /*
     * APPROACH 4: BUCKET SORT
     *
     * Steps:
     * 1. Count the frequency of each element.
     * 2. Create buckets where index = frequency.
     * 3. Put each element into its frequency bucket.
     * 4. Traverse buckets from highest frequency to lowest.
     * 5. Stop after collecting k elements.
     *
     * Time:
     * O(n) + O(n) + O(m) + O(n) + O(k)
     *
     * Simplified:
     * O(n)
     *
     * Space:
     * O(n + m)
     */
    public int[] topK_UsingBucket(int[] arr, int k) {
        return null;
    }


    /*
     * APPROACH 5: QUICKSELECT
     *
     * Steps:
     * 1. Count the frequency of each element.
     * 2. Store elements with their frequencies.
     * 3. Use Quickselect to partition around frequency.
     * 4. Take the k most frequent elements.
     *
     * Average Time:
     * O(n + m + m + k)
     *
     * Simplified:
     * O(n)
     *
     * Worst Case:
     * O(n + m²)
     *
     * Space:
     * O(m)
     */
    public int[] topK_UsingQuickSelect(int[] arr, int k) {
        return null;
    }


    public static void main(String[] args) {

        int[] array = {
            1, 11, 11, 2, 3, 6,
            5, 6, 6, 2, 6, 8
        };

        int k = 3;
        Top_K_Elements obj = new Top_K_Elements();
        int[] result = obj.topK_UsingSorting(array, k);
        System.out.print(Arrays.toString(result));
    
}
}
