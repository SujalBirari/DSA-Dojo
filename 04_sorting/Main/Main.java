import java.util.*;

public class Main
{
	public static void main(String[] args) {
		int[] arr = {4, 1, 5, 2, 3};
		
// 		bubbleSort(arr, 5);
// 		System.out.println(Arrays.toString(arr));
		
		selectionSort(arr, 5);
		System.out.println(Arrays.toString(arr));
	}
	
	static void swap(int[] arr, int ind1, int ind2) {
	    int temp = arr[ind1];
	    arr[ind1] = arr[ind2];
	    arr[ind2] = temp;
	}
	
	static void bubbleSort(int[] arr, int n) {
	    for (int i = 0; i < n-1; i++) {
	        boolean isSwapped = false;
	        
	        for (int j = 0; j < n-i-1; j++) {
	            if (arr[j] > arr[j+1]) {
	                swap(arr, j, j+1);
	                isSwapped = true;
	            }
	        }
	        
	        if (!isSwapped) return;
	    }
	}
	
	static void selectionSort(int[] arr, int n) {
	    for (int i = 0; i < n-1; i++) {
	        int smallestIdx = i;
	        
	        for (int j = i+1; j < n; j++) {
	            if (arr[j] < arr[smallestIdx]) {
	                smallestIdx = j;
	            }
	        }
	        
	        swap(arr, i, smallestIdx);
	    }
	}
}
