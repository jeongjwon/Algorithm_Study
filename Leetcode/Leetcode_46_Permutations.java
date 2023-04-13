import java.util.*;
public class Leetcode_46_Permutations {
    static List<List<Integer>> answer = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    public static void permutation(int[] nums, int[] out, boolean[] visited, int depth, int r){
        //가능한 모든 순열 경우의 수
        System.out.println("permutation("+depth+")");
        // if(depth == nums.length){
        if(depth == r){
            for(int num : out){
                list.add(num);
            }
            answer.add(list);
            list = new ArrayList<>();
            return;
        }
        for(int i = 0 ; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = nums[i];
                permutation(nums, out, visited, depth+1, r);
                // System.out.println("한번 끝나고 list =>"+list);
                visited[i] = false;
            }
        }
        

    }
    public static List<List<Integer>> permute(int[] nums) {

        boolean[] visited = new boolean[nums.length];
        int[] out = new int[2];

        permutation(nums, out, visited, 0,2);

        return answer;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        // int[] nums = { 0, 1};
        List<List<Integer>> result = permute(nums);
        for(List<Integer> res : result){
            System.out.println(res);
        }
    }
}
