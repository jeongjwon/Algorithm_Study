import java.util.*;
public class Leetcode_20_ValidParentheses {
    public boolean isValid(String s) {
            	
    	Stack<Character> stack = new Stack<Character>();
    	
    	char[] str = s.toCharArray();
    	
    	for(int i = 0 ; i  < s.length(); i++) {

    		if(stack.isEmpty()) stack.add(str[i]);
    		
    		else {
    			if((stack.peek() == '(' && str[i] == ')') ||
    					(stack.peek() == '[' && str[i] == ']') ||
        				(stack.peek() == '{' && str[i] == '}')) stack.pop();
        		else stack.add(str[i]);
        	
    		}
    		
    	}
    	return stack.isEmpty() ? true : false;
   }
}
