import java.util.*;
import java.io.*;

public class Baekjoon_1260_DFSandBFS {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static boolean[] checked;
    static StringBuilder sbDfs = new StringBuilder();
    static StringBuilder sbBfs = new StringBuilder();

    static void dfs(int start) {
        visited[start] = true;
        // System.out.println(start);
        sbDfs.append(start).append(" ");
        for (int v : graph.get(start)) {
            if (!visited[v]) {
                visited[v] = true;
                // System.out.println(v);
                dfs(v);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        checked[start] = true;

        sbBfs.append(start).append(" ");
        while (!queue.isEmpty()) {
            int value = queue.poll();
            for (int v : graph.get(value)) {
                if (!checked[v]) {
                    checked[v] = true;
                    queue.offer(v);
                    sbBfs.append(v).append(" ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        checked = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(w);
            graph.get(w).add(u);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(v);
        System.out.println(sbDfs);

        bfs(v);
        System.out.println(sbBfs);

    }
}
