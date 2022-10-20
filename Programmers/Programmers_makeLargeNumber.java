import java.util.*;

public class Programmers_makeLargeNumber {

    public static String solution(String number, int k) {
        char[] res = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();

            }
            stack.push(c);
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = stack.get(i);
        }

        return new String(res);
    }

    public static void main(String[] args) {

        String number = "1924";
        int k = 2;
        System.out.println(solution(number, k));
    }

}
