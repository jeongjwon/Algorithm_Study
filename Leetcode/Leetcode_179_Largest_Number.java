import java.util.*;
public class Leetcode_179_Largest_Number {
    public static String largestNumber(int[] nums) {
  
        String[] strArr = new String[nums.length];
        for(int i = 0 ; i < nums.length; i++){
            strArr[i] = String.valueOf(nums[i]);
        }

        //유니코드 비교 2 vs 10 -> 2가 더 큼
        Arrays.sort(strArr, new Comparator<String>(){
            public int compare(String s1, String s2){
                String firstSecond = s1+s2;
                String secondFirst = s2+s1;
                
                return -firstSecond.compareTo(secondFirst);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < strArr.length ; i++){
            sb.append(strArr[i]);
        }

        // 227 tc
        if(sb.charAt(0) == '0') return "0";
        
        return sb.toString();
    }
    public static void main(String[] args){
        // int[] nums = {10,2};
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
}
