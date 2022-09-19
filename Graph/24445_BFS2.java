import java.util.*;
import java.io.*;

public class Baekjoon_24445_BFS2 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] seq;
    static int order = 2;

    public static void bfs(int r) {

        // visited[r] = true;
        Queue<Integer> queue = new LinkedList<>();
        visited[r] = true;
        queue.add(r);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    seq[v] = order++;
                    queue.add(v);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 무방향
        int n = Integer.parseInt(st.nextToken()); // 정점의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수
        int r = Integer.parseInt(st.nextToken()); // 시작 정점

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        // graph = new int[n][n];
        visited = new boolean[n + 1];
        seq = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);

            // graph[u - 1][v - 1] = 1;
            // graph[v - 1][u - 1] = 1;

        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }
        // System.out.println(graph);
        seq[r] = 1;
        visited[r] = true;

        bfs(r);
        for (int i = 1; i < n + 1; i++) {
            System.out.println(seq[i]);
        }

    }
}
