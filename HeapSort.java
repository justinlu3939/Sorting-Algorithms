
public class HeapSort {
	/** Heap sort method */
	public static int comparisons = 0, movements = 0;
	public static <E extends Comparable<E>> int[] heapSort(E[] list) {
		//	Create a Heap of integers
		Heap<E> heap = new Heap<>();
		int[] result = new int[2];
		//	Add elements to the heap
		for (int i = 0; i < list.length; i++)
		{
			heap.add(list[i]);
			comparisons++;
		}
		
		//	Remove elements from the heap
		for (int i = list.length -1; i >= 0; i--)
		{
			list[i] = heap.remove();
			comparisons++;
			movements++;
		}
		result[0] = comparisons;
		result[1] = movements;
		return result;
	}
	
 	/**	A test method */
	/*
	public static void main(String[] args) {
		Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
		heapSort(list);
		for(int i = 0; i < list.length; i++)
			System.out.println(list[i] + " ");
	}
	*/
}
