
import java.util.*;
import java.io.*;

public class Baekjoon_9370_uncheckedDestination {
    static int n, m, t, s, g, h, a, b, d; // 교차로 도로 목적지
    static ArrayList<ArrayList<int[]>> road;
    static boolean[] visited = new boolean[20001];

    public static void dijkstra(int start) {
        // PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        visited[start] = true;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 교차로 -> 정점
            m = Integer.parseInt(st.nextToken());// 도로 -> 간선
            t = Integer.parseInt(st.nextToken());// 목적지 후보 갯수

            road = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                road.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());// 출발지
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                // a와 b 사이의 양방향 도로
                road.get(a).add(new int[] { b, d });
                road.get(b).add(new int[] { a, d });
            }

            int[] candidate = new int[t];
            for (int i = 0; i < t; i++) {
                candidate[i] = Integer.parseInt(br.readLine());
            }

            dijkstra(s);
        }
    }
}
