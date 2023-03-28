import java.util.logging.LogManager;

import javax.swing.ComboBoxEditor;

public class Leetcode_5_LongestPalindromicSubstring {
    public static boolean isPalindrom(String s){
        int left = 0, right = s.length()-1;
        //회문인지 아닌지 판별
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static String longestPalindrome(String s) {
        // String longest = "";
        
        // //substring 만들기
        // for(int i = 0 ; i < s.length() ; i++){
        //     String newStr = "";
        //     for(int j = i ; j < s.length() ; j++){
        //         newStr += s.charAt(j);
        //         System.out.println("만들 수 있는 substring : "+ newStr);
        //         if(isPalindrom(newStr)){
        //             System.out.println("회문임!");
        //             if(longest.length() < newStr.length()){
        //                 longest = newStr;
        //             }
        //             System.out.println("이 때 longest 는 "+longest);
        //         }
        //     }
        // }

        // return longest;

        // String longest = "";

        // for(int i = 0 ; i <s.length() ; i++){
        //     System.out.println("i:"+i);
        //     String odd = getPalindrome(s, i,i);
        //     if(odd.length() > longest.length()) longest = odd;

        //     String even = getPalindrome(s, i, i+1);
        //     if(even.length() > longest.length()) longest = even;


        //     System.out.println("odd: "+odd+" even: "+ even + " longest: "+longest);
        // }
        
        // return longest;

        int max = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int left = 0, right = 0;

        //babad
        
        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = i ; j < n ; j++){
                System.out.println("i :"+i+"  j : "+j + "  ");
                if(s.charAt(i) == s.charAt(j) && ( j - i < 2 || dp[i+1][j-1])){
                    System.out.println(s.charAt(i) +" "+ s.charAt(j) + " 차이 : " + (j-i));
                    dp[i][j]  = true;
                    
                    if(j - i > max){
                        max = Math.max(max, j-i);
                        left = i;
                        right = j;
                    }
                    System.out.println();
                }
            }
        }
        
        return s.substring(left, right+1);

    }
    public static String getPalindrome(String s, int l, int r){

        String result ="";
        while(l >= 0 && r < s.length()){
            if(s.charAt(l) == s.charAt(r)){
                if(l == r){
                    result = result + s.charAt(l);
                }else{
                    result = s.charAt(l)+result+s.charAt(r);
                }
                
            }
            else break;
            l--;
            r++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "babad";
        // String s = "cbbd";
        System.out.println(longestPalindrome(s));

    }
}
