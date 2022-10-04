import java.util.*;

public class Programmers_bracketRotation {
    public static int solution(String s) {
        int answer = 0;

        String temp = s;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char first = temp.charAt(0);
            // System.out.print("first : " + first);
            String rest = temp.substring(1);
            // System.out.println("rest : " + rest);

            sb = new StringBuilder();
            sb.append(rest).append(first);

            temp = sb.toString();
            // System.out.println("temp : " + sb);

            if (check(temp))
                answer++;

        }

        return answer;
    }

    public static boolean check(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if ((stack.peek() == '[' && c == ']') ||
                        (stack.peek() == '(' && c == ')') ||
                        (stack.peek() == '{' && c == '}')) {
                    stack.pop();
                } else {
                    stack.push(c);
                }

            }
        }

        return stack.isEmpty() ? true : false;

    }

    public static void main(String[] args) {

        // String s = "[](){}";
        // String s = "}]()[{";
        // String s = "[)(]";
        String s = "}}}";
        System.out.println(solution(s));
    }

}
