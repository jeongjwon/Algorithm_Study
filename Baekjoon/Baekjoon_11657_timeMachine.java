import java.util.*;
import java.io.*;

public class Baekjoon_11657_timeMachine {
    static int N, M;
    static ArrayList<int[]> bus;
    static long[] distance;
    static final int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시개수 = 정점
        M = Integer.parseInt(st.nextToken()); // 버스노선 개수 = 간선

        bus = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 시작
            int B = Integer.parseInt(st.nextToken()); // 도착
            int C = Integer.parseInt(st.nextToken()); // 시간 ( > 0 시간 / = 0 순간이동 / < 0 타임머신)

            bus.add(new int[] { A, B, C });
        }

        // for (int i = 0; i < bus.size(); i++) {
        // System.out.println(bus.get(i)[0] + " , " + bus.get(i)[1] + " , " +
        // bus.get(i)[2]);
        // }

        if (bellman_ford(1)) {
            for (int i = 2; i <= N; i++) {
                // System.out.println("최종 - distance[" + i + "]" + distance[i]);
                if (distance[i] == INF) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }

            }
        } else {
            System.out.println("-1");
        }

    }

    public static boolean bellman_ford(int start) {

        distance = new long[N + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                int cur = bus.get(j)[0]; // 시작
                int next = bus.get(j)[1];// 도착
                int cost = bus.get(j)[2];// 비용

                if (distance[cur] != INF && distance[next] > distance[cur] + cost) {
                    // System.out.println(cur + " , " + next + " , " + cost);
                    distance[next] = distance[cur] + cost;
                    // System.out.println("distance[" + next + "] = " + distance[next]);
                }

            }

        }

        for (int i = 0; i < M; i++) {
            int[] temp = bus.get(i);
            if (distance[temp[0]] != INF && distance[temp[1]] > distance[temp[0]] +
                    temp[2]) {
                // System.out.println("음수 사이클 존재");
                return false;
            }

        }

        // for (int i = 2; i < distance.length; i++) {
        // if (distance[i] == INF) {
        // System.out.println("INF ");
        // } else {
        // System.out.println(distance[i]);
        // }
        // }
        return true;

    }
}
