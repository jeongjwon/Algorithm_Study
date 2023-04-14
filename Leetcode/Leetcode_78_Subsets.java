import java.util.*;

public class Leetcode_78_Subsets {
    public static void backtracking(int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> list, int index){
      
        // System.out.println("backtracking(nums, visited, result : "+result + " ,  list : "+ list + " , index : "+index+ " )");
        
        // if(index > nums.length) return;

        result.add(new ArrayList<>(list));

        //중복 허용 x

        for(int i = index ; i < nums.length ; i++){
            // if(!visited[i]){
            //     visited[i] = true;
            //     list.add(nums[i]);
            //     backtracking(nums, visited, result, list, i+1);
                
            //     list.remove(list.size()-1);
            //     visited[i] = false;
                

            // }
            list.add(nums[i]);
            backtracking(nums, visited, result, list, i+1);
            list.remove(list.size()-1);
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backtracking(nums, visited, result, list, 0);


        return result;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3};

        List<List<Integer>> res = subsets(nums);
        for(List<Integer> r : res) System.out.println(r);
    }
}
