
import java.util.*;
import java.io.*;

public class Baekjoon_1012_Cabbage {
    static int m, n, k;
    static int[][] land;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int group;
    static ArrayList<Integer> result = new ArrayList<>();

    static void dfs(int x, int y) {
        visited[x][y] = true;
        // System.out.println("dfs(" + x + "," + y + ")");
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if (land[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                    // group++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());// 가로
            n = Integer.parseInt(st.nextToken());// 세로
            k = Integer.parseInt(st.nextToken());// 배추 개수
            land = new int[m][n];
            visited = new boolean[m][n];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                land[r][c] = 1;
            }
            // for (int i = 0; i < m; i++) {
            // for (int j = 0; j < n; j++) {
            // System.out.print(land[i][j] + " ");
            // }
            // System.out.println();
            // }
            group = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (land[i][j] == 1 && !visited[i][j]) {

                        group++;
                        dfs(i, j);
                        // result.add(group);
                    }

                }
            }
            sb.append(group).append("\n");
            // System.out.println(result.size());
        }
        System.out.println(sb);
        // for (int res : result)
        // System.out.println(res);
    }
}
