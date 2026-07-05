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
		
		int[] arr5 = {1, 2, 3, 4, 5};
		leftRotateByOne(arr5, 5);
		System.out.println(Arrays.toString(arr5));
		
		int[] arr6 = {1, 2, 3, 4, 5, 6, 7};
		leftRotateByK(arr6, 7, 2);
		System.out.println(Arrays.toString(arr6));
		
		int[] arr7 = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
		moveZeroesToEnd(arr7, arr7.length);
		System.out.println(Arrays.toString(arr7));
		
		int[] arr8 = {1, 2, 3, 4, 5};
		int[] arr9 = {2, 3, 4, 4, 5, 6};
		List<Integer> result1 = unionSortedArrays(arr8, arr9, 5, 6);
		System.out.println(result1);
		
		int[] arr10 = {1, 2, 2, 3, 3, 4, 5, 6};
		int[] arr11 = {2, 3, 3, 5, 6, 6, 7};
		List<Integer> result2 = intersectionSortedArrays(arr10, arr11, 8, 7);
		System.out.println(result2);
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
	
	static void leftRotateByOne(int[] arr, int n) {
	    int temp = arr[0];
	    
	    for (int i = 0; i < n-1; i++) {
	        arr[i] = arr[i+1];
	    }
	    arr[n-1] = temp;
	}
	
	static void leftRotateByK(int[] arr, int n, int k) {
	    k = k % n;
	    
	    // Bruteforce - using a temporary array
	    // TC = O(k) + O(n-k) + O(k) = O(n+k)
	    // SC = O(k)
	   // int[] temp = new int[k];
	   // for (int i = 0; i < k; i++) {
	   //     temp[i] = arr[i];
	   // }
	   // for (int i = k; i < n; i++) {
	   //     arr[i-k] = arr[i];
	   // }
	   // for (int i = n-k; i < n; i++) {
	   //     arr[i] = temp[i-(n-k)];
	   // }
	    
	    // Optimal - 
	    reverse(arr, 0, k-1);
	    reverse(arr, k, n-1);
	    reverse(arr, 0, n-1);
	    
	}
	
	static void reverse(int[] arr, int start, int end) {
	    while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
	}
	
	static void swap(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	
	static void rightRotateByK(int[] arr, int n, int k) {
	    k = k % n;
	    
	    reverse(arr, n-k, n-1);
	    reverse(arr, 0, n-k-1);
	    reverse(arr, 0, n-1);
	}
	
	static void moveZeroesToEnd(int[] arr, int n) {
	    // Bruteforce
	    // TC = O(n)
	    // SC = O(n)
	   // List<Integer> temp = new ArrayList<>();
	    
	   // for (int i: arr) {
	   //     if (i != 0) temp.add(i);
	   // }
	   // for (int i = 0; i < temp.size(); i++) {
	   //     arr[i] = temp.get(i);
	   // }
	   // for (int i = temp.size(); i < n; i++) {
	   //     arr[i] = 0;
	   // }
	    
	    // Optimal
	    // TC = O(m) + O(n-k)
	    // m = the index at first 0
	    // k = no of zeroes
	    int i = -1, j = -1;
	    for (int k = 0; k < n; k++) {
	        if (arr[k] == 0) {
	            i = k;
	            j = k+1;
	            break;
	        }
	    }
	    
	    if (i == -1) return;
	    
	    for (int k = j; k < n; k++) {
	        if (arr[k] != 0) {
	            swap(arr, i, k);
	            i++;
	        }
	    }
	}
	
	// TC = O(N)
	static int linearSearch(int[] arr, int n, int k) {
	    for (int i = 0; i < n; i++) {
	        if (arr[i] == k) return i;
	    }
	    
	    return -1;
	}
	
	// Optimal
	// TC = O(min(n1, n2)) + O((n1+n2) - min(n1, n2)) = O(n1+n2)
	// SC = O(n1+n2) for result, O(1) for extra
	static List<Integer> unionSortedArrays(int[] arr1, int[] arr2, int n1, int n2) {
	    List<Integer> unionList = new ArrayList<>();
	    int i = 0, j = 0;
	    
	    while (i < n1 && j < n2) {
	        if (arr1[i] <= arr2[j]) {
	            if (unionList.isEmpty() || unionList.get(unionList.size()-1) != arr1[i]) unionList.add(arr1[i]);
	            i++;
	        } else {
	            if (unionList.isEmpty() || unionList.get(unionList.size()-1) != arr2[j]) unionList.add(arr2[j]);
	            j++;
	        }
	    }
	    
	    while (i < n1) {
	        if (unionList.isEmpty() || unionList.get(unionList.size()-1) != arr1[i]) unionList.add(arr1[i]);
	        i++;
	    }
	    while (j < n2) {
	        if (unionList.isEmpty() || unionList.get(unionList.size()-1) != arr2[j]) unionList.add(arr2[j]);
	        j++;
	    }
	    
	    return unionList;
	}
	
	// Optimal
	// TC = O(n1+n2)
	// SC = O(n1+n2) for result, O(1) for extra
	static List<Integer> intersectionSortedArrays(int[] arr1, int[] arr2, int n1, int n2) {
	    List<Integer> intersectionList = new ArrayList<>();
	    int i = 0, j = 0;
	    
	    while (i < n1 && j < n2) {
	        if (arr1[i] == arr2[j]) {
	            intersectionList.add(arr1[i]);
	            i++;
	            j++;
	        } 
	        else if (arr1[i] < arr2[j]) i++;
	        else j++;
	    }
	    
	    return intersectionList;
	}
}
