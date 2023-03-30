import java.util.Stack;
public class Leetcode_20_Valid_Parentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for(int i = 0 ; i < chars.length ; i++){
            if(stack.isEmpty()) stack.push(chars[i]);
            else{
                Character peek = stack.peek();
                if((peek == '(' && chars[i] == ')') ||
                    (peek == '[' && chars[i] == ']') ||
                    (peek == '{' && chars[i] == '}')) stack.pop();
                else stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        // String s = "()";
        // String s = "()[]{}";
        String s = "(]";
        System.out.println(isValid(s));
    }
}
