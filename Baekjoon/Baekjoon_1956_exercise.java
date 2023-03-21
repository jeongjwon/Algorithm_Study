import java.util.*;
import java.io.*;

public class Baekjoon_1956_exercise {
    static int V, E;
    static int[][] road;

    static int INF = 50000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        road = new int[V + 1][V + 1];

        for (int i = 0; i < V + 1; i++) {
            Arrays.fill(road[i], INF);

        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // road.get(a).add(new int[] { b, c });
            road[a][b] = c;
        }

        flyod();

        int distance = INF;

        for (int i = 1; i < V + 1; i++) {
            distance = Math.min(distance, road[i][i]);
        }

        if (distance >= INF)
            distance = -1;

        System.out.println(distance);

    }

    public static void flyod() {

        for (int k = 1; k < V + 1; k++) {
            for (int i = 1; i < V + 1; i++) {
                for (int j = 1; j < V + 1; j++) {
                    road[i][j] = Math.min(road[i][j], road[i][k] + road[k][j]);
                }
            }
        }
    }
}
