import java.util.*;
import java.io.*;

public class Baekjoon_1697_hideAndSeek {

    static int n, k;
    static int[] visited = new int[100001];

    static void bfs(int n) {

        Queue<Integer> queue = new LinkedList<>();
        visited[n] = 1;
        queue.add(n);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = now + 1;

                } else if (i == 1) {
                    next = now - 1;
                } else {
                    next = now * 2;
                }
                if (next == k) {
                    System.out.println(visited[now]);
                    return;
                }
                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println("0");

        } else {
            bfs(n);
        }

        // for (int i = n; i <= k; i++) {
        // System.out.print(visited[i] + " ");
        // }
    }
}
