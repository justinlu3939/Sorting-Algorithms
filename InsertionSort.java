public class InsertionSort {
	/**The method for sorting the numbers */
	public static int[] insertionSort(int[] list) {
		int comparisons = 0;
		int movements = 0;
		int[] compareAndMove = new int[2];
		for (int i = 1; i < list.length; i++) {
			/** Insert list[i] into a sorted sublist list[0..i-1] so that 
			 * 	list[0..i] is sorted
			 */
			int currentElement = list[i];
			int k;
			for (k = i-1; k>= 0 && list[k] > currentElement; k--) {
				list[k+1] = list[k];
				comparisons++;
				movements++;
			}
			
			//insert the current element into list[k + 1]
			list[k + 1] = currentElement;
			comparisons++; //changed from movements
		}
		compareAndMove[0] = comparisons;
		compareAndMove[1] = movements;
		return compareAndMove;
	}
}
