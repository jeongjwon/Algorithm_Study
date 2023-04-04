import java.util.Stack;

import java.util.*;
public class Leetcode_739_Daily_Temperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 0);

        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < n ; i++){
    
           while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                //stack 이 비어있지않고 tmperatures[peekInd] 보다 현재의 값이 더 크다면 pop
                System.out.print("peek 값"+temperatures[stack.peek()]);
                int peek = stack.pop();
                answer[peek] = i - peek;
                System.out.println("  현재 값 "+temperatures[i] + " answer 값 "+answer[peek]);
           }
           System.out.println("추가할 값 "+temperatures[i]);
           System.out.println();
           stack.add(i); //stack에 넣을 값은 index

          
        }
       
        return answer;

    }
    public static void main(String[] args){
        int[] temperatures = { 73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(temperatures);
        for(int r : res) System.out.println(r);
    }
}
