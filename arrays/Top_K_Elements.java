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

import java.util.PriorityQueue;


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
    	
    	//Handle invalid or empty list
    	if (arr == null || arr.length == 0|| k <= 0) {
    		return new int[0];
    	}
    	
    	//Count frequency of each element
    	Map<Integer, Integer> map = new HashMap<>();
    	for (int num : arr) {
    		map.put(num, map.getOrDefault(num, 0) + 1);
    	}
    	
    	// k cannot be greaten then the number of distinct elements in the array
    	if (k > map.size()) {
    		throw new IllegalArgumentException("k cannot be greater than number of distinct elements");
    	}
    	
    	//create a heap and insert the map entries w.r.t frequencies
    	PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue() ,b.getValue()));
    	for (Map.Entry<Integer, Integer> entries : map.entrySet())	{
			minHeap.offer(entries);
		// Keep only the top k elements poll the rest
    		if (minHeap.size() > k) {
    			minHeap.poll();
    			
    		}
    	}
    	// Add the result to list
    	
    	int[] result = new int[k];
    	for (int i = 0; i < k; i++) {
    	    result[i] = minHeap.poll().getKey();
    	}
    		
    		
    	
        return result;
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
    	//Handle invalid or empty list
    	if (arr == null || arr.length == 0 || k <= 0) {
    		return new int[0];
    	}
    	
    	//Count the frequency of each element
    	Map<Integer, Integer> map = new HashMap<>();
    	for (int num : arr) {
    		map.put(num, map.getOrDefault(num, 0) + 1);
    	}
    	//k cannot be greater than total number of distinct elements
    	if (map.size() < k) {
    		throw new IllegalArgumentException("k cannot be greater than the total number of distinct elements in array");
    	}
    	//Put elements in MaxHeap
    	PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue() , a.getValue()));
    	maxHeap.addAll(map.entrySet());
    	
    	//Extract the maximum k times
    	int[] result = new int[k];
    	for (int i = 0; i < k; i++) {
    		result[i] = maxHeap.poll().getKey();

    	}
    	
        return result;
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
    	//Handle invalid input and empty array
    	if (arr == null || arr.length == 0 || k <= 0) {
    		return new int[0];
 
    	}
    	
    	//Count frequencies of each element
    	Map<Integer, Integer> frequency = new HashMap<>();
    	for (int num : arr) {
    		frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    		
    	}
    	
    	//k cannot be greater then the total number of distinct elements in the array
    	if (k > frequency.size()) {
    		throw new IllegalArgumentException("K cannot be greater than the total number of distinct elements in the array");
    	}
    	
    	//create buckets
    	ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
    	for (int i = 0; i < arr.length + 1; i++) {
    		bucket.add(new ArrayList<>());
    	}
    	for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
    		
    		int num = entry.getKey();
    		int count = entry.getValue();
    		
    		bucket.get(count).add(num);
    	
    	}
    	
    	//Store top k in result
    	int[] result = new int[k];
    	int index = 0;
    	for (int count = bucket.size() - 1; count >= 0 && index < k; count--) {
    			
    		for (int num : bucket.get(count)) {
    			result[index++] = num;
    			
    			if (index == k) {
    				break;
    			}
    		}
    	}
        return result;
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
     * O(n + m²) → O(n²)
     *
     * Space:
     * O(m)
     */
    public int[] topK_UsingQuickSelect(int[] arr, int k) {

    	//Handle invalid or empty array
    	if (arr == null || arr.length == 0 || k <= 0) {
    		return new int[0];
 
    	}
    	
    	//Count the frequencies of each Element
    	Map<Integer,Integer> frequency = new HashMap<>();
    	for (int nums : arr) {
    		frequency.put(nums, frequency.getOrDefault(nums, 0) + 1);
    	}
    	
    	//k cannot be greater than the number of distinct elements
    	if (k > frequency.size()) {
    		throw new IllegalArgumentException("K cannot be greater than the number of distinct elements in the array");
    	}
    	
    	//Convert Map entries to list
    	ArrayList<Map.Entry<Integer, Integer>> array = new ArrayList<>(frequency.entrySet());
    	
    	int high = array.size() - 1;
    	int low = 0;
    	
    	while (low <= high) {
    		//Choose last element as the pivot
    		int pivot = array.get(high).getValue();
    		int i = low - 1;
    		
    		//Partition the array around pivot
    		for (int j = low; j < high; j++) {
    			if (array.get(j).getValue() < pivot) {
    				i++;
    				Map.Entry<Integer, Integer> temp = array.get(j);
    				array.set(j, array.get(i));
    				array.set(i, temp);
    				
    			}
    		}
    		//Put pivot to it correct position
    		Map.Entry<Integer, Integer> temp = array.get(i + 1);
    		array.set(i+1, array.get(high));
    		array.set(high, temp);
    		
    		int pivotIndex = i + 1;
    		//If index top kth index found return the array from k to end
    		if (array.size() - k == pivotIndex) {
    			break;
    		}
    		//If kth is smaller than pivotIndex index Search in low to pivotIndex - 1
    		if (array.size() - k < pivotIndex) {
    			high = pivotIndex - 1;
    			
    		}
    		//If pivotIndex is smaller than kth index Search in pivotIndex + 1 to high 
    		else {
    			low = pivotIndex + 1;
    		}	
    	}	
    	
    	//Get top K elements
    	int[] result = new int[k];
    	
    	int target = array.size() - k;
     	for (int i = 0; i < k; i++) {
    		result[i] = array.get(target + i).getKey();
  
    	}
    	return result;
     	
    	
    }


    public static void main(String[] args) {

        int[] array = {
            1, 11, 11, 2, 3, 6,
            5, 6, 6, 2, 6, 8
        };

        int k = 3;

        Top_K_Elements obj = new Top_K_Elements();

        // Approach 1: Sorting
        int[] result1 = obj.topK_UsingSorting(array, k);
        System.out.println("Sorting : " + Arrays.toString(result1));

        // Approach 2: Min Heap
        int[] result2 = obj.topK_UsingMinHeap(array, k);
        System.out.println("Min Heap : " + Arrays.toString(result2));

        // Approach 3: Max Heap
        int[] result3 = obj.topK_UsingMaxHeap(array, k);
        System.out.println("Max Heap : " + Arrays.toString(result3));

        // Approach 4: Bucket Sort
        int[] result4 = obj.topK_UsingBucket(array, k);
        System.out.println("Bucket : " + Arrays.toString(result4));
        
        // Approach 5: Quick Select
        int[] result5 = obj.topK_UsingQuickSelect(array, k);
        System.out.println("Quick Select : " + Arrays.toString(result5));
        
        
    }
}
