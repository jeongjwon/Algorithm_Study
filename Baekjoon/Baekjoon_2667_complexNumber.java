import java.util.*;
import java.io.*;

public class Baekjoon_2667_complexNumber {
    static int[][] graph;
    static boolean[][] visited;
    static ArrayList<Integer> result;
    static int n;

    // 상하좌우
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int complex = 1;

    static void dfs(int x, int y) {
        // System.out.println("dfs (" + x + ", " + y + ")");
        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {

                if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                    // graph[nx][ny] = complex;

                    dfs(nx, ny);
                    complex++;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        visited = new boolean[n][n];
        result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = str.charAt(j) - '0';

            }
        }
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print(graph[i][j] + " ");
        // }
        // System.out.println();
        // }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {

                    complex = 1; // 각 단지마다의 수
                    dfs(i, j);
                    result.add(complex);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int r : result) {
            System.out.println(r);
        }
    }
}
