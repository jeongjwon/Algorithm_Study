import java.util.*;
import java.io.*;

public class Baekjoon_7562_Knight {
    static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };
    static int len;
    static int[] now, next;

    static int[][] chess;
    static int[][] visited;

    static int bfs(int[] xy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(xy);
        visited[xy[0]][xy[1]] = 1;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (temp[0] == next[0] && temp[1] == next[1]) {
                return visited[temp[0]][temp[1]] - 1;
            }
            for (int i = 0; i < 8; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < len && ny < len) {
                    if (visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[temp[0]][temp[1]] + 1;
                        int[] value = { nx, ny };
                        queue.add(value);
                    }
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            len = Integer.parseInt(br.readLine());
            chess = new int[len][len];
            visited = new int[len][len];
            now = new int[2];
            next = new int[2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            now[0] = Integer.parseInt(st.nextToken());
            now[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            next[0] = Integer.parseInt(st.nextToken());
            next[1] = Integer.parseInt(st.nextToken());

            // System.out.println(bfs(now));
            sb.append(bfs(now)).append("\n");
        }
        System.out.println(sb);
        // for (int i = 0; i < len; i++) {
        // for (int j = 0; j < len; j++) {
        // System.out.print(visited[i][j] + " ");
        // }
        // System.out.println();
        // }
    }
}
