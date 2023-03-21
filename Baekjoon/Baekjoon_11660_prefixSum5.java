import java.util.*;
import java.io.*;

public class Baekjoon_11660_prefixSum5 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 1
        // int[][] arr = new int[n][n];
        // int[][] sum = new int[n + 1][n + 1];

        // for (int i = 0; i < n; i++) {
        // st = new StringTokenizer(br.readLine());
        // for (int j = 0; j < n; j++) {
        // arr[i][j] = Integer.parseInt(st.nextToken());
        // if (i == 0 || j == 0)
        // sum[i][j] = 0;
        // }
        // }
        // for (int i = 1; i <= n; i++) {
        // for (int j = 1; j <= n; j++) {
        // sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + arr[i - 1][j - 1] - sum[i - 1][j
        // - 1];
        // }
        // }

        // for (int i = 0; i <= n; i++) {
        // for (int j = 0; j <= n; j++) {
        // System.out.print(sum[i][j] + " ");
        // }
        // System.out.println();
        // }

        // 2
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // System.out.println(sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 -
            // 1][y1 - 1]);
            int s = 0;
            for (int j = x1; j <= x2; j++) {
                s += dp[j][y2] - dp[j][y1 - 1];
            }
            // 1
            // sb.append(sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 -
            // 1]);
            // sb.append("\n");

            // 2
            sb.append(s);
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
