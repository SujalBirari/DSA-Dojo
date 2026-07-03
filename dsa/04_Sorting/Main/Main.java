import java.util.*;

public class Main
{
	public static void main(String[] args) {
		int[] arr = {4, 1, 5, 2, 3};
		
// 		bubbleSort(arr, 5);
// 		System.out.println(Arrays.toString(arr));
		
// 		selectionSort(arr, 5);
// 		System.out.println(Arrays.toString(arr));

        // insertionSort(arr, 5);
        // System.out.println(Arrays.toString(arr));
        
        int[] arr2 = {15, 5, 24, 8, 1, 3, 16, 10, 20};
        // mergeSort(arr2, 0, 8);
        // System.out.println(Arrays.toString(arr2));
        
        int[] arr3 = {10, 15, 1, 2, 9, 16, 11};
        int[] arr4 = {7, 6, 10, 5, 9, 2, 1, 15, 7};
        
        quickSort(arr, 0, 4);
        quickSort(arr2, 0, 8);
        quickSort(arr3, 0, 6);
        quickSort(arr4, 0, 8);
        
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
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
	
	static void insertionSort(int[] arr, int n) {
	    for (int i = 1; i < n; i++) {
	       int curr = arr[i];
	       int prev = i-1;
	       
	       while (prev >= 0 && arr[prev] > curr) {
	           arr[prev+1] = arr[prev];
	           prev--;
	       }
	       
	       arr[prev+1] = curr;
	    }
	}
	
	static void mergeSort(int[] arr, int start, int end) {
	    if (start < end) {
	        int mid = start + (end-start)/2;
	        mergeSort(arr, start, mid);
	        mergeSort(arr, mid+1, end);
	        
	        merge(arr, start,mid, end);
	    }
	}
	
	static void merge(int[] arr, int start, int mid, int end) {
	    int[] temp = new int[end-start+1];
	    int i = start, j = mid+1, k = 0;
	    
	    while (i <= mid && j <= end) {
	        if (arr[i] <= arr[j]) {
	            temp[k] = arr[i];
	            i++;
	        } else {
	            temp[k] = arr[j];
	            j++;
	        }
	        k++;
	    }
	    
	    while (i <= mid) {
	        temp[k] = arr[i];
	        i++;
	        k++;
	    }
	    while (j <= end) {
	        temp[k] = arr[j];
	        j++;
	        k++;
	    }
	    
	    for (int ind = start; ind <= end; ind++) {
	        arr[ind] = temp[ind-start];
	    }
	}
	
	static void quickSort(int[] arr, int lb, int ub) {
	    if (lb < ub) {
	        int loc = partition(arr, lb, ub);
	        quickSort(arr, lb, loc-1);
	        quickSort(arr, loc+1, ub);
	    }
	}
	
	static int partition(int[] arr, int lb, int ub) {
	    int pivot = arr[lb];
	    int start = lb, end = ub;
	    
	    while (start < end) {
	        while (start <= ub && arr[start] <= pivot) {
	            start++;
	        }
	        while (end >= lb && arr[end] > pivot) {
	            end--;
	        }
	        
	        if (start < end) {
	            swap(arr, start, end);
	        }
	    }
	    
	    swap(arr, lb, end);
	    
	    return end;
	}
}
