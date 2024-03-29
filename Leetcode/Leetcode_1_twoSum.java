import java.util.*;

public class Leetcode_1_twoSum {
 public static int[] twoSum(int[] nums, int target) {
    	int[] answer = new int[2];
    	
    	for(int i = 0 ; i < nums.length ; i++) {
    		int sum = 0;
    		for(int j = i+1 ; j < nums.length ;j++) {
    			sum = nums[i] + nums[j];
    			if(sum == target) {
    				answer[0] = i;
    				answer[1] = j;
    				break;
    			}
    		}


    	}
    	return answer;
    	
    }
    public static int[] twoSum_map(int[] nums, int target) {
    	int[] answer = new int[2];
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i = 0 ; i < nums.length ; i++) {
    		if(map.containsKey(target - nums[i])) {
    			answer[0] = map.get(target-nums[i]);
    			answer[1] = i;
    			return answer;
    		}
    		map.put(nums[i], i);
    	}
    	return answer;

    }
}
