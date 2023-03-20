
public class SelectionSort {
	/** The method for sorting the numbers */
	public static int[] selectionSort(int[] list) { //int[] list?
		int comparisons = 0;
		int movements = 0;
		int[] compareAndMove = new int[2];
		for (int i = 0; i < list.length -1; i++) {
			// Find the minimum in the list[i..list.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;
			
			for (int j = i+1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
				comparisons++;
			}
			
			//	Swap list[i] with list[currentMinIndex[ if necessary
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
				movements++;
			}
			//movements += 3; //i don't know why it is +3
		}
		compareAndMove[0] = comparisons;
		compareAndMove[1] = movements;
		return compareAndMove;
	}
}
