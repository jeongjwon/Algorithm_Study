import java.util.*;

public class Leetcode_baseballGame {
    public static int calPoints(String[] ops) {
        int answer = 0;
        List<Integer> point = new ArrayList<>();

        for (String s : ops) {
            if (s.matches("-?\\d+(\\.\\d+)?")) {

                point.add(Integer.parseInt(s));
            } else if (s.equals("D")) {

                point.add(point.get(point.size() - 1) * 2);
            } else if (s.equals("C")) {

                point.remove(point.size() - 1);
            } else if (s.equals("+")) {
                int sum = point.get(point.size() - 1) + point.get(point.size() - 2);
                point.add(sum);
            }

        }
        answer = point.stream().mapToInt(Integer::intValue).sum();
        return answer;
    }

    public static void main(String[] args) {

        // String[] ops = { "5", "2", "C", "D", "+" };
        String[] ops = { "5", "-2", "4", "C", "D", "9", "+", "+" };
        System.out.println(calPoints(ops));
    }

}
