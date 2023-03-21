import java.util.*;
import java.io.*;

public class Baekjoon_11404_Floyd {
    static int n, m;
    static long[][] bus;
    // static int[][] bus;
    static int INF = 10000;

    public static void floyd() {

        for (int k = 1; k <= n; k++) {// 중간
            for (int i = 1; i <= n; i++) { // 시작
                for (int j = 1; j <= n; j++) { // 끝
                    bus[i][j] = Math.min(bus[i][j], bus[i][k] + bus[k][j]);

                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 도시 개수 = 정점
        m = Integer.parseInt(br.readLine()); // 버스 개수 = 간선

        bus = new long[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j)
                    bus[i][j] = 0;
                else
                    bus[i][j] = INF;
            }
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            bus[a][b] = Math.min(c, bus[a][b]);

        }

        floyd();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (bus[i][j] >= INF) {
                    System.out.print("0 ");
                }

                else {
                    System.out.print(bus[i][j] + " ");
                }
            }
            System.out.println();
        }

    }
}
