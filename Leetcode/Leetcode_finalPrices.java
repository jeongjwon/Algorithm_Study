// import java.util.*;

public class Leetcode_finalPrices {
    public static int[] finalPrices(int[] prices) {
        // Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];

        // for (int i = 0; i < prices.length; i++) {
        // int flag = 0;
        // for (int j = i + 1; j < prices.length; j++) {
        // if (prices[i] >= prices[j]) {
        // answer[i] = prices[i] - prices[j];
        // flag = 1;
        // break;
        // }
        // }
        // if (flag == 0) {
        // answer[i] = prices[i];
        // }
        // }

        // Stack

        // for (int i = 0; i < prices.length; i++) {
        // int cur = prices[i];
        // int value = 0;
        // while (!stack.isEmpty() && stack.peek() >= cur) {
        // value = stack.peek() - cur;
        // stack.pop();
        // }
        // stack.push(value);
        // }
        // int i = 1;
        // while (!stack.isEmpty()) {
        // answer[answer.length - i] = stack.pop();
        // i++;
        // }
        return answer;

    }

    public static void main(String[] args) {
        // int[] prices = { 8, 4, 6, 2, 3 };
        // int[] prices = { 1, 2, 3, 4, 5 };
        int[] prices = { 10, 1, 1, 6 };
        int[] res = finalPrices(prices);
        for (int r : res) {
            System.out.println(r);
        }
    }

}
