import java.util.*;

public class Programmers_gameMapShortestDistance {
    // 동 서 남 북
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] visited;

    public static void bfs(int n, int m, int[][] maps) {

        visited = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });

        visited[0][0] = 1;

        // if (maps[n - 1][m - 2] == 0 && maps[n - 2][m - 1] == 0) {
        // return -1;
        // }

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();

            // if (cur[0] == n - 1 && cur[1] == m - 1) {
            // break;
            // } // 종료지점에 도착하면 종료

            // 전혀 도착하지 못할 시

            for (int i = 0; i < 4; i++) {

                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (maps[nx][ny] == 1 && visited[nx][ny] == 0) {

                    visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                    queue.add(new int[] { nx, ny });

                    // System.out.println(nx + " , " + ny + " => " + visited[nx][ny]);

                }
            }
        }

        // return visited[n - 1][m - 1];
    }

    public static int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        bfs(n, m, maps);

        return answer == 0 ? -1 : visited[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, {
                1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 } };
        // int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1, }, {
        // 1, 1, 1, 0, 0 },
        // { 0, 0, 0, 0, 1 } };
        System.out.println(solution(maps));
    }

}
