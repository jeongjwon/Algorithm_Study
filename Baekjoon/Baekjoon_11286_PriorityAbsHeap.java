
import java.util.*;
import java.io.*;

public class Baekjoon_11286_PriorityAbsHeap {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            // 오름차순으로 정렬하되
            // 첫번째 값으로 넣은 절대값이 같다면 두번째 값으로 넣은 원래의 값으로 오름차순 정렬
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                int[] a = { Math.abs(x), x };
                pq.add(a);
            } else {
                if (pq.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(pq.poll()[1]);
            }
        }
    }
}
