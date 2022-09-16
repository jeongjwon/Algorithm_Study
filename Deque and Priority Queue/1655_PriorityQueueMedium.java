
import java.util.*;
import java.io.*;

public class Baekjoon_1655_PriorityQueueMedium {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        // 최소힙 -> 오른쪽으로 갈 수록 작아진다
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        // 최대힙

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            // 최대힙에 먼저 넣어줌 -> 짝수 개일 시 제일 작은 수를 말해야하기 때문
            if (minPq.size() == maxPq.size()) {
                maxPq.add(x);

            } else {
                minPq.add(x);
            }
            if (!minPq.isEmpty() && !maxPq.isEmpty()) {
                if (minPq.peek() < maxPq.peek()) {
                    // swap -> 최소힙의 peek가 최대힙의 peek 보다 커야함
                    int max = maxPq.poll();
                    int min = minPq.poll();

                    minPq.add(max);
                    maxPq.add(min);
                }
            }
            sb.append(maxPq.peek()).append("\n");
            // System.out.println(maxPq.peek());
            // System.out.println("min : " + minPq);
            // System.out.println("max : " + maxPq);
        }
        System.out.println(sb);
    }
}
