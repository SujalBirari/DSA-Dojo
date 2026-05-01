import java.util.*;

public class Main
{
	public static void main(String[] args) {
// 		System.out.println("Hello World");

        // int N = 77890;
        // extractDigits(N);
        // System.out.println(countDigits(N));
        
        // int countOfN = (int)(Math.log10(N))+1;
        // System.out.println(countOfN);
        
        // System.out.println(reverseNumber(N));
        
        // System.out.println(checkPalindrome(N));
        // System.out.println(checkPalindrome(1331));
        // System.out.println(checkPalindrome(13031));
        
        // System.out.println(isArmstrong(153));
        // System.out.println(isArmstrong(171));
        // System.out.println(isArmstrong(370));
        // System.out.println(isArmstrong(1634));
        
        // System.out.println(printDivisors(36));
        
        // System.out.println(checkPrime(2));
        // System.out.println(checkPrime(3));
        // System.out.println(checkPrime(4));
        // System.out.println(checkPrime(5));
        // System.out.println(checkPrime(18));
        
        // System.out.println(gcd(20, 9));
        // System.out.println(gcd(12, 9));
        // System.out.println(gcd(20, 40));
        
        // System.out.println(printPrimes(30));
        // System.out.println(printPrimes(40));
        // System.out.println(printPrimes(50));
        // System.out.println(printPrimes(71));
        // System.out.println(printPrimes(781));
        // System.out.println(printPrimes(780));
        
        // System.out.println(power(2, 5));
        // System.out.println(power(2, 21));
        // System.out.println(power(3, 9));
        // System.out.println(power(2, -5));
        // System.out.println(power(2, 2.5));
        
        // printPrimesTillN(10);
        
        // List<List<Integer>> queries = new ArrayList<>();
        // List<Integer> query1 = List.of(3, 10);
        // List<Integer> query2 = List.of(8, 20);
        // List<Integer> query3 = List.of(1, 5);
        // queries.add(query1);
        // queries.add(query2);
        // queries.add(query3);
        
        // System.out.println(printPrimesRange(queries));
        
        
        List<Integer> queries = List.of(12, 16, 60);
        
        System.out.println(primeFactorization(queries));
	}
	
	static void extractDigits(int n) {
	    while (n > 0) {
	        int digit = n % 10;
	        System.out.println(digit);
	        n /= 10;
	    }
	}
	
	static int countDigits(int n) {
	    int count = 0;
	    
	    while (n > 0) {
	        count++;
	        n /= 10;
	    }
	    
	    return count;
	}
	
	static int reverseNumber(int n) {
	    int reverse = 0;
	    
	    while (n > 0) {
	        int digit = n % 10;
	        reverse = (reverse*10) + digit;
	        n /= 10;
	    }
	    
	    return reverse;
	}
	
	static boolean checkPalindrome(int n) {
	    int reverse = 0, temp = n;
	    
	    while (temp > 0) {
	        int digit = temp % 10;
	        reverse = (reverse*10) + digit;
	        temp /= 10;
	    }
	    
	    return reverse == n;
	}
	
	static boolean isArmstrong(int n) {
	    int sum = 0, temp = n;
	    int noOfDigits = (int)(Math.log10(n)) + 1;
	    
	    while (temp > 0) {
	        int digit = temp % 10;
	        sum += Math.pow(digit, noOfDigits);
	        temp /= 10;
	    }
	    
	    return sum == n;
	}
	
	static List<Integer> printDivisors(int N) {
	    // Bruteforce - T.C = O(N)
	   // for (int i = 1; i <= N; i++) {
	   //     if (N % i == 0) System.out.println(i);
	   // }
	   
	   List<Integer> result = new ArrayList<>();
	    
	    // Optimal - T.C. = O(Math.sqrt(N))
	    for (int i = 1; i*i <= N; i++) {
	        if (N % i == 0) {
	            result.add(i);
	            if (N/i != i) result.add(N/i);
	        }
	    }
	    
	    result.sort(null);
	    
	    return result;
	}
	
	static boolean checkPrime(int N) {
	    int count = 0;
	    
	    // Bruteforce O(N)
	   // for (int i = 1; i <= N; i++) {
	   //     if (N % i == 0) count++;
	   // }
	    
	    // Optimal 
	    for (int i = 1; i*i <= N; i++) {
	        if (N % i == 0) {
	            count++;
	            if (N/i != i) count++;
	        }
	    }
	    
	    if (count == 2) return true;
	    
	    return false;
	}
	
	static int gcd(int n1, int n2) {
	   // int gcd = 1;
	    
	    // Extreme Bruteforce -> Running till max of n1, n2
	    
	    // Bruteforce -> Running till min of n1, n2 | T.C = O(min(n1, n2))
	   // int min = n1;
	   // if (n2 < n1) min = n2;
	    
	   // for (int i = 1; i <= min; i++) {
	   //     if (n1%i == 0 && n2%i == 0) gcd = i;
	   // }
	    
	    // Improvisation - time complexity is still same 
	   // for (int i = min; i >= 1; i--) {
	   //     if (n1%i == 0 && n2%i == 0) {
	   //         gcd = i;
	   //         break;
	   //     }
	   // }
	    
	    // Optimal - Euclidean algorithm
	    // gcd (a, b) = gcd(a-b, b) = gcd(a%b, b) given a > b
	    while (n1 > 0 && n2 > 0) {
	        if (n1 > n2) n1 %= n2;
	        else n2 %= n1;
	    }
	    
	    if (n1 == 0) return n2;
	    return n1;
	    
	   // return gcd;
	}
	
	static List<Integer> printPrimes(int N) {
	    List<Integer> result = new ArrayList<>();
	    
	    // Bruteforce - T.C. = N*sqrt(N)
	   // for (int i = 2; i <= N; i++) {
	   //     if (N % i == 0) {
	   //         if (checkPrime(i)) result.add(i);
	   //     }
	   // }
	    
	    // Better - T.C. = sqrt(N)*sqrt(N) = O(N)
	   // for (int i = 2; i*i <= N; i++) {
	   //     if (N % i == 0) {
	   //         if (checkPrime(i)) result.add(i);
	   //         if (N/i != i) {
	   //             if (checkPrime(N/i)) result.add(N/i);
	   //         }
	   //     }
	   // }
	   // if (checkPrime(N)) result.add(N);
	   
	   // result.sort(null);
	   
	   // Optimal 
	   //for (int i = 2; i <= N; i++) {
	   //    if (N%i == 0) {
	   //        result.add(i);
	   //        while (N%i == 0) {
	   //            N /= i;
	   //        }
	   //    }
	   //}
	   
	   // More Optimal 
	   // T.C. = O(sqrt(N))
	   // T.C. in Worst Case -> O(N) when N is itself a prime number 
	   for (int i = 2; i*i <= N; i++) {
	       if (N%i == 0) {
	           result.add(i);
	           while (N%i == 0) {
	               N /= i;
	           }
	       }
	   }
	   if (N != 1) result.add(N);
	    
	    return result;
	}
	
	static double power(double a, double b) {
	    double answer = 1.0;
	    double x = Math.abs(b);
	    
	    // Bruteforce - O(b)
	   // for (int i = 1; i <= b; i++) {
	   //     answer *= a;
	   // }
	    
	    // Optimal
	    while(x > 0) {
	        if (x % 2 == 0) {
	            x /= 2;
	            a *= a;
	        } else {
	            x -= 1;
	            answer *= a;
	        }
	    }
	    
	    if (b < 0) return 1/answer;
	    return answer;
	}
	
	static void printPrimesTillN(int N) {
	    // Bruteforce O(n*sqrt(N))
	   // for (int i = 2; i <= N; i++) {
	   //     if (checkPrime(i)) System.out.println(i);
	   // }
	    
	    // Optimal - Sieve of Eratosthenes
	    int[] primes = new int[N+1];
	    for (int i = 2; i <= N; i++) {
	        primes[i] = 1;
	    }
	    
	    // Sieve of Eratosthenes
	    for (int i = 2; i*i <= N; i++) {
	        if (primes[i] == 1) {
	            for (int j = i*i; j <= N; j+=i) {
	                primes[j] = 0;
	            }
	        }
	    }
	    
	    for (int i = 2; i <= N; i++) {
	        if (primes[i] == 1) System.out.println(i);
	    }
	}
	
	static List<Integer> printPrimesRange(List<List<Integer>> queries) {
	    List<Integer> result = new ArrayList<>();
	    int q = queries.size();
	    int[] primes = getSieve((int)Math.pow(10, 6));
	    
	    int count = 0;
	    for (int i = 2; i <= Math.pow(10, 6); i++) {
	        count += primes[i];
	        primes[i] = count;
	    }
	    
	    
	    for (int i = 0; i < q; i++) {
	       // int count = 0;
	        int l = queries.get(i).get(0);
	        int h = queries.get(i).get(1);
	        
	       // for (int j = l; j <= h; j++) {
	       //    // Bruteforce
	       //    // if (checkPrime(j)) count++;
	           
	       //    //Better
	       //    //if (primes[j] == 1) count++;
	       // }
	       
	       //result.add(count);
	       
	       // Optimal - using PrefixSum
	       result.add(primes[h] - primes[l-1]);
	    }
	    
	    return result;
	}
	
	static int[] getSieve(int N) {
	    int[] primes = new int[N+1];
	    for (int i = 2; i <= N; i++) {
	        primes[i] = 1;
	    }
	    
	  
	    for (int i = 2; i*i <= N; i++) {
	        if (primes[i] == 1) {
	            for (int j = i*i; j <= N; j+=i) {
	                primes[j] = 0;
	            }
	        }
	    }
	    
	    return primes;
	}
	
	static List<List<Integer>> primeFactorization(List<Integer> queries) {
	    List<List<Integer>> result = new ArrayList<>();
	    int q = queries.size();
	    
	    // Bruteforce 
	    // T.C  = O (q x sqrt(N))
	   // for (int i = 0; i < q; i++) {
	   //     List<Integer> primeFactors = getPrimeFactors(queries.get(i));
	   //     result.add(primeFactors);
	   // }
	   
	   // Optimal
	   int[] spf = new int[(int)Math.pow(10, 5)+1];
	   
	   for (int i = 2; i <= Math.pow(10, 5); i++) {
	       spf[i] = i;
	   }
	   
	   for (int i = 2; i*i <= Math.pow(10, 5); i++) {
	       if (spf[i] == i) {
	           for (int j = i*i; j <= Math.pow(10, 5); j+=i) {
	               if (spf[j] ==j) spf[j] = i;
	           }
	       }
	   }
	   
	   for (int i = 0; i < q; i++) {
	       List<Integer> primeFactors = new ArrayList<>();
	       int n = queries.get(i);
	       
	       while (n != 1) {
	           primeFactors.add(spf[n]);
	           n /= spf[n];
	       }
	       
	       result.add(primeFactors);
	   }
	    
	    return result;
	}
	
	static List<Integer> getPrimeFactors(int N) {
	    List<Integer> result = new ArrayList<>();
	    
	    for (int i = 2; i*i <= N; i++) {
	       if (N%i == 0) {
	           while (N%i == 0) {
	               result.add(i);
	               N /= i;
	           }
	       }
	   }
	   if (N != 1) result.add(N);
	   
	   return result;
	}
	
	static int lcm(int n1, int n2) {
	    return (n1*n2) / gcd(n1, n2);
	}
}
