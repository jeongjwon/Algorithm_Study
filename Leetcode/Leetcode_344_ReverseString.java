import java.util.*;
public class Leetcode_344_ReverseString {
    public void reverseString(char[] s) {
        //one way
    //    char[] reverse = new char[s.length];
    //    for(int i = 0 ; i < s.length ; i++){
    //        reverse[i] = s[s.length-1-i];
    //    }
    //    for(int i = 0 ; i < s.length ; i++){
    //        s[i] = reverse
    //    }

       //synchronous
       int left = 0 , right = s.length-1;
       while(left < right){
           char temp = s[left];
           s[left] = s[right];
           s[right] = temp;
           left++;
           right--;
       }
       
    
    }
}
