import java.util.*;
import java.io.*;

public class Baekjoon_7576_tomato {
    static int m, n, cnt = 0; // -1 = 토마토가 없는 갯수
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    static int[][] box;
    static Queue<int[]> queue = new LinkedList<>();

    static int bfs() {
        // 이미 큐에는 익은 토마토의 위치가 있음
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                // 왼오앞뒤의 위치로 날수를 체크
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (box[nx][ny] == 0) {
                        box[nx][ny] = box[temp[0]][temp[1]] + 1;
                        int[] next = { nx, ny };
                        queue.add(next);
                    }

                }
            }
        }
        // 가장 큰 수를 구해서 -1
        int date = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0)
                    return -1;

                System.out.print(box[i][j] + " ");
                date = Math.max(date, box[i][j]);
            }
            System.out.println();
        }
        return date - 1;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());// 가로
        n = Integer.parseInt(st.nextToken());// 세로
        box = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                box[i][j] = Integer.parseInt(str[j]);

                if (box[i][j] == 1) {
                    // 익은 토마토의 위치를 queue에 푸쉬
                    // -> 그래야 익는 속도를 동시에 체크가능
                    int[] pos = { i, j };

                    queue.add(pos);
                }
            }
        }
        System.out.println(bfs());

    }
}
