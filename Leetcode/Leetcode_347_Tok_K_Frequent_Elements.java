import java.util.*;
public class Leetcode_347_Tok_K_Frequent_Elements {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        
        //map 에 num, count 추가
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
       
        for(int key : map.keySet()){
            pq.add(new int[]{key, map.get(key)});
        }
        
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = pq.poll()[0];
        }
        return answer;
    }
    public static void main(String[] args){
        int[] nums = { 1,1,1,2,2,3 };
        int k = 2;
        
        int[] res = topKFrequent(nums, k);
        for(int r : res) System.out.println(r);
    }
}
