import java.util.PriorityQueue;

import java.util.*;

public class Programmers_doublePriorityQueue {
    public static int[] solution(String[] operations) {
        int[] answer = { 0, 0 };
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());// 최대힙
        PriorityQueue<Integer> min = new PriorityQueue<>();// 최소힙

        for (String str : operations) {
            String[] split = str.split(" ");
            if (split[0].equals("I")) {
                // insert
                max.add(Integer.parseInt(split[1]));
                min.add(Integer.parseInt(split[1]));
            }
            if (split[0].equals("D")) {
                if (!max.isEmpty()) {
                    if (split[1].equals("1")) {
                        // 최대값 삭제
                        int value = max.peek();
                        max.remove(value);
                        min.remove(value);
                    } else {
                        int value = min.peek();
                        max.remove(value);
                        min.remove(value);
                    }
                }
            }
        }
        // System.out.println(max);
        // System.out.println(min);

        if (!(max.isEmpty() && min.isEmpty())) {
            answer[0] = max.peek();
            answer[1] = min.peek();
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] operatStrings = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
        int[] res = solution(operatStrings);
        for(int r : res){
            System.out.println(r);
        }
    }
}
