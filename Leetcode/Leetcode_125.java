public class Leetcode_125 {
   
        public boolean isPalindrome(String s) {
    
            String newString = s.toUpperCase().replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]", "");
            // for(int i = 0 ; i < newString.length()/2 ; i++){
            //     if(newString.charAt(i) != newString.charAt(newString.length()-1-i)){
            //         return false;
            //     }
            // }
            int left = 0;
            int right = newString.length()-1;
            while(left < right){
                if(newString.charAt(left) == newString.charAt(right)){
                    left++;
                    right--;
                }else{
                    return false;
                }
            }
            return  true;
    
        }
    
}
