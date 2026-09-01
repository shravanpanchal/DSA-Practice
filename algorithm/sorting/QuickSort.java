/*
 * QUICK SORT
 *
 * Quick Sort is a divide-and-conquer sorting algorithm.
 *
 * Steps:
 * 1. Choose a pivot.
 * 2. Partition the array around the pivot.
 * 3. Recursively sort the left part.
 * 4. Recursively sort the right part.
 *
 * Time Complexity:
 * Best/Average: O(n log n)
 * Worst: O(n²)
 *
 * Space Complexity:
 * Average: O(log n)
 * Worst: O(n)
 */

package algorithm.sorting;

public class QuickSort {
	public static void quickSort(int[] array) {
		if (array == null ||array.length == 0) {
			return;
		}
		quickSort(array, 0, array.length - 1);
	}

    private static void quickSort(int[] arr, int low, int high) {
    	if (low < high) {
    		
    		//Partition the array with respect to pivot and store the pivot Index
    		int pivotIndex= partition(arr, low, high);
    		
    		//Recursively quickSort the left and right sub-arrays
    		
    		//Sort left sub-array
    		quickSort(arr, low, pivotIndex - 1);
    		
    		//Sort right sub-array
    		quickSort(arr,pivotIndex + 1, high);
    		
    	}

    }

    private static int partition(int[] arr, int low, int high) {
    	int pivot = arr[high];
    	int i = low - 1;
    	for (int j = low; j < high; j++) {
    		
    		if (arr[j] <= pivot) {
    			i++;
    			int temp = arr[i];
    			arr[i] = arr[j];
    			arr[j] = temp;
    			
    		}
    		
    	}
    	int temp = arr[i+1];
    	arr[i+1] = arr[high];
    	arr[high] = temp;

        return i + 1;
    }
    
    public static void printArray(int[] arr) {
    	for (int nums : arr) {
    		System.out.print(nums + " ");
    	}
    }

    public static void main(String[] args) {
    	int[] array = {10, 15, 2, 13, 6, 8 ,4, 3, 12, 66 };
    	quickSort(array);
    	printArray(array);
  
    }
}