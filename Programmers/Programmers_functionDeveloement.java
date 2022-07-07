import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_functionDeveloement {
    public static int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        // 1. queue 사용
        for (int i = 0; i < progresses.length; i++) {
            int date = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            if (!queue.isEmpty() && queue.peek() < date) {
                list.add(queue.size());
                queue.clear(); // poll대신 clear
            }
            queue.add(date);
        }

        // 2. 람다식 -> 시간, 공간적으로 제한
        int[] dayofEnd = new int[100];

        int day = -1;
        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + (day * speeds[i]) < 100) {
                day++;
            }
            dayofEnd[day]++;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;

    }

    public static void main(String[] args) {
        // int[] progresses = { 93, 30, 55 };
        // int[] speeds = { 1, 30, 5 };
        int[] progresses = { 95, 90, 99, 99, 80, 99 };
        int[] speeds = { 1, 1, 1, 1, 1, 1 };
        int[] res = solution(progresses, speeds);
        for (int r : res) {
            System.out.println(r);
        }
    }
}
