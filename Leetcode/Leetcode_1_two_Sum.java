public class Leetcode_1_two_Sum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        
        for(int i = 0 ; i < nums.length ; i++){
            int sum = 0;
            boolean flag = true;
            for(int j = i+1 ; j < nums.length ; j++){
                sum = nums[i] + nums[j];
                // System.out.println(nums[i] + "+" + nums[j] + " = " +sum);
                if(sum == target){
                    result[0] = i;
                    result[1] = j;
                    flag = false;
                    break;
                }
                
            }
            if(!flag) break;
        }
        return result;
    }
    public static void main(String[] args){
        // int[] nums = {2,7,11,15};
        // int target = 9;
        int[] nums = {3,2,3};
        int target = 6;
        int[] res = twoSum(nums, target);
        for(int r : res) System.out.println(r);
    }
}
