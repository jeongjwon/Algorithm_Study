import java.util.*;

class Programmers_nightOvertimeIndex {
    public static long solution(int n, int[] works) {
        long answer = 0;

        // 우선순위 큐 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) {
            pq.offer(w);
        }
        System.out.println(pq);

        for (int i = 0; i < n; i++) {
            int poll = pq.poll();
            if (poll <= 0) {
                pq.poll();
                break;
            }

            pq.offer(poll - 1);
        }
        System.out.println(pq);
        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }

        return answer;
    }

    public static void main(String[] args) {
        // int[] works = { 4, 3, 3, };
        // int n = 4;

        // int[] works = { 2, 1, 2 };
        // int n = 1;
        int[] works = { 1, 1 };
        int n = 3;
        System.out.println(solution(n, works));
    }
}
