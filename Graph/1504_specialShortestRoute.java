import java.util.*;
import java.io.*;

public class Baekjoon_1504_specialShortestRoute {
    static int N, E;
    static ArrayList<ArrayList<int[]>> graph;
    static int[] distance;
    static boolean[] visited;
    static final int INF = 10000000;

    public static int dijkstra(int start, int end) {

        visited = new boolean[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        Arrays.fill(visited, false);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        pq.add(new int[] { start, 0 });
        distance[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (!visited[cur[0]]) {
                visited[cur[0]] = true;
                for (int i = 0; i < graph.get(cur[0]).size(); i++) {
                    int[] next = graph.get(cur[0]).get(i);

                    if (!visited[next[0]] && distance[next[0]] > distance[cur[0]] + next[1]) {
                        distance[next[0]] = distance[cur[0]] + next[1];
                        pq.add(new int[] { next[0], distance[next[0]] });
                    }
                }
            }

        }
        return distance[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 양방향
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<int[]>());
        }
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[] { b, c });
            graph.get(b).add(new int[] { a, c });

        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        int test1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        // 1 -> v2 -> v1 -> N
        int test2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        // 둘중 값이 나오지 않는 다면 -1 추출 or 둘중 작은 값 추출
        int res = (test1 >= INF && test2 >= INF) ? -1 : Math.min(test1, test2);

        System.out.println(res);

    }
}
