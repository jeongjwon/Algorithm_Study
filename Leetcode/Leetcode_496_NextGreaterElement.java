import java.util.*;
public class Leetcode_496_NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>(); // value, nexgreater element
        for(int num : nums2){
            while(!stack.isEmpty() && num > stack.peek()){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        int[] answer = new int[nums1.length];
        for(int i = 0 ; i < nums1.length; i++){
            answer[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1 ;
        }
        return answer;
    }
}
