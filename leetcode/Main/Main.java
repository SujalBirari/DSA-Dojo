import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    int[] nums = {2, 7, 11, 15};
	    
		System.out.println(Arrays.toString(twoSum(nums, 9)));
	}
	
	static int[] twoSum(int[] nums, int target) {
	    // Bruteforce -> TC = O(N^2)
	    int[] result = new int[2];
	   // int len = nums.length;
	    
	   // for (int i = 0; i < len-1; i++) {
	   //     for (int j = i+1; j < len; j++) {
	   //         if (nums[i] + nums[j] == target) {
	   //             result[0] = i;
	   //             result[1] = j;
	   //         }
	   //     }
	   // }
	   
	   // Optimal - O(n)
	   Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain)) {
                result[0] = map.get(remain);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
	    
	    return result;
	}
}
