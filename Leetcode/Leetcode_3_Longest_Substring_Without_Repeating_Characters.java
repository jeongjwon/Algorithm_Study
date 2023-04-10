import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

public class Leetcode_3_Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {

        //문자열 조합
        // if(s.length() == 0) return 0;
        
        // int max = Integer.MIN_VALUE;

        // for(int i = 0 ; i < s.length() ; i++){
        //     String temp = String.valueOf(s.charAt(i));
        //     for(int j = i+1 ; j < s.length() ; j++){
        //         if(temp.indexOf(String.valueOf(s.charAt(j))) == -1){
        //             //중복되지 않을 경우의 문자열 조합
        //             temp += String.valueOf(s.charAt(j));                   
        //         }else{
        //             break;
        //         }
        //         max = Math.max(max, temp.length());
        //         // System.out.println("temp : "+temp + "  max : "+max);
        //     }
        // }

        // return max == Integer.MIN_VALUE ? 1 : max;

        //Set 이용
        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;

        //abcabcbb
        for(int right = 0 ; right < s.length() ; right++){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                max = Math.max(max, right-left+1);
            }else{
                //이미 right 가 set 에 존재한다면
                //right = 3 a -> 3 a
                //left = 0 a -> 1 b
                while(s.charAt(left) != s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }//다를 동안 left 추가시켜
                
                //같은 경우에 left 를 삭제하고 left 증가
                set.remove(s.charAt(left));
                left++;
                //rigght 를 추가
                set.add(s.charAt(right));
            }
            System.out.println("left : "+left + "  right : "+right);
        }
        
          return max;
    }
  
    
    public static void main(String[] args){
        String s = "abcabcbb";
        // String s ="bbbbb";
        // String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
