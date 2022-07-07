import java.util.Stack;

public class Programmers_stockPrice {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        // 1. 베열 -> 이중포문 -> 효율성 저하
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] < prices[j])
                    break;

            }

        }

        // 2. Stack 이용 - >index를 push
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {
                1,
                2,
                3,
                2,
                3
        };
        int[] res = solution(prices);
        for (int r : res) {
            System.out
                    .println(r);
        }
    }
}
