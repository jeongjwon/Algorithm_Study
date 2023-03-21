import java.util.*;

public class Programmers_twoQueue {
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        while (sum1 != sum2) {
            answer++;
            if (sum1 > sum2) {
                int v = q1.poll();
                sum1 -= v;
                sum2 += v;
                q2.offer(v);

            } else {
                int v = q2.poll();
                sum2 -= v;
                sum1 += v;
                q1.offer(v);
            }
            // -1이 나오는 분기 시점 고르기
            if (answer > (queue1.length + queue2.length) * 2)
                return -1;
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] queue1 = { 1, 2, 1, 2 }; // { 3, 2, 7, 2 };
        int[] queue2 = { 1, 10, 1, 2 }; // { 4, 6, 5, 1 };
        System.out.println(solution(queue1, queue2));
    }
}
