import java.util.*;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 3, 2};
		
		numberCounts(nums, 3);

        // characterHashing("abcdabefc", 4);
	}
	
	static int countNumber(int n, int[] nums) {
	    int count = 0;
	    
	    for (int i = 0; i < nums.length; i++) {
	        if (nums[i] == n) count++;
	    }
	    
	    return count;
	}
	
	static void numberCounts(int[] nums, int q) {
	    // Bruteforce
	    // 1. using the countNumber function for every number in the array / every query number 
	    // TC = O(n x q), q = no of elements in array / no of query
	    
	    // Optimal 1 - using Hashing 
	    // TC = O(q), SC = O(n)
	    int[] hash = new int[11];
	    
	    // Pre-computation
	   // for (int i = 0; i < nums.length; i++) {
	   //     hash[nums[i]] += 1;
	   // }
	    
	   // while (q > 0) {
	   //     int number = sc.nextInt();
	        
	   //     System.out.println(hash[number]);
	   //     q--;
	   // }
	    
	    // Optimal 2 - using HashMap
	    Map<Integer, Integer> hmp = new HashMap<>();
	    // way 1 (traditional)
	   // for (int i = 0; i < nums.length; i++) {
	   //     hmp.put(nums[i], hmp.getOrDefault(nums[i], 0)+1);
	   // }
	    
	    // way 2 - modern, recomended
	   // for (int num : nums) {
       //    hmp.merge(num, 1, Integer::sum);
       //  }
    
        // way 3 
        for (int num : nums) {
            hmp.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }


	    while (q > 0) {
	        int number = sc.nextInt();
	        
	        System.out.println(hmp.getOrDefault(number, 0));
	        q--;
	    }
	}
	
	static void characterHashing(String s, int q) {
	    // Bruteforce - same as previous
	    
	    // Optimal - Hashing 
	    // TC = O(q), SC = O(n)
	    int[] asciiHash = new int[257];
	    
	    for (int i = 0; i < s.length(); i++) {
	        asciiHash[s.charAt(i)] += 1;
	    }
	    
	    while (q > 0) {
	        int character = sc.next().charAt(0);
	        
	        System.out.println(asciiHash[character]);
	        q--;
	    }
	}
}
