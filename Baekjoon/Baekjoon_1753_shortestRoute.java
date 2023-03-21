
import java.util.*;
import java.io.*;

public class Baekjoon_1753_shortestRoute {
    static int V, E, K, u, v, w;
    static int INF = Integer.MAX_VALUE;
    // static int[][] graph;
    static ArrayList<ArrayList<int[]>> graph;
    static boolean[] visited;
    static int[] distance;

    public static void dijkstra(int start) {
        // 출발 정점만 알면 됨
        distance = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            distance[i] = Integer.MAX_VALUE;

        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        visited = new boolean[V + 1];
        pq.add(new int[] { start, 0 });
        // 도착점 , 가중치
        distance[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            // cur[0] 도착 정점 , cur[1] 가중치
            // System.out.println("cur : " + cur[0] + " , " + cur[1]);
            if (distance[cur[0]] < cur[1])
                continue;
            // 도착정점에서 갈 수 있는 정점 , 그 정점까지의 가중치
            for (int i = 0; i < graph.get(cur[0]).size(); i++) {
                int[] next = graph.get(cur[0]).get(i);

                // System.out.println("next : " + next[0] + ", " + next[1]);
                if (distance[next[0]] > cur[1] + next[1]) {
                    distance[next[0]] = cur[1] + next[1];
                    pq.add(new int[] { next[0], distance[next[0]] });

                }
            }

        }
        for (int i = 1; i < V + 1; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }

            else {
                System.out.println(distance[i]);
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점
        E = Integer.parseInt(st.nextToken()); // 간선

        K = Integer.parseInt(br.readLine()); // 시작 정점

        // graph = new int[V + 1][V + 1];
        graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<int[]>());
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[] { v, w });

        }
        // for (int i = 1; i < V + 1; i++) {
        // System.out.print(i + " -> ");
        // for (int j = 0; j < graph.get(i).size(); j++) {
        // System.out.print("{" + graph.get(i).get(j)[0] + " , " +
        // graph.get(i).get(j)[1] + "} , ");
        // }
        // System.out.println();

        // }

        dijkstra(K);

    }

}
