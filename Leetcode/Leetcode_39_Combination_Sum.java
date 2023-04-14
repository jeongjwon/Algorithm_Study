import java.util.*;

public class Leetcode_39_Combination_Sum {
    public static void backtracking(int[] candidates, List<List<Integer>> result, List<Integer> list,  int sum, int idx, int depth,  int target ){

        
        System.out.println("backtracking(result : " + result + " , list :"+list + " sum : "+sum + ", idx : "+idx + " , " +target + " )");

        if(sum > target || idx == candidates.length){
            return;
        }
        if(sum == target){
                result.add(new ArrayList<>(list));
                return;
        }
            
        

        for(int i = idx ; i < candidates.length ; i++){
            //중복조합 가능
            list.add(candidates[i]);
            sum += candidates[i];
            
            backtracking(candidates, result, list, sum, i, depth+1, target);
            
            list.remove(list.size()-1);
            sum -= candidates[i];
        }


    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backtracking(candidates, result, list, 0, 0 , 0,  target);

        return result;
    }
    public static void main(String[] args){
        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> res = combinationSum(candidates, target);

        for(List<Integer> r : res) System.out.println(r);

    }


}
