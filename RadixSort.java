import java.io.*;
import java.util.*;

class RadixSort {
	public static int comparisons = 0;
	public static int movements = 0;
	static int getMax(int arr[], int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++)
		{
			comparisons++;
			if (arr[i] > mx)
			{
				mx = arr[i];
				comparisons++;
				movements++;
			}
		}
		return mx;
	}

	static void countSort(int arr[], int n, int exp) {
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		for (i = 0; i < n; i++)
		{
			count[(arr[i] / exp) % 10]++;
			comparisons++;
		}
		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++)
		{
			count[i] += count[i - 1];
			movements++;
			comparisons++;
		}
		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
			movements++;
			comparisons++;
		}
		for (i = 0; i < n; i++)
		{
			arr[i] = output[i];
			movements++;
			comparisons++;
		}
	}

	static void radixsort(int arr[], int n) { // Find the maximum number to know number of digits
		int m = getMax(arr, n);
		for (int exp = 1; m / exp > 0; exp *= 10)
		{
			countSort(arr, n, exp);
		}
	}

	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
	
	public static int[] returnCompareAndMovement()
	{
		int[] result = new int[2];
		result[0] = comparisons;
		result[1] = movements;
		return result;
	}
	
	//test method
	public static void main(String[] args) {
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		int n = arr.length;
		radixsort(arr, n);
		print(arr, n);
	}
	
}