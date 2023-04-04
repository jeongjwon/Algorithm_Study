import java.util.Stack;

import java.util.*;
public class Leetcode_316_Remove_Duplicate_Letters {
    public static String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();
        
        // int[] 이용
        // int[] count = new int[26];
        // for(char c : s.toCharArray()){
        //     count[c - 'a']++;
        // }

        //map 이용
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        //방문 이력 
        boolean[] visited = new boolean[26];

        for(char c : s.toCharArray()){
            // count[c - 'a']--;
            map.put(c, map.get(c)-1);
            if(map.get(c) < 1) map.remove(c);
            if(visited[c - 'a']){
                continue;
            }
            // while(!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0){
                //클 때까지, 뒷문자에 peek가 아직 남아있다면
            while(!stack.isEmpty() && stack.peek() > c && map.containsKey(stack.peek())){
                // System.out.println("뺄 값 : "+stack.peek());
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            // System.out.println("추가할 값 " +c);
            // System.out.println();
            stack.push(c);
            visited[c - 'a'] = true;
        }

        //cbacdcbc
        //a:1 b:2 c:4 d:1
        //c  | a:1 b:2 c:3 d:1  | stack : c | visited[c] = 1;
        //b  | a:1 b:1 c:3 d:1  | stack : b | visited[c] = 0 , visited[b] = 1
        //a  | a:0 b:1 c:3 d:1 | stack: a | visited[a] = 1; 
        //c  | a:0 b:1 c:2 d:1 | stack: a c | visited[c] = 1;
        //d  | a:0 b:1 c:2 d:0 | stack: a c d | visited[d] = 1;
        //c  | a:0 b:1 c:1 d:0 | visited[c] = 1 continue
        //b visited[b] = 1 continue
        //c visited[c] = 1 continue

        StringBuilder sb = new StringBuilder();
        for(char c: stack){//pop으로 위에서 안 빼고 배열로 밑에서 순서대로 문자열로 만들어줌
            // System.out.print(c + " ");
            sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        // String s = "bcabc";
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }
}
// cbacdcbc
// cb 
// 작은데 없으면