import java.util.*;

public class Leetcode_561_ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
            	int answer = 0;
    	Arrays.sort(nums);

    	for(int i = 0 ; i < nums.length ; i+=2) {
    		
    		answer += nums[i];
    		
    	}
    	return answer;

    }

}