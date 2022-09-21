import java.util.*;
import java.io.*;

public class Baekjoon_2178_mazeSearch {
    static int n, m;
    static int[][] maze;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] visited;
    static int cnt = 0;

    static int bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        int[] location = { x, y };
        visited[x][y] = 1;
        queue.offer(location);

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            // 현재

            // System.out.println(now[0] + " , " + now[1]);
            if (now[0] == m - 1 && now[1] == n - 1)
                break;
            // 종료조건은 마지막 미로에 도착했을 때

            for (int k = 0; k < 4; k++) {
                // 현재 좌표에서 갈 수 있는 상하좌우 좌표 중
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {

                    if (maze[nx][ny] == 1 && visited[nx][ny] == 0) {

                        // System.out.println(nx + " , " + ny);
                        visited[nx][ny] = visited[now[0]][now[1]] + 1;
                        int[] future = { nx, ny };
                        queue.add(future);

                    }
                }

            }

        }
        return visited[n - 1][m - 1];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }

        }

        System.out.println(bfs(0, 0));

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {

        // System.out.print(visited[i][j] + " ");
        // }
        // System.out.println();
        // }

    }
}
