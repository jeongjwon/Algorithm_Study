
import java.util.*;
import java.io.*;

public class Baekjoon_13549_hideAndSeek3 {

    static int n, k;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[100001];

    static void bfs(int n) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        visited[n] = true;
        pq.add(new int[] { n, 0 });
        // 목표지점, 시간 초

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            // System.out.println(cur[0] + " , " + cur[1]);
            visited[cur[0]] = true;
            // System.out.println("k : " + k);
            if (cur[0] == k) {
                // min = Math.min(min, cur[1]);
                System.out.println(cur[1]);
                break;

            }

            if (cur[0] + 1 <= 100000 && !visited[cur[0] + 1]) {
                pq.add(new int[] { cur[0] + 1, cur[1] + 1 });
            }
            if (cur[0] - 1 >= 0 && !visited[cur[0] - 1]) {
                pq.add(new int[] { cur[0] - 1, cur[1] + 1 });
            }
            if (cur[0] * 2 <= 100000 && !visited[cur[0] * 2]) {
                pq.add(new int[] { cur[0] * 2, cur[1] });
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs(n);

        // for (int i = n; i <= k; i++) {
        // System.out.print("i = " + i + " : " + visited[i] + " ");
        // }
    }
}
