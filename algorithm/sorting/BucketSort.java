/*
 * BUCKET SORT
 *
 * Bucket Sort distributes elements into different buckets,
 * sorts each bucket, and then combines them.
 *
 * Steps:
 * 1. Create buckets.
 * 2. Put elements into their respective buckets.
 * 3. Sort each bucket.
 * 4. Combine all buckets.
 *
 * Time Complexity:
 * Best/Average: O(n + k)
 * Worst: O(n²)
 *
 * Space Complexity: O(n + k)
 */

package algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class BucketSort {
	public static void bucketSort(int[] arr) {
		int n = arr.length;
		
		//Handle null or empty lists
		if (arr == null || arr.length == 0) {
			return;
		}
		
		//Find max and min values
		int max = arr[0] , min = arr[0];
		
		for (int s : arr) {
			if (max < s) {
				max = s;
			}
			
			if (min > s) {
				min = s;
			}
		}
		
		//Find the range of the array
		int range = max - min + 1;
		
		//Create Buckets
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			buckets.add(new ArrayList<Integer>());
		}
		
		//Insert values into the buckets
		for (int s : arr) {
			int index = ((s - min) * n) / range;
			buckets.get(index).add(s);
		}
		
		//Sort each Bucket 
		for (int i = 0; i < n; i++) {
			Collections.sort(buckets.get(i));
		}
		
		//Combine all bucket values
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int s : buckets.get(i)) {
				arr[index++] = s;
			}
		}
	}
		
		
	
	
	public static void main(String[] args) {
		int[] arr = {1,9,55,22,35,6,55,8,91};
		bucketSort(arr);
		System.out.print(Arrays.toString(arr));
	}
}
