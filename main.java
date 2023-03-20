import java.util.Scanner;
import java.util.Random;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
public class main {
	public static int[] createRandomArray(int size)
	{
		int[] arr = new int[size];
		Random rand = new Random();
		for(int i = 0; i < size; i++)
		{
			arr[i] = rand.nextInt(1001); //random integers between 0 - 1000
		}
		return arr;
	}
	public static int[] almostOrder(int size) //this function will return an 80% sorted array
	{
		//take out 20% of the arr and add the remainder using createRandomArray
		int[] result = createRandomArray(size);
		int sorted = Math.round(result.length * 0.8f);
		Arrays.sort(result, 0, sorted);
		
		return result;
	}
	//this method is so that it prints out the name of the list property
	public static String listOrder(int list)
	{
		if(list == 1)
		{
			return "InOrder Order";
		}
		else if(list == 2)
		{
			return "Reverse Order";
		}
		else if(list == 3)
		{
			return "Almost Order";
		}
		else if(list == 4)
		{
			return "Random Order";
		}
		return "";
	}
	//this method prints out the name of sorting algorithm used
	public static String sortName(int sortType)
	{
		if(sortType == 1)
		{
			return "Insertion Sort";
		}
		else if(sortType == 2)
		{
			return "Selection Sort";
		}
		else if(sortType == 3)
		{
			return "Quick Sort";
		}
		else if(sortType == 4)
		{
			return "Merge Sort";
		}
		else if(sortType == 5)
		{
			return "Heap Sort";
		}
		else if(sortType == 6)
		{
			return "Radix Sort";
		}
		return "";
	}

	public static void main(String[] args) {
		// the files are automatically linked, no need to import them here
		Scanner in = new Scanner(System.in);
		int[] array = null;
		int[] moveAndCompare = new int[2];
		long startTime = 0, endTime = 0, time = 0;
		try
		{
			System.out.print("1. InOrder\r\n"
					+ "2. ReverseOrder\r\n"
					+ "3. AlmostOrder\r\n"
					+ "4. Random Order\r\n"
					+ "List Properties, select the data type of list you wish to use: ");
			int list = in.nextInt();
			
			System.out.print("1. 5000\r\n"
					+ "2. 15000\r\n"
					+ "3. 50000\r\n"
					+ "Input Size, select the size of list: ");
			int size = in.nextInt();
			
			System.out.print("1. Insertion Sort\r\n"
					+ "2. Selection Sort\r\n"
					+ "3. Quick Sort\r\n"
					+ "4. Merge Sort\r\n"
					+ "5. Heap Sort\r\n"
					+ "6. Radix Sort\r\n"
					+ "Sorting Algorithm, select the sorting algorithm: ");
			int sorting = in.nextInt();
			
			//create the random int[] using the list property and size
			if(size == 1)
			{
				size = 5000;
			}
			else if(size == 2)
			{
				size = 15000;
			}
			else if(size == 3)
			{
				size = 50000;
			}
			
			//implement the list properties
			if(list == 1) //inorder
			{
				array = createRandomArray(size);
				Arrays.sort(array);
			}
			else if(list == 2) //reverse order
			{
				array = createRandomArray(size);
				Arrays.sort(array);
				int[] reverseOrder = new int[size];
				for(int i = 0; i < size; i++)
				{
					reverseOrder[i] = array[size - 1 - i];
				}
				array = reverseOrder;
			}
			else if(list == 3) //almost order
			{
				//80% in order
				array = almostOrder(size);
			}
			else if(list == 4) //random order
			{
				array = createRandomArray(size);
			}
			
			//implement the sorting
			if(sorting == 1) //insertion
			{
				startTime = System.currentTimeMillis();
				moveAndCompare = InsertionSort.insertionSort(array);
				endTime = System.currentTimeMillis();
				time = endTime - startTime;
			}
			else if(sorting == 2) //selection
			{
				startTime = System.currentTimeMillis();
				moveAndCompare = SelectionSort.selectionSort(array);
				endTime = System.currentTimeMillis();
				time = endTime - startTime;
			}
			else if(sorting == 3) //quick
			{
				startTime = System.currentTimeMillis();
				QuickSort.quickSort(array);
				endTime = System.currentTimeMillis();
				time = endTime - startTime;
				moveAndCompare = QuickSort.returnCompareAndMovement();
			}
			else if(sorting == 4) //merge
			{
				startTime = System.currentTimeMillis();
				MergeSort.mergeSort(array);
				endTime = System.currentTimeMillis();
				time = endTime - startTime;
				moveAndCompare = MergeSort.returnCompareAndMovement();
			}
			else if(sorting == 5) //heap
			{
				//if the user picked 5. heap sort, convert the array into a heap and sort
				Integer[] arrHeap = new Integer[size];
				for(int i = 0; i < size; i++)
				{
					arrHeap[i] = array[i];
				}
				// Heap<Integer> arrHeap = new Heap<Integer>(array);
				startTime = System.currentTimeMillis();
				moveAndCompare = HeapSort.heapSort(arrHeap);
				endTime = System.currentTimeMillis();
				time = endTime - startTime;
			}
			else if(sorting == 6) //radix
			{
				startTime = System.currentTimeMillis();
				RadixSort.radixsort(array, sorting);
				endTime = System.currentTimeMillis();
				time = endTime - startTime;
				moveAndCompare = RadixSort.returnCompareAndMovement();
			}
			//print out the results to the console
			System.out.println("Experimental Results:");
			System.out.println("Input Size: " + size);
			System.out.println("Data Type: " + listOrder(list));
			System.out.println("Sort: " + sortName(sorting));
			System.out.println("Comparisons: " + moveAndCompare[0]);
			System.out.println("Movements: " + moveAndCompare[1]);
			System.out.println("Total Time: " + time);
		}
		catch(Exception ex) //catch exceptions
		{
			System.out.println("Program stopped. Error: '" + ex + "' has occured.");
		}
		
	}

}
