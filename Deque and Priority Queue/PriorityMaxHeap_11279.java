
import java.util.*;
import java.io.*;

public class Baekjoon_PriorityMaxHeap_11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Collections.reverseOrder());

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
                    System.out.println(pq.poll());
            }
        }
    }
}
