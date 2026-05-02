import java.util.*;


public class Main
{
	public static void main(String[] args) {
// 		System.out.println("Hello World");
        
        // System.out.println(decimalToBinary(7));
        // System.out.println(decimalToBinary(13));
        
        // System.out.println(binaryToDecimal("1101"));
        
        // System.out.println(isBitSet(13, 2));
        // System.out.println(setBit(9, 2));
        // System.out.println(clearBit(13, 2));
        // System.out.println(toggleBit(13, 2));
        
        // System.out.println(isPowerOf2(13));
        // System.out.println(isPowerOf2(16));
        // System.out.println(isPowerOf2(64));
        
        // System.out.println(countSetBits(13));
        
        // int[] nums = {1, 2, 3};
        // System.out.println(powerSet(3, nums));
        
        // int[] nums = {4, 1, 2, 1, 2};
        // System.out.println(singleNumberI(nums));
        
        // int[] nums = {5, 5, 2, 4, 4, 4, 5};
        // System.out.println(singleNumberII(7, nums));
        
        // System.out.println(xorInRange(10));
        
        System.out.println(divideWithoutOperator(28, 7));
	}
	
	// T.C. = O(logN)
	// S.C. = O(logN)
	static String decimalToBinary(int n) {
	    if (n == 0) {
            return "0";
        }
        
	    StringBuilder binary = new StringBuilder("");
	    
	    while (n > 0) {
	        int digit = n % 2;
	        binary.append(digit);
	        n /= 2;
	    }
	    
	    String result = binary.reverse().toString();
	    
	    return result;
	}
	
	// T.C. = O(N)
	static int binaryToDecimal(String binary) {
	    int result = 0, pow2 = 1;
	    int len = binary.length();
	    
	    for (int i = len-1; i >= 0; i--) {
	        if (binary.charAt(i) == '1') {
	            result += pow2;
	        }
	        pow2 *= 2;
	    }
	    
	    return result;
	}
	
	static void swap(int a, int b) {
	    // Bruteforce
	    int temp = a;
	    a = b;
	    b = temp;
	    
	    // Optimal
	    a = a ^ b;
	    b = a ^ b;
	    a = a ^ b;
	}
	
	static boolean isBitSet(int n, int i) {
	    // Bruteforce
	    // 1. Convert decimal to binary 
	    // 2. Traverse till ith bit 
	    
	    // Optimal using Bitwise operators
	    
	    // using left shift operator
	   // int value = n & (1 << i);
	   // if (value > 0) return true;
	   // return false;
	    
	    // using right shift operator
	    int value = (n >> i) & 1;
	    if (value > 0) return true; // value will be always 1 if the bit is set
	    return false;
	}
	
	static int setBit(int n, int i) {
	    // Bruteforce
	    // 1. Convert decimal to binary 
	    // 2. Change the bit 
	    // 3. COnvert into the decimal again
	    
	    // Optimal
	    return n | (1 << i);
	}
	
	static int clearBit(int n, int i) {
	    // Bruteforce
	    // 1. Convert decimal to binary 
	    // 2. Change the bit 
	    // 3. COnvert into the decimal again
	    
	    // Optimal
	    return n & ~(1 << i);
	}
	
	static int toggleBit(int n, int i) {
	    // Bruteforce
	    // 1. Convert decimal to binary 
	    // 2. Change the bit 
	    // 3. COnvert into the decimal again
	    
	    // Optimal
	    return n ^ (1 << i);
	}
	
	static int clearRighmostSetBit(int n) {
	    // Bruteforce
	    // 1. Convert decimal to binary 
	    // 2. Change the bit 
	    // 3. COnvert into the decimal again
	    
	    // Optimal
	    return n & (n-1);
	}
	
	static boolean isPowerOf2(int n) {
	    // Bruteforce
	    // 1. Convert decimal to binary 
	    // 2. For a power of 2, there should be exactly one set bit 
	    
	    // Optimal
	    if ((n & (n-1)) == 0) return true;
	    return false;
	}
	
	static int countSetBits(int n) {
	    // Bruteforce
	    // 1. Convert decimal to binary 
	    // 2. Count the set bits
	    
	    int count = 0;
	    
	    // Better
	   // while (n > 1) {
	   //     if (n % 2 == 1) count++;
	   //     n /= 2;
	   // }
	   // if (n == 1) count++;
	    
	    // Optimal 1 
	   // while (n > 1) {
	   //     count += n & 1;
	   //     n = n >> 1;
	   // }
	   // if (n == 1) count++;
	   
	   // Optimal 2
	   while (n != 0) {
	       n = n & (n-1);
	       count++;
	   }
	    
	   return count;
	}
	
	static int bitsToChange(int start, int goal) {
	    int ans = start ^ goal;
	    int count = 0;
	    
	    while (ans != 0) {
	        ans = ans & (ans-1);
	        count++;
	    }
	    
	    return count;
	}
	
	static List<List<Integer>> powerSet(int n, int[] nums) {
	    // Bruteforce - using Recursion
	    
	    // Optimal - using Bit Manipulation
	    // TC = O(2^n x n)
	    // SC = O(2^n x n)
	    List<List<Integer>> result = new ArrayList<>();
	    int subsets = 1 << n; // this equals 2^n subsets
	    
	    for (int i = 0; i < subsets; i++) {
	        List<Integer> subset = new ArrayList<>();
	        
	        for (int j = 0; j < n; j++) {
	            // checking for a subset binary e.g. 1000 if nums[j] is set or not
	            // if nums[j] is set in a subset (i) binary, it is added in that subset 
	            if ((i & (1 << j)) != 0) subset.add(nums[j]);
	        }
	        
	        result.add(subset);
	    }
	    
	    return result;
	}
	
	static int singleNumberI(int[] nums) {
	    // Very Bruteforce = using for loops
	    
	    // Bruteforce = using Map
	    // TC = O(n+m) where m = n/2 + 1 
	    // SC = O(m)
	    
	    // Optimal 
	    // TC = O(N)
	    // SC = O(1)
	    int result = 0;
	    
	    for (int num: nums) {
	        result ^= num;
	    }
	    
	    return result;
	}
	
	static int singleNumberII(int n, int[] nums) {
	    int result = 0;
	    
	    // Bruteforce - using Map 
	    // TC = O(n + m), where m = n/3 + 1 
	    // SC = O(m)
	    
	    // Better
	    // TC = O(32 x n)
	    // SC = O(1)
	   // for (int bitIdx = 0; bitIdx < 32; bitIdx++) {
	   //     int count = 0;
	        
	   //     for (int i = 0; i < n; i++) {
	   //         if ((nums[i] & (1 << bitIdx)) != 0) count++;
	   //     }
	        
	   //     if (count % 3 == 1) result = result | (1 << bitIdx);
	   // }
	    
	   // return result;
	    
	    // Optimal 
	    // TC = O(nlogn)
	    // SC = O(1)
	   // Arrays.sort(nums);
	   // for (int i = 1; i < n; i += 3) {
	   //     if (nums[i] != nums[i-1]) return nums[i-1];
	   // }
	   // return nums[n-1];
	   
	   // Most Optimal - using Buckets (need to be memorized only)
	   // TC = O(n)
	   // SC = O(1)
	   int ones = 0, twos = 0;
	   for (int i = 0; i < n; i++) {
	       ones = (ones ^ nums[i]) & ~twos;
	       twos = (twos ^ nums[i]) & ~ones;
	   }
	   
	   return ones;
	}
	
	static int xorInRange(int N) {
	   // int xor = 0;
	    
	    // Bruteforce
	    // TC = O(N)
	   // for (int i = 1; i <= N; i++) {
	   //     xor ^= i;
	   // }
	    
	   // return xor;
	    
	    // Optimal - from observations only
	    // TC = O(1)
	    if (N % 4 == 0) return N;
	    else if (N % 4 == 1) return 1;
	    else if (N % 4 == 2) return N+1;
	    else return 0;
	}
	
	static int xorInGivenRange(int L, int R) {
	    int xor = 0;
	    
	    // Bruteforce
	    // TC = O(R-L)
	   // for (int i = L; i <= R; i++) {
	   //     xor ^= i;
	   // }
	    
	   // return xor;
	   
	   // Optimal
	   // TC = O(1)
	   int xorL = xorInRange(L-1);
	   int xorR = xorInRange(R);
	   return xorL ^ xorR;
	}
	
	static int divideWithoutOperator(int dividend, int divisor) {
	    // Bruteforce
	    // TC = O(log(divisor))
	   // int sum = 0, count = 0;
	    
	   // while (sum+divisor <= dividend) {
	   //     sum += divisor;
	   //     count++;
	   // }
	    
	   // return count;
	   
	   // Optimal
	   //please look the Striver video
	}
}
