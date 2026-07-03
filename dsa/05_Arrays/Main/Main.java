import java.util.*;

public class Main
{
	public static void main(String[] args) {
		int[] arr = {3, 2, 1, 5, 2};
		System.out.println(largestElement(arr, 5));
		
		int[] arr1 = {1, 2, 4, 7, 7, 5};
		System.out.println(secondLargest(arr1, 6));
		
		int[] arr2 = {1, 2, 2, 3, 3, 4};
		int[] arr3 = {1, 2, 1, 3, 4};
		System.out.println(checkSorted(arr2, 6));
		System.out.println(checkSorted(arr3, 5));
		
		int[] arr4 = {1, 1, 2, 2, 2, 3, 3};
		System.out.println(removeDuplicatesInplace(arr4, 7));
	}
	
	static int largestElement(int[] arr, int n) {
	    // Bruteforce - Sorting
	    // TC = O(nlogn)
	    
	    // Optimal - TC = O(n)
	    int largest = arr[0];
	    
	    for (int i = 1; i < n; i++) {
	        if (arr[i] > largest) largest = arr[i];
	    }
	    
	    return largest;
	}
	
	static int secondLargest(int[] arr, int n) {
	    // Bruteforce - Sorting 
	    // Iterating from the n-2 till arr[i] != arr[n-1]
	    // TC = O(nlogn + n) = O(nlogn)
	    
	    // Better 
	    // TC = O(n+n) = O(n)
	   // int largest = largestElement(arr, n);
	   // int secondLargest = Integer.MIN_VALUE;
	   // for (int i = 0; i < n; i++) {
	   //     if (arr[i] != largest && arr[i] > secondLargest) secondLargest = arr[i];
	   // }
	   
	   // Optimal - TC = O(n)
	   int largest = arr[0]; 
	   int secondLargest = Integer.MIN_VALUE;
	   for (int i = 0; i < n; i++) {
	       if (arr[i] > largest) {
	           secondLargest = largest;
	           largest = arr[i];
	       }
	       else if (arr[i] > secondLargest && arr[i] != largest) {
	           secondLargest = arr[i];
	       }
	   }
	    
	    return secondLargest;
	}
	
	static boolean checkSorted(int[] arr, int n) {
	    for (int i = 1; i < n; i++) {
	        if (arr[i] < arr[i-1]) return false;
	    }
	    
	    return true;
	}
	
	static int removeDuplicatesInplace(int[] arr, int n) {
	    // Bruteforce 
	   // Set<Integer> seen = new HashSet<>();
	   // int index = 0;
	    
	   // for (int num: arr) {
	   //     if (!seen.contains(num)) {
	   //         seen.add(num);
	   //         arr[index] = num;
	   //         index++;
	   //     }
	   // }
	    
	   // return index;
	    
	    // Optimal
	    int i = 0, j = 1;
	    while (i <= j && j < n) {
	        if (arr[j] != arr[i]) {
	            arr[i+1] = arr[j];
	            i++;
	        }
	        j++;
	    }
	    
	    return i+1;
	}
}
