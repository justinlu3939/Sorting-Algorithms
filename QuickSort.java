public class QuickSort {
	public static int comparisons;
	public static int movements;
	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length-1);
	}
	
	public static void quickSort(int[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			//comparisons++;
			//comparisons += quickSort(list, first, pivotIndex -1);
			//comparisons += quickSort(list, pivotIndex + 1, last);
			quickSort(list, first, pivotIndex -1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	
	/** Partition the array list[first..last] */
	public static int partition(int[] list, int first, int last) {
		int pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; //Index for backward search
		
		while (high > low) {
			// Search forward from left
			while (low <= high && list[low] <= pivot)
			{
				low++;
			    comparisons++;
			}
			
			// Search backward from right
			while (low <= high && list[high] > pivot)
			{
				high--;
				comparisons++;
			}
			
			//	Swap two elements in the list
			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
				movements++;
			}
		}
		
		while (high > first && list[high] >= pivot)
		{
			high--;
			comparisons++;
		}
		
		//	Swap pivot with list[high]
		if (pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot; 
			movements++;
			return high;
		}
		else {
			return first;
		}
	}
	public static int[] returnCompareAndMovement()
	{
		int[] results = new int[2];
		results[0] = comparisons;
		results[1] = movements;
		return results;
	}
}
