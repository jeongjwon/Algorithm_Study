import java.util.*;
public class Leetcode_15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
    	List<Integer> list = new ArrayList<>();
    	if(nums == null) return new ArrayList<>();
    	Arrays.sort(nums);

    	for(int i = 2 ; i < nums.length ; i++) {
    		int sum = 0;
    		int left = 0;
    		int right = i-1;
    		while(left < right) {
    			sum = nums[i] + nums[left] + nums[right];
    			// System.out.println(nums[i] + " " + nums[left] +" " + nums[right] + " = " + sum);
    			
    			if(sum == 0) {
    				list = new ArrayList<>();
    				list.add(nums[i]);
    				list.add(nums[left]);
    				list.add(nums[right]);
                    // Collections.sort(list, Collections.reverseOrder());
                    if(!ans.contains(list)) ans.add(list);
    				
                    left++;
    			}
    			else if(sum > 0) right--;
    			else left++;
    		}

    	
    	}
    	return ans;

        
    }
}
