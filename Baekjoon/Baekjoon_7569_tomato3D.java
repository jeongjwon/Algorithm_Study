
import java.util.*;
import java.io.*;

public class Baekjoon_7569_tomato3D {
    static int m, n, h;

    static int[] dx = { 0, 0, -1, 1, 0, 0 };
    static int[] dy = { -1, 1, 0, 0, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, -1, 1 };

    static int[][][] box;
    static Queue<int[]> queue = new LinkedList<>();

    static int bfs() {
        // 이미 큐에는 익은 토마토의 위치가 있음
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = temp[1] + dx[i];
                int ny = temp[2] + dy[i];
                int nz = temp[0] + dz[i];
                // 왼오앞뒤의 위치로 날수를 체크
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h) {
                    if (box[nz][nx][ny] == 0) {
                        box[nz][nx][ny] = box[temp[0]][temp[1]][temp[2]] + 1;
                        int[] next = { nz, nx, ny };
                        queue.add(next);
                    }

                }
            }
        }
        // 가장 큰 수를 구해서 -1
        int date = Integer.MIN_VALUE;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0)
                        return -1;

                    // System.out.print(box[i][j][k] + " ");
                    date = Math.max(date, box[i][j][k]);
                }

            }
            // System.out.println();
        }
        return date - 1;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());// 가로
        n = Integer.parseInt(st.nextToken());// 세로
        h = Integer.parseInt(st.nextToken());// 높이
        box = new int[h][n][m];

        for (int i = 0; i < h; i++) {

            for (int j = 0; j < n; j++) {
                String[] str = br.readLine().split(" ");
                for (int z = 0; z < str.length; z++) {
                    box[i][j][z] = Integer.parseInt(str[z]);
                    if (box[i][j][z] == 1) {
                        // 익은 토마토의 위치를 queue에 푸쉬
                        // -> 그래야 익는 속도를 동시에 체크가능
                        int[] pos = { i, j, z };

                        queue.add(pos);
                    }
                }

            }
        }
        System.out.println(bfs());

    }
}
