public class Leetcode_125_ValidPalindrome {
    public boolean isPalindrome(String s) {
          boolean valid = true;
        s = s.toLowerCase();
//        System.out.println(s);
        char[] temp = s.toCharArray();
        String str = "";
        for(char c: temp) {
        	if( (c >= 'a' && c <= 'z') ||
        			(c >= '0' && c <= '9')) str += c;
        }
//        System.out.println("amanaplanacanalpanama");
//        System.out.println(str + " , " +str.length());
        int left = 0 ,  right = str.length()-1;
        
        while(left <= right) {
        	char l_c = str.charAt(left);
        	char r_c = str.charAt(right);
//        	System.out.println(left + ": " + l_c + ", "+ right+ " : " + r_c);
        	if(l_c != r_c) {
        		valid = false;
        		break;
        	}
        	left++;
        	right--;
        }
        
        return valid;
        
    }
}
