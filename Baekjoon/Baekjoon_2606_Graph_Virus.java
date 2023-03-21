
import java.util.*;
import java.io.*;

public class Baekjoon_2606_Graph_Virus {
    static ArrayList<ArrayList<Integer>> computer;
    static boolean[] visited;
    static int cnt = 0;

    static void dfs(int v) {

        for (int u : computer.get(v)) {
            if (!visited[u]) {
                visited[u] = true;

                // System.out.println(u);
                cnt++;
                dfs(u);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 정점 수
        int e = Integer.parseInt(br.readLine()); // 간선 수

        computer = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            computer.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < e; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            computer.get(u).add(v);
            computer.get(v).add(u);
        }
        System.out.println(computer);
        visited[1] = true;
        dfs(1);
        System.out.println(cnt);

    }
}
